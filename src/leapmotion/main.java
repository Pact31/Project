package leapmotion;

import java.io.IOException;

import classification.Apprentissage;
import classification.BanqueApprentissage;
import classification.Cible;

public class main {

	public static void main(String[] args) throws Exception {
		LeapDataBase DB = new LeapDataBase();
		
		//DB.read("test.txt");
		DB.write("test.txt");
		for (Cible cible : DB.table.keySet()){
		System.out.println(cible);
		}
		
		System.out.println("__________________");
		
		BanqueApprentissage banque = new BanqueApprentissage(DB);
		for(Apprentissage apprentissage : banque.getAllApprentissage()){
			System.out.println(apprentissage.getCible());
		}
		
/*		test a = new test();
		a.u.put(3,"hello");
		a.u.put(4, "coucou");
		a.read();
		//System.out.println(a.u);
*/
	}

}
