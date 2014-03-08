package classif.adaboost;

import classif.classification.BanqueApprentissage;
import leapmotion.LeapDataBase;

public class TestAdaboost {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LeapDataBase leapDataBase = new LeapDataBase();//initialisation de la base de donnée
		
		leapDataBase.read("data/baseLeap.dat");
		
		BanqueApprentissage banque = new BanqueApprentissage(leapDataBase);
		
		int T = 6;
		
		Adaboost adaboost =new Adaboost(banque, T);
		
		System.out.println("le premier élément de la banque a pour cible : "+ banque.getApprentissage(1).getCible());
		
		System.out.println("la classe prédite par adaboost pour cet élément est : " + adaboost.predict(banque.getApprentissage(1)));
		
	}

}
