package classif.kppv;
import java.util.ArrayList;

import classif.Cible;


public class TableauCibles {

	/********************Attributs**********************/
	
	private ArrayList<Cible> tableauCibles;  

	
	
	/*****************Comnstructeur***********************/
	
	public TableauCibles(){
		this.tableauCibles= new ArrayList<Cible>();
	}

	
	/****************Fonctions diverses******************/
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


