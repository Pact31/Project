package leapmotion;

import LeapTS.LeapData;
<<<<<<< HEAD
import classification.Apprentissage;
import classification.BanqueApprentissage;
=======
import classif.classification.Apprentissage;
import classif.classification.BanqueApprentissage;
>>>>>>> pactHub/Adaboost2

public class main {

	public static void main(String[] args) throws Exception {
		LeapDataBase DB = new LeapDataBase();
		
		DB.write("baseLeap.dat");
		DB.read("baseLeap.dat");
		for (LeapData leapData : DB.table){
		System.out.println(leapData.getCible());
		}
		
		System.out.println("__________________");
		
		BanqueApprentissage banque = new BanqueApprentissage(DB);
		for(Apprentissage apprentissage : banque.getAllApprentissage()){
			System.out.println(apprentissage.getCible());
		}
		

	}

}
