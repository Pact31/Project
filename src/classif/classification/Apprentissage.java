package classif.classification;

import java.util.ArrayList;

import LeapTS.FingerTS;
import LeapTS.FrameTS;
import LeapTS.HandTS;
import LeapTS.VectorTS;


/*******************************************************************************************
*                                                                                          *
*             La classe apprentissage etend la classe Entree                               *
*             Elle permet d'associer une entree a une cible                                *
*                                                                                          *
*             ATTRIBUTS : - Cinq doigts                                                    *
*             		      - Main                                                           *
*                         - Cible                                                          *
*                                                                                          *
*             CONTRUCTEUR : - Un Apprentissage se construit avec une FrameTS et une Cible  *
*                                                                                          *
*                                                                                          *
********************************************************************************************/


public class Apprentissage extends Entree {
	
	/*********************Attributs******************************/
	
	private Cible cible;
	
	
	/*********************Constructeur*****************************/
	
	public Apprentissage(FrameTS frameTS, Cible cible){
		super(frameTS);
		this.cible = cible;
	}
	
	
	/*********************Getters**********************************/
	
	public Cible getCible(){
		return cible;
	}
}
