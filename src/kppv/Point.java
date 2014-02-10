package kppv;

public class Point {
	
	private int x;
	private int y;
	private int z;
	
	public Point(int x,int y,int z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getZ(){
		return z;
	}

	public int getDistance(Point point){
		return(((this.x-point.getX())^2+(this.y-point.getY())^2+(this.z-point.getZ())^2)^(1/2));
	}
	
}
