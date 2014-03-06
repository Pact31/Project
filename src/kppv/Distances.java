package kppv;
import java.util.ArrayList;

<<<<<<< HEAD
/***********************************************************
 * cette classe est un tableau de distance qui permet      *
 * de stocker les distances de l'entree aux differents     *
 * objets de la base de donnees                            *
 * *********************************************************/
=======
/*cette classe est un tableau de distance qui permet 
 * de stocker les distances de l'entrée aux différents 
 * objets de la base de données*/
>>>>>>> hassen

public class Distances {

	private ArrayList<Double> distances;  

	public Distances(){
<<<<<<< HEAD
		this.distances= new ArrayList<Double>();
=======
		this.distances= new ArrayList<Double> ();
>>>>>>> hassen
	}

	/*ajout d'une distance au tableau*/
	public void add(double n){
		this.distances.add(n);
	}

	/*renvoie l'élément à l'indice n*/
<<<<<<< HEAD
	public double get(int n){
		return this.distances.get(n);
=======
	public int get(int n){
		return this.get(n);
>>>>>>> hassen
	}

	/*renvoie la taille du tableau*/
	private int size() {
		return this.distances.size();
	}

	/*modifie un élément du tableau*/
	public void set(int index,double nouveau){
<<<<<<< HEAD
		this.distances.set(index,nouveau);
	}
	
	/*renvoie l'indice de la distance la plus petite*/
	public int indiceLePlusLoin(){
=======
		this.set(index,nouveau);
	}
	
	/*renvoie l'indice de la distance la plus petite*/
	public int indiceLePlusPres(){
>>>>>>> hassen

		int pivot=0;
		double p=this.get(pivot);
		for (int i=0;i<this.size();i++){
			if (this.get(i)>p){ 
				pivot=i;
				p=this.get(pivot);
			}
		}

		return pivot;
	}

}

