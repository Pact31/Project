package LeapTS;

import java.io.Serializable;

import com.leapmotion.leap.Finger;


/********************************************
 *                                          *
 *       Implémente les doigts de maniere   *       
 *       a ce qu'ils soient serializables   *
 *                                          *
 ********************************************/

public class FingerTS implements Serializable{
	
	/**************Attributs**************************/
	
	private static final long serialVersionUID = 1L;
	private VectorTS direction;
	private int id;
	private float length;
	private VectorTS tipPosition;
	private VectorTS tipVelocity;
	private float touchDistance;
	private float width;
	
	
	
	/**********************Consctructeur******************/
	
	public FingerTS(Finger finger){
		this.direction = new VectorTS(finger.direction());
		this.id = finger.id();
		this.length = finger.length();
		this.tipPosition = new VectorTS(finger.tipPosition());
		this.tipVelocity = new VectorTS(finger.tipVelocity());
		this.touchDistance = finger.touchDistance();
		this.width = finger.width();
	}

	
	
	/*****************Getters**************************************/
	
	public VectorTS getDirection() {
		return direction;
	}

	public int getId() {
		return id;
	}

	public float getLength() {
		return length;
	}

	public VectorTS getTipPosition() {
		return tipPosition;
	}

	public VectorTS getTipVelocity() {
		return tipVelocity;
	}

	public float getTouchDistance() {
		return touchDistance;
	}

	public float getWidth() {
		return width;
	}
	
	

}
