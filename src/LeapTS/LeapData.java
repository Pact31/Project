package LeapTS;

import leapmotion.ConsonneException;
import leapmotion.LetterException;

import leapmotion.NumberException;

import leapmotion.VoyelleException;


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



	
	//Constructeur ligne de commande avec les lettres pour designer les consonnes et les chiffres pour designer les voyelles
	public LeapData( Frame frame,char inChar, int inPos){
		super(frame);
		try{
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
		}catch (IllegalArgumentException | NullPointerException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Erreur lors de la cr�ation d'un nouvel objet LeapData");
			e.printStackTrace();
		} catch (NumberException e) {
			System.out.println("Chiffre non valide");
		} catch (LetterException e){
			System.out.println("Caractere non valide");
		} finally {}
	}
	
	//Concstructeur string
		public LeapData( Frame frame,String c, String v){
		super(frame);
		try{
		switch(c){
		case "PDJ" : 
			switch(v){
			case "u un é" :
				this.cible = Cible.PDJ_G;
				break;
			case "ais ou o" :
				this.cible = Cible.PDJ_M;
				break;
			case "i on an" : 
				this.cible = Cible.PDJ_B;
				break;
			case "a o oe" :
				this.cible = Cible.PDJ_C;
				break;
			case "ain eu" : 
				this.cible = Cible.PDJ_P;
				break;
			default :
				throw(new VoyelleException (v));
			}
			break;
		case "KVZ":
			switch(v){
			case "u un é" :
				this.cible = Cible.KVZ_G;
				break;
			case "ais ou o" :
				this.cible = Cible.KVZ_M;
				break;
			case "i on an" : 
				this.cible = Cible.KVZ_B;
				break;
			case "a o oe" :
				this.cible = Cible.KVZ_C;
				break;
			case "ain eu" : 
				this.cible = Cible.KVZ_P;
				break;
			default :
				throw(new VoyelleException (v));
			}
			break;
		case "SR":
			switch(v){
			case "u un é" :
				this.cible = Cible.SR_G;
				break;
			case "ais ou o" :
				this.cible = Cible.SR_M;
				break;
			case "i on an" : 
				this.cible = Cible.SR_B;
				break;
			case "a o oe" :
				this.cible = Cible.SR_C;
				break;
			case "ain eu" : 
				this.cible = Cible.SR_P;
				break;
			default :
				throw(new VoyelleException (v));
			}
			break;
		case "G":
			switch(v){
			case "u un é" :
				this.cible = Cible.G_G;
				break;
			case "ais ou o" :
				this.cible = Cible.G_M;
				break;
			case "i on an" : 
				this.cible = Cible.G_B;
				break;
			case "a o oe" :
				this.cible = Cible.G_C;
				break;
			case "ain eu" : 
				this.cible = Cible.G_P;
				break;
			default :
				throw(new VoyelleException (v));
			}
			break;
		case "ICHGNW":
			switch(v){
			case "u un é" :
				this.cible = Cible.ICHGNW_G;
				break;
			case "ais ou o" :
				this.cible = Cible.ICHGNW_M;
				break;
			case "i on an" : 
				this.cible = Cible.ICHGNW_B;
				break;
			case "a o oe" :
				this.cible = Cible.ICHGNW_C;
				break;
			case "ain eu" : 
				this.cible = Cible.ICHGNW_P;
				break;
			default :
				throw(new VoyelleException (v));
			}
			break;
		case "MTF": 			
			switch(v){
			case "u un é" :
				this.cible = Cible.MTF_G;
				break;
			case "ais ou o" :
				this.cible = Cible.MTF_M;
				break;
			case "i on an" : 
				this.cible = Cible.MTF_B;
				break;
			case "a o oe" :
				this.cible = Cible.MTF_C;
				break;
			case "ain eu" : 
				this.cible = Cible.MTF_P;
				break;
			default :
				throw(new VoyelleException (v));
			}
			break;
		case "YNG": 
			switch(v){
			case "u un é" :
				this.cible = Cible.YNG_G;
				break;
			case "ais ou o" :
				this.cible = Cible.YNG_M;
				break;
			case "i on an" : 
				this.cible = Cible.YNG_B;
				break;
			case "a o oe" :
				this.cible = Cible.YNG_C;
				break;
			case "ain eu" : 
				this.cible = Cible.YNG_P;
				break;
			default :
				throw(new VoyelleException (v));
			}
			break;
		case "BNUI":
			switch(v){
			case "u un é" :
				this.cible = Cible.BNUI_G;
				break;
			case "ais ou o" :
				this.cible = Cible.BNUI_M;
				break;
			case "i on an" : 
				this.cible = Cible.BNUI_B;
				break;
			case "a o oe" :
				this.cible = Cible.BNUI_C;
				break;
			case "ain eu" : 
				this.cible = Cible.BNUI_P;
				break;
			default :
				throw(new VoyelleException (v));

			}
			break;
		default: 
			throw (new ConsonneException(c));
			
		}
		}catch (IllegalArgumentException | NullPointerException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Erreur lors de la création d'un nouvel objet LeapData");
			e.printStackTrace();
		} catch (VoyelleException e) {
			System.out.println("Voyelle non valide");
		} catch (ConsonneException e){
			System.out.println(e.getMessage());
		} finally {}
	}
	
	
	/*********************************Getters***********************/
	public Cible getCible(){
		return this.cible;
	}
}
