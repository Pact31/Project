package kppv;

import classification.Apprentissage;
import classification.BanqueApprentissage;
import classification.Cible;
import classification.Entree;

public class Kppv {

	private BanqueApprentissage banque;
	private int k; 

	public Kppv(BanqueApprentissage banque, int k){
		this.banque=banque;
		this.k=k;
	}



	public double getDistance(Apprentissage element, Entree entree){

		return (entree.getD1().getDistance(element.getD1())
				+entree.getD2().getDistance(element.getD2())
				+entree.getD3().getDistance(element.getD3())
				+entree.getD4().getDistance(element.getD4())
				+entree.getD5().getDistance(element.getD5())
				+entree.getM().getDistance(element.getM()));

	}


	public Voisins getVoisins(Entree entree){

		Voisins v=new Voisins();
		Distances d=new Distances();
		double dist = 1000;
		int indiceDist=0;

		for (int i=0; i<this.k; i++){
			v.add(banque.getApprentissage(i));
			d.add(this.getDistance(banque.getApprentissage(i),entree));
		}

		for (int i=k; i<this.banque.size(); i++){
			indiceDist=d.indiceLePlusLoin();
			dist=d.get(indiceDist);
			if(this.getDistance(banque.getApprentissage(i),entree)<dist){
				v.set(indiceDist,banque.getApprentissage(i));
				d.set(indiceDist,this.getDistance(banque.getApprentissage(i),entree));
			}
		}
		return v;
	}


	public int[] countCible(Entree entree){


		Apprentissage pivot;
		Voisins v=this.getVoisins(entree);
		int compteur[]={0,0,0,0,0,0,0,0};
		Cible c[]=Cible.values();
		for(int i =0; i<v.size();i=i+1){
			pivot=v.get(i);
			int k=0;
			while(pivot.getCible().equals(c[k])==false && k<8) k=k+1;
			compteur[k]=compteur[k]+1;
		}
		return compteur;
	}


	public Cible kppv(Entree entree){

		
		int compteur[]=this.countCible(entree);
		int indice=0;
		int pivot=compteur[0];
		for (int i=0;i<8;i=i+1){
			if (compteur[i]>pivot){
				pivot=compteur[i];
				indice=i;
			}
		}
		return Cible.values()[indice];
		
		
	}



}
























