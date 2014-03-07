package kppv;
import java.util.ArrayList;

import classification.Apprentissage;


/****************************************************
 *                                                  *
 *  Cette classe est une ArrayList d'Apprentissage  *
 *                                                  *
 ****************************************************/ 

public class Voisins {
	
	/*******************Attributs************************/
	
	private ArrayList<Apprentissage> voisins;  
	
	
	/**********************Constructeur*********************/
	
	public Voisins(){
		this.voisins= new ArrayList<Apprentissage>();
	}
	
	
	
	
	/***********************Fonctions diverses*********************/
	
	public void add(Apprentissage apprentissage){
		this.voisins.add(apprentissage);
	}
	
	public void set(int index,Apprentissage apprentissage){
		this.voisins.set(index,apprentissage);
	}
	
	public Apprentissage get(int i){
		return this.voisins.get(i);
	}
	
	public int size(){
		return this.voisins.size();
	}
	
	

}
