package kppv;
import java.util.ArrayList;

/*cette classe est un tableau de distance qui permet 
 * de stocker les distances de l'entrée aux différents 
 * objets de la base de données*/

public class Distances {

	private ArrayList<Integer> distances;  

	public Distances(){
		this.distances= new ArrayList<Integer>();
	}

	/*ajout d'une distance au tableau*/
	public void add(int n){
		this.distances.add(n);
	}

	/*renvoie l'élément à l'indice n*/
	public int get(int n){
		return this.distances.get(n);
	}

	/*renvoie la taille du tableau*/
	private int size() {
		return this.distances.size();
	}

	/*modifie un élément du tableau*/
	public void set(int index,int nouveau){
		this.distances.set(index,nouveau);
	}
	
	/*renvoie l'indice de la distance la plus petite*/
	public int indiceLePlusLoin(){

		int pivot=0;
		int p=this.get(pivot);
		for (int i=0;i<this.size();i++){
			if (this.get(i)>p){ 
				pivot=i;
				p=this.get(pivot);
			}
		}

		return pivot;
	}

}

