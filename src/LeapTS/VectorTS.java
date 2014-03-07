package LeapTS;

import java.io.Serializable;

import com.leapmotion.leap.Vector;

/**************************************
 *                                    *
 *       Vecteur a trois dimensions   *       
 *                                    *
 **************************************/

public class VectorTS implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private float x;
	private float y;
	private float z;
	
	
	public VectorTS(Vector vector){
		this.x=vector.get(0);
		this.y=vector.get(1);
		this.z=vector.get(2);
	}
	
	public VectorTS(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public float getZ(){
		return z;
	}
	
	public double getDistance(VectorTS vertex){
		return(Math.pow(Math.pow(this.x-vertex.getX(),2)+Math.pow(this.y-vertex.getY(),2)+Math.pow(this.z-vertex.getZ(),2),0.5));
	}
	
	public VectorTS minus(VectorTS vectorTS){
		
		float x,y,z;
		
		x = this.x - vectorTS.getX();
		y = this.y - vectorTS.getY();
		z = this.z - vectorTS.getZ();
		
		return new VectorTS(x,y,z);
	}

}
