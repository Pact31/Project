package kppv;

public class Vertex {
	
	private int x;
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
	
	public int getDistance(Vertex vertex){
		return(((this.x-vertex.getX())^2+(this.y-vertex.getY())^2+(this.z-vertex.getZ())^2)^(1/2));
	}

}
