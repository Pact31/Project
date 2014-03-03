package adaboost;

public class Weak {
	private double seuilInf;
	private double seuilSup;

	public Weak(double seuilInf, double seuilSup) {
		this.seuilInf = seuilInf;
		this.seuilSup = seuilSup;
	}
	
	public int classify(Mouvement mov){
		if(mov.getNumFingers()==2&&mov.getAngle()>=this.seuilInf&&mov.getAngle()<=this.seuilSup){
			return 1;
		}
		else{
			return -1;
		}
		
	}
	
	
	
}
