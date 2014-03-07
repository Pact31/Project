package classification;

import java.util.ArrayList;

import LeapTS.FingerTS;
import LeapTS.HandTS;
import LeapTS.VectorTS;



/*Cette classe est celle des elements que nous appellerons Apprentissage de la base de donnees */

public class Apprentissage extends Entree {
	
	/*Memes attributs que les elements de la classe Entree plus un attribut cible qui permet de realiser l'association donn√e-syllabe */
	private Cible cible;
	
	/*Constructeur de classe*/
	public Apprentissage(VectorTS d1, VectorTS d2, VectorTS d3, VectorTS d4, VectorTS d5, VectorTS m, Cible cible){
		super(d1,d2,d3,d4,d5,m);
		this.cible=cible;
	}
	
	public Apprentissage(ArrayList<FingerTS> fingerListTS, ArrayList<HandTS> handListTS, Cible cible){
		super(fingerListTS, handListTS);
		this.cible = cible;
	}
	
	/*renvoie la cible de l'element de la base de donnees*/
	public Cible getCible(){
		return cible;
	}
}
