package classification;

/**************************************
 *                                    *
 *       Vecteur a trois dimensions   *       
 *                                    *
 **************************************/

public class Vertex {
	
	private double x;
	private double y;
	private double z;
	
	
	public Vertex(int x,int y,int z){
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
	
	public double getDistance(Vertex vertex){
		return(Math.pow(Math.pow(this.x-vertex.getX(),2)+Math.pow(this.y-vertex.getY(),2)+Math.pow(this.z-vertex.getZ(),2),0.5));
	}

}
