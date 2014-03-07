package kppv;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;

import leapmotion.LeapDataBase;
import LeapTS.FrameTS;
import LeapTS.VectorTS;
import classification.Apprentissage;
import classification.BanqueApprentissage;
import classification.Cible;
import classification.Entree;

public class Test {

		public static void main(String[] args) throws Exception {

		LeapDataBase leapDataBase = new LeapDataBase();
		leapDataBase.read("test.test");
		
		BanqueApprentissage banque = new BanqueApprentissage(leapDataBase);
		
		VectorTS  p0  = new VectorTS  (0,0,0);
		
		VectorTS d0  = new VectorTS (0,0,0);
		VectorTS d111 = new VectorTS (10,10,10);
		VectorTS d121 = new VectorTS (9,10,11);
		VectorTS d131 = new VectorTS (10,11,10);
		VectorTS d141 = new VectorTS (11,9,10);
		VectorTS d211 = new VectorTS (8,10,11);
		VectorTS d221 = new VectorTS (9,10,10);
		VectorTS d231 = new VectorTS (10,10,10);
		VectorTS d241 = new VectorTS (11,10,9);
		VectorTS d311 = new VectorTS (11,10,10);
		VectorTS d321 = new VectorTS (10,10,10);
		VectorTS d331 = new VectorTS (11,9,10);
		VectorTS d341 = new VectorTS (10,10,11);
		VectorTS d112 = new VectorTS (20,20,20);
		VectorTS d122 = new VectorTS (21,22,19);
		VectorTS d132 = new VectorTS (20,19,21);
		VectorTS d142 = new VectorTS (21,21,21);
		VectorTS d212 = new VectorTS (19,19,19);
		VectorTS d222 = new VectorTS (20,20,20);
		VectorTS d232 = new VectorTS (19,20,19);
		VectorTS d242 = new VectorTS (19,20,21);
		VectorTS d312 = new VectorTS (19,19,21);
		VectorTS d322 = new VectorTS (19,20,21);
		VectorTS d332 = new VectorTS (21,21,19);
		VectorTS d342 = new VectorTS (19,21,21);
		VectorTS d113 = new VectorTS (30,31,30);
		VectorTS d123 = new VectorTS (30,30,30);
		VectorTS d133 = new VectorTS (30,30,31);
		VectorTS d143 = new VectorTS (30,31,31);
		VectorTS d213 = new VectorTS (32,31,30);
		VectorTS d223 = new VectorTS (29,29,29);
		VectorTS d233 = new VectorTS (30,30,30);
		VectorTS d243 = new VectorTS (31,31,31);
		VectorTS d313 = new VectorTS (30,32,29);
		VectorTS d323 = new VectorTS (29,29,29);
		VectorTS d333 = new VectorTS (30,30,30);
		VectorTS d343 = new VectorTS (29,30,30);
		
			

		Apprentissage a11 =  new Apprentissage( d111,d211,d311,d0,d0,p0,Cible.values()[1]);
		Apprentissage a12 =  new Apprentissage( d121,d221,d321,d0,d0,p0,Cible.values()[1]);
		Apprentissage a13 =  new Apprentissage( d131,d231,d331,d0,d0,p0,Cible.values()[1]);
		Apprentissage a14 =  new Apprentissage( d141,d241,d341,d0,d0,p0,Cible.values()[1]);
		Apprentissage a21 =  new Apprentissage( d112,d212,d312,d0,d0,p0,Cible.values()[2]);
		Apprentissage a22 =  new Apprentissage( d122,d222,d322,d0,d0,p0,Cible.values()[2]);
		Apprentissage a23 =  new Apprentissage( d132,d232,d332,d0,d0,p0,Cible.values()[2]);
		Apprentissage a24 =  new Apprentissage( d142,d242,d342,d0,d0,p0,Cible.values()[2]);
		Apprentissage a31 =  new Apprentissage( d113,d213,d313,d0,d0,p0,Cible.values()[3]);
		Apprentissage a32 =  new Apprentissage( d123,d223,d323,d0,d0,p0,Cible.values()[3]);
		Apprentissage a33 =  new Apprentissage( d133,d233,d333,d0,d0,p0,Cible.values()[3]);
		Apprentissage a34 =  new Apprentissage( d143,d243,d343,d0,d0,p0,Cible.values()[3]);
		
		banque.addApprentissage(a11);
		banque.addApprentissage(a12);
		banque.addApprentissage(a13);
		banque.addApprentissage(a14);
		banque.addApprentissage(a21);
		banque.addApprentissage(a22);
		banque.addApprentissage(a23);
		banque.addApprentissage(a24);
		banque.addApprentissage(a31);
		banque.addApprentissage(a32);
		banque.addApprentissage(a33);
		banque.addApprentissage(a34);
		
		Entree entree = new Entree(d143,d243,d343,d0,d0,p0);
		
		
	/*	Controller controller = new Controller();
		
		System.out.println("Appuer sur une touche pour valider");
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));//lecture de la touche tappee au clavier
		char inChar = (char) buf.read();
			
		Frame frame = controller.frame();
		FrameTS framets = new FrameTS(frame);
		Entree entree = new Entree(framets.getFingerList(), framets.getHandList());*/
		
		Kppv classificateur = new Kppv(banque,3);
		System.out.println(classificateur.kppv(entree));
		

	}




}
