package classif.adaboost;

import java.util.ArrayList;

import classif.BanqueApprentissage;
import classif.Cible;
import classif.Classificateur;
import classif.Entree;

<<<<<<< HEAD


=======
>>>>>>> pactHub/Adaboost2
public class Adaboost extends Classificateur{
	private int numOfCarac;
	private int numOfClasses;
	private ArrayList<ArrayList<Weak>> strongClassif;
	private ArrayList<KnownMov> learningBase;
	private double[][] corectors;
	private int T;
	
	
	private void learn(int T){
		
		//System.out.println("number of Classes:" + numOfClasses);
		for(int k = 0; k<numOfClasses; k++){
			//System.out.println("Classe : "+k);
			int[] prob = this.createBinaryProblem(k);
			
			double[] distrib = new double[this.learningBase.size()];
			
			for(int i = 0; i<distrib.length; i++){//init de la distrib
				distrib[i]=1.0/distrib.length;
			}
			
			for(int j= 0; j<T; j++){//boucle d'apprentissage
				
<<<<<<< HEAD
				double minError = 1.0;//ca sera l'erreur mini pour cette iteration, on l'init a 1 (erreur maximale)
				Weak bestWeak = new Weak(0, 0.0, 0);//sera le meilleur classifieur faible pour cette iteration
				
				//System.out.println("number of Carac:" + this.numOfCarac);
				for(int m = 0; m<this.numOfCarac; m++){
					for(int h=0; h<2; h++){
						//System.out.println("learningBase:" + this.learningBase.size());
						for(int n = 0; n<this.learningBase.size(); n++){//on teste tout les classifieurs possibles
							
							double currentError = 0.0;
							Weak w = new Weak(m,this.learningBase.get(n).getMov().getCar()[m], (-1)^h);//on cree un nouveau classifieur faible avec un certain seuil
							
							for(int l=0; l<this.learningBase.size(); l++){//on calcule l'erreur faite par ce classifieur
								
								if(w.classify(this.learningBase.get(l).getMov().getCar())!=prob[l]){
									currentError = currentError + distrib[l];
								}
								
							}
							if(currentError<minError && currentError<0.5){//si on a trouvé une meilleur erreur mini on la recupere ainsi que le classifieur
								minError = currentError;
								bestWeak = w;
							}
						}
					}
				}
				
				//System.out.println(minError);
=======
				Weak bestWeak = this.getBestWeak(distrib, prob);
				double minError = this.calculateError(distrib, bestWeak, prob);
				
>>>>>>> pactHub/Adaboost2
				this.strongClassif.get(k).add(bestWeak);
				this.corectors[k][j]=(Math.log((1-minError)/minError))/2;
				
				double norm = 0;//sera la somme de la distrib (pour la normalisation)
				for(int i = 0; i<distrib.length; i++){//on maj la distrib
<<<<<<< HEAD
					distrib[i]=distrib[i]*Math.exp(-this.corectors[k][j]*bestWeak.classify(this.learningBase.get(i).getMov().getCar())*prob[i]);
					norm = norm + distrib[i];
=======
						distrib[i]=distrib[i]*Math.exp(-this.corectors[k][j]*bestWeak.classify(this.learningBase.get(i).getMov().getCar())*prob[i]);
						norm = norm + distrib[i];
>>>>>>> pactHub/Adaboost2
				}
				for(int i = 0; i<distrib.length; i++){//on normalise la distrib
					distrib[i]=distrib[i]/norm;
				}
			}
		}
	}
	
	private double calculateError(double[] distrib, Weak weak, int[] prob){
		double error = 0;
		for(int l=0; l<this.learningBase.size(); l++){//on calcule l'erreur faite par ce classifieur
				if(weak.classify(this.learningBase.get(l).getMov().getCar())!=prob[l]){
				error = error + distrib[l];
			}	
		}
		return error;
	}
	
	private Weak getBestWeak(double[] distrib, int[] prob){
		double minError = 1.0;//ca sera l'erreur mini pour cette iteration, on l'init a 1 (erreur maximale)
		Weak bestWeak = new Weak(0, 0.0, 0);//sera le meilleur classifieur faible pour cette iteration
		
		for(int m = 0; m<this.numOfCarac; m++){
			for(int h=0; h<2; h++){
				for(int n = 0; n<this.learningBase.size(); n++){//on teste tout les classifieurs possibles
					
					Weak w = new Weak(m,this.learningBase.get(n).getMov().getCar()[m], (-1)^h);//on cree un nouveau classifieur faible avec un certain seuil
					double currentError = this.calculateError(distrib, w, prob);
					
					if(currentError<minError && currentError<0.5){//si on a trouvé une meilleur erreur mini on la recupere ainsi que le classifieur
						minError = currentError;
						bestWeak = w;
					}
				}
			}
		}
		return bestWeak;
	}
	
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
				//System.out.println(corectors[j][i]);
				aux = aux + this.corectors[j][i]*this.strongClassif.get(j).get(i).classify(mov.getCar());
			}
			reply[j]=aux;
			System.out.println(reply[j]);
		}
		int rep = 0;
		for(int k = 0; k<this.strongClassif.size(); k ++){
			//System.out.println(reply[k]);
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
		super(b);
<<<<<<< HEAD
=======
		this.T = T;
>>>>>>> pactHub/Adaboost2
		this.learningBase = new ArrayList<KnownMov>();
		this.acquireBase(b);
		this.numOfCarac = this.learningBase.get(0).getMov().getCar().length;
		this.numOfClasses=0;
		//System.out.println(learningBase.size());
		for(int i = 0; i<this.learningBase.size(); i++){
			if(this.learningBase.get(i).getClasse()>this.numOfClasses){
				this.numOfClasses=this.learningBase.get(i).getClasse();
			}
		}
		//System.out.println(this.numOfClasses);
		
		this.numOfClasses++;
		this.corectors = new double[this.numOfClasses][T];
		this.strongClassif = new ArrayList<ArrayList<Weak>>();
		for(int i =0; i<this.numOfClasses; i++){
			this.strongClassif.add(new ArrayList<Weak>());
		}
<<<<<<< HEAD
		this.learn(T);
	}

=======
		this.learn(this.T);
	}
	
	@Override
>>>>>>> pactHub/Adaboost2
	public Cible classifier(Entree e){
		int k = this.predictClassOf(e);
		return Cible.values()[k];
	}

	
	@Override
	public void setBanque(BanqueApprentissage banque){
		this.banque = banque;
		ArrayList<KnownMov> b = new ArrayList<KnownMov>();
		for(int i = 0; i<banque.size(); i++){
			b.add(new KnownMov(banque.getApprentissage(i)));
		}
		this.learningBase = b;
		this.learn(this.T);
	}
	
	
}
