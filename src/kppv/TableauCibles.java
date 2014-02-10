package kppv;
import java.util.ArrayList;


public class TableauCibles {


	private ArrayList<Cible> tableauCibles;  

	public TableauCibles(){
		this.tableauCibles= new ArrayList<Cible>();
	}

	public void add(Cible cible){
		this.tableauCibles.add(cible);
	}

	public void set(int index,Cible cible){
		this.set(index,cible);
	}



}


