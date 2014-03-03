package classif.adaboost;

public class Weak {
	private int numOfCarac;
	private double seuil;
	private int side;
	
	public Weak(int numOfCarac, double seuil, int side) {
		this.numOfCarac = numOfCarac;
		this.seuil = seuil;
		this.side = side;
	}

	public int classify(double[] vect){
		if(vect[this.numOfCarac]>=this.seuil){
			return 1*this.side;
		}
		else{
			return -1*this.side;
		}
		
	}
	
	
	
}
