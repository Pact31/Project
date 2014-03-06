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
	private double x;
	private double y;
	private double z;
	
	
	public VectorTS(Vector vector){
		this.x=vector.get(0);
		this.y=vector.get(1);
		this.z=vector.get(2);
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

}
