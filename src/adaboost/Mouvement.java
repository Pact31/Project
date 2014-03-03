package adaboost;

import kppv.Entree;

public class Mouvement {
	private int numFingers;
	private double angle;
	
	public Mouvement(Entree e) {
		int count = 0;
		if(e.getD1().getX()!=0||e.getD1().getY()!=0||e.getD1().getZ()!=0){
			count++;
		}
		if(e.getD2().getX()!=0||e.getD2().getY()!=0||e.getD2().getZ()!=0){
			count++;
		}
		if(e.getD3().getX()!=0||e.getD3().getY()!=0||e.getD3().getZ()!=0){
			count++;
		}
		if(e.getD4().getX()!=0||e.getD4().getY()!=0||e.getD4().getZ()!=0){
			count++;
		}
		if(e.getD5().getX()!=0||e.getD5().getY()!=0||e.getD5().getZ()!=0){
			count++;
		}
		this.numFingers = count;
		if((e.getD1().getX()!=0||e.getD1().getY()!=0||e.getD1().getZ()!=0)&&(e.getD2().getX()!=0||e.getD2().getY()!=0||e.getD2().getZ()!=0)){
			double X1=(e.getD1().getX()-e.getM().getX());
			double Y1=(e.getD1().getY()-e.getM().getY());
			double Z1=(e.getD1().getZ()-e.getM().getZ());
			double X2=(e.getD2().getX()-e.getM().getX());
			double Y2=(e.getD2().getY()-e.getM().getY());
			double Z2=(e.getD2().getZ()-e.getM().getZ());
			
			double length1 = Math.sqrt(Math.pow(X1, 2)+Math.pow(Y1, 2)+Math.pow(Z1, 2));
			double length2 = Math.sqrt(Math.pow(X2, 2)+Math.pow(Y2, 2)+Math.pow(Z2, 2));
			double product = X1*X2+Y1*Y2+Z1*Z2;
			double cos = Math.abs(product/(length1*length2));
			this.angle = Math.acos(cos);
		}
		else{
			this.angle=0;
		}
	}

	public int getNumFingers() {
		return numFingers;
	}

	public double getAngle() {
		return angle;
	}
	
	
}
