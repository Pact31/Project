package classification;

public class Point {
	
	private double x;
	private double y;
	private double z;
	
	public Point(double x,double y,double z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double getZ(){
		return z;
	}

	public double getDistance(Point point){
		return(Math.pow(Math.pow(this.x-point.getX(),2)+Math.pow(this.y-point.getY(),2)+Math.pow(this.z-point.getZ(),2),1/2));
	}



	public static void main(String[] args) {
		
	}
	
	
}
