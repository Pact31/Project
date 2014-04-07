package LeapTS;

import leapmotion.LetterException;

import com.leapmotion.leap.Frame;

import classif.Cible;

public class LeapData extends FrameTS{


	private static final long serialVersionUID = 1L;
	/**************Attributs**************************/

	private Cible cible;

	
	
	/**********************Consctructeur******************/

	public LeapData(Frame frame, Cible cible){
		super(frame);
		this.cible = cible;
	}
	
		public LeapData( Frame frame,char inChar) throws IllegalArgumentException, NullPointerException, LetterException{
		super(frame);
		switch(inChar){
		case 'a' : 
			this.cible = Cible.PDJ;
			break;
		case 'z':
			this.cible = Cible.KVZ;
			break;
		case 'e':
			this.cible = Cible.SR;
			break;
		case 'r':
			this.cible = Cible.G;
			break;
		case 't':
			this.cible = Cible.ICHGNW;
			break;
		case 'y': 			
			this.cible = Cible.MTF;
			break;
		case 'u': 
			this.cible = Cible.YNG;
			break;
		case 'i':
			this.cible = Cible.BNUI;
			break;
		default: 
			throw (new LetterException(inChar));
			
		}
	}
	
	
	/*********************************Getters*****************/
	public Cible getCible(){
		return this.cible;
	}
}
