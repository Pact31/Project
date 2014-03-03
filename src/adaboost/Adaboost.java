package adaboost;

import java.util.ArrayList;

import kppv.Entree;

public class Adaboost {
	private ArrayList<Weak> weakBase;
	private ArrayList<KnownMov> learningBase;
	private double[] corectors;
	
	private void learn(int T, double maxSeuil, int numSteps){
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
		
	}
	
	private ArrayList<KnownMov> acquireBase(String fileName){
		
	}
	
	public int predict(Entree e){
		Mouvement mov = new Mouvement(e);
		double aux = 0;
		for(int i = 0; i<this.corectors.length;i++){
			aux = aux + this.corectors[i]*this.weakBase.get(i).classify(mov);
		}
		if(aux>=0){
			return 1;
		}
		else{
			return -1;
		}
	}
	
	public Adaboost (String fileName, int T, double maxSeuil, int numSteps){
		this.learningBase=this.acquireBase(fileName);
		this.learn(T, maxSeuil, numSteps);
	}
}
