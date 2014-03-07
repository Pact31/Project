package LeapTS;

import com.leapmotion.leap.Frame;

import classif.classification.Cible;

public class LeapData extends FrameTS{

	private Cible cible;
	
	public LeapData(Frame frame, Cible cible){
		super(frame);
		this.cible = cible;
	}
	
	public Cible getCible(){
		return this.cible;
	}
}
