package LeapTS;

import com.leapmotion.leap.Frame;

<<<<<<< HEAD
import classification.Cible;
=======
import classif.classification.Cible;
>>>>>>> pactHub/Adaboost2

public class LeapData extends FrameTS{

	/**************Attributs**************************/

	private Cible cible;

	
	
	/**********************Consctructeur******************/

	public LeapData(Frame frame, Cible cible){
		super(frame);
		this.cible = cible;
	}
	
	
	/*********************************Getters*****************/
	public Cible getCible(){
		return this.cible;
	}
}
