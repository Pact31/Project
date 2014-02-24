package kppv;

import com.leapmotion.leap.Vector;

public class Vertex extends Vector {
	
	/*private int x;
	private int y;
	private int z;
	
	public Vertex(int x,int y,int z){
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
	*/
	public double getDistance(Vertex vertex){
		return(Math.pow(Math.pow(this.getX()-vertex.getX(),2)+Math.pow(this.getY()-vertex.getY(),2)+Math.pow(this.getY()-vertex.getY(),2),1/2));

	}
}