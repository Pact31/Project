package LeapTS;

import java.io.Serializable;

import com.leapmotion.leap.Hand;

/********************************************
 *                                          *
 *       Implémente les mains de maniere    *       
 *       a ce qu'ils soient serializables   *
 *                                          *
 ********************************************/

public class HandTS implements Serializable {
	
	/**************Attributs**************************/

	private static final long serialVersionUID = 1L;
	private int id;
	private VectorTS palmNormal;
	private VectorTS palmVelocity;
	private VectorTS palmPosition;
	private VectorTS sphereCenter;
	private float sphereRadius;
	
	
	/**********************Consctructeur******************/

	public HandTS(Hand hand){
		
		this.id = hand.id();
		this.palmNormal = new VectorTS(hand.palmNormal());
		this.palmVelocity = new VectorTS(hand.palmVelocity());
		this.palmPosition = new VectorTS(hand.palmPosition());
		this.sphereCenter = new VectorTS(hand.sphereCenter());
		this.sphereRadius = hand.sphereRadius();
	}

	
	/*****************************************Getters*****************************/
	
	public int getId() {
		return id;
	}

	public VectorTS getPalmNormal() {
		return palmNormal;
	}

	public VectorTS getPalmVelocity() {
		return palmVelocity;
	}

	public VectorTS getPalmPosition() {
		return palmPosition;
	}

	public VectorTS getSphereCenter() {
		return sphereCenter;
	}

	public float getSphereRadius() {
		return sphereRadius;
	}
	
	
	

}
