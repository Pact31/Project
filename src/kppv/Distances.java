package kppv;
import java.util.ArrayList;


public class Distances {

	private ArrayList<Integer> distances;  

	public Distances(){
		this.distances= new ArrayList<Integer>();
	}

	public void add(int n){
		this.distances.add(n);
	}

	public int get(int n){
		return this.get(n);
	}

	private int size() {
		return this.size();
	}

	public void set(int index,int nouveau){
		this.set(index,nouveau);
	}
	
	
	public int indiceLePlusPres(){

		int pivot=0;
		int p=this.get(pivot);
		for (int i=0;i<this.size();i++){
			if (this.get(i)<p){ 
				pivot=i;
				p=this.get(pivot);
			}
		}

		return pivot;
	}

}

