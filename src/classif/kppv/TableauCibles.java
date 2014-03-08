package classif.kppv;
import java.util.ArrayList;

<<<<<<< HEAD:src/kppv/TableauCibles.java
import classification.Cible;
=======
import classif.classification.Cible;
>>>>>>> pactHub/Adaboost2:src/classif/kppv/TableauCibles.java


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


