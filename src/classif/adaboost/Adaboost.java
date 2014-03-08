package classif.adaboost;

import java.util.ArrayList;

import classif.ClassifierInterface;
import classif.classification.BanqueApprentissage;
import classif.classification.Cible;
import classif.classification.Entree;

public class Adaboost implements ClassifierInterface {
	private int numOfCarac;
	private int numOfClasses;
	private ArrayList<ArrayList<Weak>> strongClassif;
	private ArrayList<KnownMov> learningBase;
	private double[][] corectors;
	
	private void learn(int T){
		
		for(int k = 0; k<numOfClasses; k++){
			
			int[] prob = this.createBinaryProblem(k);
			
			double[] distrib = new double[this.learningBase.size()];
			
			for(int i = 0; i<distrib.length; i++){//init de la distrib
				distrib[i]=1/distrib.length;
			}
			
			for(int j= 0; j<T; j++){//boucle d'apprentissage
				
				double minError = 1;//ca sera l'erreur mini pour cette iteration, on l'init a 1 (erreur maximale)
				Weak bestWeak = new Weak(0, 0, 1);//sera le meilleur classifieur faible pour cette iteration
				
				for(int m = 0; m<this.numOfCarac; m++){
					for(int h=0; h<2; h++){
						for(int n = 0; n<this.learningBase.size(); n++){//on teste tout les classifieurs possibles
							
							double currentError = 0;
							Weak w = new Weak(m,this.learningBase.get(n).getMov().getCar()[m], (-1)^h);//on cree un nouveau classifieur faible avec un certain seuil
							
							for(int l=0; l<this.learningBase.size(); l++){//on calcule l'erreur faite par ce classifieur
								
								if(w.classify(this.learningBase.get(l).getMov().getCar())!=prob[l]){
									currentError = currentError + distrib[l];
								}	
							}
							if(currentError<minError){//si on a trouvé une meilleur erreur mini on la recupere ainsi que le classifieur
								minError = currentError;
								bestWeak = w;
							}
						}
					}
				}
				this.strongClassif.get(k).add(bestWeak);
				this.corectors[k][j]=(Math.log((1-minError)/minError))/2;
				
				double norm = 0;//sera la somme de la distrib (pour la normalisation)
				for(int i = 0; i<distrib.length; i++){//on maj la distrib
						distrib[i]=distrib[i]*Math.exp(-this.corectors[k][j]*bestWeak.classify(this.learningBase.get(i).getMov().getCar())*this.learningBase.get(i).getClasse());
						norm = norm + distrib[i];
				}
				for(int i = 0; i<distrib.length; i++){//on normalise la distrib
					distrib[i]=distrib[i]/norm;
				}
			}
		}
	}
	
	//je garde ça au cas où
	
	/*private void learn(int T){

		
		double[] distrib = new double[this.learningBase.size()];
		
		for(int i = 0; i<distrib.length; i++){//init de la distrib
			distrib[i]=1/distrib.length;
		}
		
		for(int j= 0; j<T; j++){//boucle d'apprentissage
			
			double minError = 1;//ca sera l'erreur mini pour cette iteration, on l'init a 1 (erreur maximale)
			Weak bestWeak = new Weak(maxSeuil, Math.PI/3.5);//sera le meilleur classifieur faible pour cette iteration
			
			for(int k = 1; k<=numSteps; k++){//on teste tout les classifieurs possibles
				
				double currentError = 0;
				Weak w = new Weak(k*maxSeuil/numSteps, Math.PI/3.5);//on cree un nouveau classifieur faible avec un certain seuil
				
				for(int l=0; l<this.learningBase.size(); l++){//on calcule l'erreur faite par ce classifieur
					
					if(w.classify(this.learningBase.get(l).getMov())!=this.learningBase.get(l).getClasse()){
						currentError = currentError + distrib[l];
					}	
				}
				if(currentError<minError){//si on a trouvé une meilleur erreur mini on la recupere ainsi que le classifieur
					minError = currentError;
					bestWeak = w;
				}
			}
			this.weakBase.add(bestWeak);
			this.corectors[j]=(Math.log((1-minError)/minError))/2;
			
			double norm = 0;//sera la somme de la distrib (pour la normalisation)
			for(int i = 0; i<distrib.length; i++){//on maj la distrib
					distrib[i]=distrib[i]*Math.exp(-this.corectors[j]*bestWeak.classify(this.learningBase.get(i).getMov())*this.learningBase.get(i).getClasse());
					norm = norm + distrib[i];
			}
			for(int i = 0; i<distrib.length; i++){//on normalise la distrib
				distrib[i]=distrib[i]/norm;
			}
		}
		
	}*/
	
	private void acquireBase(BanqueApprentissage b){
		for(int i = 0; i<b.size(); i++){
			this.learningBase.add(new KnownMov(b.getApprentissage(i)));
		}
	}
	
	public int predictClassOf(Entree e){
		Mouvement mov = new Mouvement(e);
		double[] reply = new double[this.strongClassif.size()];
		for(int j = 0; j<this.strongClassif.size(); j++){
			double aux = 0;
			for(int i = 0; i<this.corectors[j].length;i++){
				aux = aux + this.corectors[j][i]*this.strongClassif.get(j).get(i).classify(mov.getCar());
			}
			reply[j]=aux;
		}
		int rep = 0;
		for(int k = 0; k<this.strongClassif.size(); k ++){
			if(reply[k]>reply[rep]){
				rep=k;
			}
		}
		return rep;
	}
	
	private int[] createBinaryProblem(int k){
		int[] newProb = new int[this.learningBase.size()];
		if(k<this.numOfClasses){
			for(int i = 0; i<newProb.length; i ++){
				if(this.learningBase.get(i).getClasse()==k){
					newProb[i]=1;
				}
				else{
					newProb[i]=-1;
				}
			}
		}
		return newProb;
	}
	
	public Adaboost (BanqueApprentissage b, int T){
		this.acquireBase(b);
		this.numOfCarac = this.learningBase.get(0).getMov().getCar().length;
		this.numOfClasses=0;
		for(int i = 0; i<this.learningBase.size(); i++){
			if(this.learningBase.get(i).getClasse()>this.numOfClasses){
				this.numOfClasses=this.learningBase.get(i).getClasse();
			}
		}
		this.numOfClasses++;
		this.corectors = new double[this.numOfClasses][T];
		this.learn(T);
	}
	public Cible predict(Entree e) throws Exception{
		int k = this.predictClassOf(e);
		return Cible.values()[k];
	}
	
}
