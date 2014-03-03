package kppv;
import java.util.ArrayList;

import classification.Cible;


public class TableauCibles {


	private ArrayList<Cible> tableauCibles;  

	public TableauCibles(){
		this.tableauCibles= new ArrayList<Cible>();
	}

	public void add(Cible cible){
		this.tableauCibles.add(cible);
	}

	public void set(int index,Cible cible){
		this.tableauCibles.set(index,cible);
	}
	
	public Cible get(int i){
		return this.tableauCibles.get(i);
	}

	public int size() {
		
		return this.tableauCibles.size();
	}
}


