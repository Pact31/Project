package adaboost;

import java.io.File;

import classification.BanqueApprentissage;
import leapmotion.LeapDataBase;

public class TestAdaboost {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LeapDataBase leapDataBase = new LeapDataBase();//initialisation de la base de donnée
		
		File file = new File("data/LeapHnv22.dat");
		
		System.out.println(file.exists());
		
		leapDataBase.read("data/LeapHnv22.dat");
		
		BanqueApprentissage banque = new BanqueApprentissage(leapDataBase);
		
		int T = 5;
		
		Adaboost adaboost =new Adaboost(banque, T);
		
		System.out.println("le premier élément de la banque a pour cible : "+ banque.getApprentissage(90).getCible());
		
		
		System.out.println("la classe prédite par adaboost pour cet élément est : " + adaboost.predict(banque.getApprentissage(90)));
		
	}

}
