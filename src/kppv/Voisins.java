package kppv;
import java.util.ArrayList;

import classification.Apprentissage;


public class Voisins {
	
	private ArrayList<Apprentissage> voisins;  
	
	public Voisins(){
		this.voisins= new ArrayList<Apprentissage>();
	}
	
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
