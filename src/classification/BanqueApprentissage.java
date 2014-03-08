package classification;
import java.util.ArrayList;
import java.util.Iterator;

import kppv.Distances;
import kppv.Voisins;
import LeapTS.LeapData;
import leapmotion.LeapDataBase;

/*******************************************************************************************
 *   BanqueApprentissage est une ArrayList d'Apprentissages                                * 
 *                                                                                         *
 *    CONSTRUCTEUR : - Creation d'une nouvelle base vide                                   *
 *    				 - Importation d'une base a partir d'une base de dnnees LeapDataBase   *
 *                                                                                         *
 * *****************************************************************************************/


public class BanqueApprentissage implements Iterator<Apprentissage>{

	/*****************Attributs**************************/
	
	private ArrayList<Apprentissage> banque;
	private Iterator<Apprentissage> iterator;

	
	
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
	
	public BanqueApprentissage(String file) throws Exception{
		LeapDataBase leapDataBase = new LeapDataBase(file);
		this.banque=new ArrayList<Apprentissage>();
		for(LeapData leapData : leapDataBase.table){
			Apprentissage apprentissage = new Apprentissage(leapData, leapData.getCible());
			this.banque.add(apprentissage);
		}
	}
	
	public Iterator<Apprentissage> iterator(){
		this.iterator = banque.iterator();
		return this.iterator;
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

	
		//Donne le nombre de representants de chaque cible parmis les k plus proches voisins
	public int[] countCible(int k, Entree entree){
		Apprentissage pivot;
		Voisins v=getVoisins(k, entree);
		int compteur[]={0,0,0,0,0,0,0,0};
		Cible c[]=Cible.values();
		for(int i =0; i<v.size();i=i+1){
			pivot=v.get(i);
			int p=0;
			while(pivot.getCible().equals(c[p])==false && p<8) p=p+1;
			compteur[p]=compteur[p]+1;
		}
		return compteur;
	}
	
	
	/****************Iterator*******************/
	public boolean hasNext(){
		return iterator.hasNext();
	}
	
	public Apprentissage next(){
		return iterator.next();
	}
	
	public void remove(){
		iterator.remove();
	}
}
