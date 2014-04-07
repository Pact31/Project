package LeapTS;

import leapmotion.LetterException;
import leapmotion.NumberException;

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
	
		public LeapData( Frame frame,char inChar, int inPos) throws IllegalArgumentException, NullPointerException, LetterException, NumberException{
		super(frame);
		switch(inChar){
		case 'a' : 
			switch(inPos){
			case 1 :
				this.cible = Cible.YNG_G;
				break;
			case 2 :
				this.cible = Cible.YNG_M;
				break;
			case 3 : 
				this.cible = Cible.YNG_B;
				break;
			case 4 :
				this.cible = Cible.YNG_C;
				break;
			case 5 : 
				this.cible = Cible.YNG_P;
				break;
			default :
				throw(new NumberException (inPos));
			}
			break;
		case 'z':
			switch(inPos){
			case 1 :
				this.cible = Cible.KVZ_G;
				break;
			case 2 :
				this.cible = Cible.KVZ_M;
				break;
			case 3 : 
				this.cible = Cible.KVZ_B;
				break;
			case 4 :
				this.cible = Cible.KVZ_C;
				break;
			case 5 : 
				this.cible = Cible.KVZ_P;
				break;
			default :
				throw(new NumberException (inPos));
			}
			break;
		case 'e':
			switch(inPos){
			case 1 :
				this.cible = Cible.SR_G;
				break;
			case 2 :
				this.cible = Cible.SR_M;
				break;
			case 3 : 
				this.cible = Cible.SR_B;
				break;
			case 4 :
				this.cible = Cible.SR_C;
				break;
			case 5 : 
				this.cible = Cible.SR_P;
				break;
			default :
				throw(new NumberException (inPos));
			}
			break;
		case 'r':
			switch(inPos){
			case 1 :
				this.cible = Cible.G_G;
				break;
			case 2 :
				this.cible = Cible.G_M;
				break;
			case 3 : 
				this.cible = Cible.G_B;
				break;
			case 4 :
				this.cible = Cible.G_C;
				break;
			case 5 : 
				this.cible = Cible.G_P;
				break;
			default :
				throw(new NumberException (inPos));
			}
			break;
		case 't':
			switch(inPos){
			case 1 :
				this.cible = Cible.ICHGNW_G;
				break;
			case 2 :
				this.cible = Cible.ICHGNW_M;
				break;
			case 3 : 
				this.cible = Cible.ICHGNW_B;
				break;
			case 4 :
				this.cible = Cible.ICHGNW_C;
				break;
			case 5 : 
				this.cible = Cible.ICHGNW_P;
				break;
			default :
				throw(new NumberException (inPos));
			}
			break;
		case 'y': 			
			switch(inPos){
			case 1 :
				this.cible = Cible.MTF_G;
				break;
			case 2 :
				this.cible = Cible.MTF_M;
				break;
			case 3 : 
				this.cible = Cible.MTF_B;
				break;
			case 4 :
				this.cible = Cible.MTF_C;
				break;
			case 5 : 
				this.cible = Cible.MTF_P;
				break;
			default :
				throw(new NumberException (inPos));
			}
			break;
		case 'u': 
			switch(inPos){
			case 1 :
				this.cible = Cible.YNG_G;
				break;
			case 2 :
				this.cible = Cible.YNG_M;
				break;
			case 3 : 
				this.cible = Cible.YNG_B;
				break;
			case 4 :
				this.cible = Cible.YNG_C;
				break;
			case 5 : 
				this.cible = Cible.YNG_P;
				break;
			default :
				throw(new NumberException (inPos));
			}
			break;
		case 'i':
			switch(inPos){
			case 1 :
				this.cible = Cible.BNUI_G;
				break;
			case 2 :
				this.cible = Cible.BNUI_M;
				break;
			case 3 : 
				this.cible = Cible.BNUI_B;
				break;
			case 4 :
				this.cible = Cible.BNUI_C;
				break;
			case 5 : 
				this.cible = Cible.BNUI_P;
				break;
			default :
				throw(new NumberException (inPos));
			}
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
