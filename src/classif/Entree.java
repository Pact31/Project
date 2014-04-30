package classif;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;

import LeapTS.FrameTS;
import LeapTS.VectorTS;



/***************************************************************************
 *                                                                         *
 *                                                                         *
 * Represente une main par : - la position du centre de la main            *
 * 						     - la position du bout de chaque doigt         *
 *                               par rapport au centre de la main          *
 *                                                                         *
 *       ATTRIBUTS : Cinqs doigt de la main + main						   *                                                                  
 *                                                                         *
 *       CONSTRUCTEUR : A partir d'une FrameTS                             *
 *                                                                         *
 *       FONCTIONS : Calculer la distance d'une entree a la base           *
 *                                                                         *
 *                                                                         *
 *                                                                         *
 *                                                                         *
 ***************************************************************************/


public class Entree {

	/********************Attributs**************************/
	
	private VectorTS d1;//doigt 1
	private VectorTS d2;//doigt 2
	private VectorTS d3;//doigt 3
	private VectorTS d4;//doigt 4
	private VectorTS d5;//doigt 5
	private VectorTS m;//main



	/**********************Contructeurs************************/

	public void setFrameTS(FrameTS frameTS){

		this.m = frameTS.getHandList().get(0).getPalmPosition();

		int fingerLength = frameTS.getFingerList().size();

		//On regarde le nombre de doigts presents dans la FrameTS et on les ajoute de la maniere suivante :
		//    - on prend les cinq premiers doigts. A priori il ne devrait pas en avoir plus de cinq. Mais il peut en avoir moins.
		//    - s'il n'y en a pas cinq, on complete par des vecteurs nuls.
		//    - on prend la premiere main. A priori il ne devrait pas en avoir plus d'une.
		if(fingerLength >= 1){
			this.d1 = frameTS.getFingerList().get(0).getTipPosition().minus(this.m);
		} 
		else {
			this.d1 = new VectorTS(0,0,0);
		}

		if(fingerLength >= 2){
			this.d2 = frameTS.getFingerList().get(1).getTipPosition().minus(this.m);
		} 
		else {
			this.d2 = new VectorTS(0,0,0);
		}
		if(fingerLength >= 3){
			this.d3 = frameTS.getFingerList().get(2).getTipPosition().minus(this.m);
		} 
		else {
			this.d3 = new VectorTS(0,0,0);
		}
		if(fingerLength >= 4){
			this.d4 = frameTS.getFingerList().get(3).getTipPosition().minus(this.m);
		} 
		else {
			this.d4 = new VectorTS(0,0,0);
		}
		if(fingerLength >= 5){
			this.d5 = frameTS.getFingerList().get(4).getTipPosition().minus(this.m);
		} 
		else {
			this.d5 = new VectorTS(0,0,0);
		}

	}
	
	public Entree(FrameTS frameTS){
		this.setFrameTS(frameTS);
	}
	
	public Entree(Controller controller){
		Frame frame = controller.frame();
		FrameTS frameTS = new FrameTS(frame);
		this.setFrameTS(frameTS);	
	}


	
	/***********************Getters*****************************/
	public VectorTS getD1() {
		return d1;
	}
	
	public VectorTS getD2() {
		return d2;
	}
	
	public VectorTS getD3() {
		return d3;
	}

	public VectorTS getD4() {
		return d4;
	}

	public VectorTS getD5() {
		return d5;
	}

	public VectorTS getM(){
		return m;
	}




	/**********************Fonctions diverses************************/
	
	//Donne la distance d'un element a la base d'appentissage
	public double getDistance(Entree entree){
	
		return Math.pow(
				 Math.pow(getD1().getDistance(entree.getD1()),2)
				+Math.pow(getD2().getDistance(entree.getD2()),2)
				+Math.pow(getD3().getDistance(entree.getD3()),2)
				+Math.pow(getD4().getDistance(entree.getD4()),2)
				+Math.pow(getD5().getDistance(entree.getD5()),2)
				+Math.pow(getM().getDistance(entree.getM()),2),0.5); //On ne prend pas en compte la position du centre de la main
																 //dans le prototype allege
	
	}

}
