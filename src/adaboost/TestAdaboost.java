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
		
		int T = 16;
		
		int i = 160;
		
		Adaboost adaboost =new Adaboost(banque, T);
		
		System.out.println("l'élément " +i + " de la banque a pour cible : "+ banque.getApprentissage(i).getCible());
		
		
		System.out.println("la classe prédite par adaboost pour cet élément est : " + adaboost.classifier(banque.getApprentissage(i)));
		
	}

}
