package kppv;

import classification.BanqueApprentissage;
import classification.Cible;
import classification.Entree;


/************************************************************************************************************
 *                                                                                                          *
 *              implementation de l'algorithme Kppv                                                         *
 *                                                                                                          *
 *  CONSTRUCTEURS : Il faut renseigner une BanqueApprentissage ainsi que le nombre de voisin a considerer   *
 *                                                                                                          *
 ************************************************************************************************************/

public class Kppv {
	
	/********************Attributs******************************/
	
	public BanqueApprentissage banque;
	private int k; 

	
	
	/*********************Constructeur**************************/
	
	public Kppv(BanqueApprentissage banque, int k){
		this.banque=banque;
		this.k=k;
	}


	
	public Cible classifier(Entree entree){

		
		int compteur[]=this.banque.countCible(k, entree);
		int indice=0;
		int pivot=compteur[0];
		for (int i=0;i<8;i=i+1){
			if (compteur[i]>pivot){
				pivot=compteur[i];
				indice=i;
			}
		}
		return Cible.values()[indice];
		
		
	}



}
























