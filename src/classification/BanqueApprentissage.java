package classification;
import java.util.ArrayList;

import kppv.Distances;
import kppv.Kppv;
import kppv.Voisins;
import LeapTS.LeapData;
import leapmotion.LeapDataBase;

/*******************************************************************************************
 *   BanqueApprentissage est une ArrayList d'Apprentissages                                * 
 *                                                                                         *
 *    CONSTRUCTEUR : - Creation d'une nouvelle base vide                                   *
 *    				 - Importation d'une base a partir d'une base de dnnees LeapDataBase   *
 * *****************************************************************************************/


public class BanqueApprentissage {

	/*****************Attributs**************************/
	
	private ArrayList<Apprentissage> banque;

	
	
	/*****************Constructeurs**********************/
	
	public BanqueApprentissage(){
		this.banque=new ArrayList<Apprentissage>();
	}
	
	public BanqueApprentissage(LeapDataBase leapDataBase){
		this.banque=new ArrayList<Apprentissage>();
		for(LeapData leapData : leapDataBase.table){
			Apprentissage apprentissage = new Apprentissage(leapData, leapData.getCible());
			this.banque.add(apprentissage);
		}
	}
	
	
	
	/******************Getters*****************************/
	
	public ArrayList<Apprentissage> getAllApprentissage(){
		return banque;
	}

	public Apprentissage getApprentissage(int i){
		return this.banque.get(i);
	}
	
	
	
	/*******************Methodes diverses*******************/
	
		//Ajouter un element a la base
	public void addApprentissage(Apprentissage apprentissage){
		this.banque.add(apprentissage);
	}

		//Taille de la base
	public int size(){
		return this.banque.size();
	}

		//donne les k plus proches voisins d'une entree
	public Voisins getVoisins(int k, Entree entree){
	
		Voisins v=new Voisins();
		Distances d=new Distances();
		double dist = 1000;
		int indiceDist=0;
	
		for (int i=0; i<k; i++){
			v.add(getApprentissage(i));
			d.add(entree.getDistance(getApprentissage(i)));
		}
	
		for (int i=k; i<size(); i++){
			indiceDist=d.indiceLePlusLoin();
			dist=d.get(indiceDist);
			if(entree.getDistance(getApprentissage(i))<dist){
				v.set(indiceDist,getApprentissage(i));
				d.set(indiceDist,entree.getDistance(getApprentissage(i)));
			}
		}
		return v;
	}

	public int[] countCible(Kppv kppv, Entree entree){
		Apprentissage pivot;
		Voisins v=getVoisins(kppv.k, entree);
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
}
