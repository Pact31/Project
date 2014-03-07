package leapmotion;

import java.io.IOException;

import classification.Cible;

public class main {

	public static void main(String[] args) throws Exception {
		LeapDataBase DB = new LeapDataBase();
		
		DB.read("test.txt");
		for (Cible cible : DB.table.keySet()){
		System.out.println(cible);
		}
		
/*		test a = new test();
		a.u.put(3,"hello");
		a.u.put(4, "coucou");
		a.read();
		//System.out.println(a.u);
*/
	}

}
