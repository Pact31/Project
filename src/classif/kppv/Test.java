package classif.kppv;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;

import classif.adaboost.Adaboost;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;

import leapmotion.LeapDataBase;
import LeapTS.FrameTS;
import classif.Apprentissage;
import classif.BanqueApprentissage;
import classif.Entree;

public class Test {

		public static void main(String[] args) throws Exception {

		LeapDataBase leapDataBase = new LeapDataBase();
		leapDataBase.read("baseLeap3.dat");
		
		BanqueApprentissage banque = new BanqueApprentissage(leapDataBase);
		
				
		Controller controller = new Controller();
		
		System.out.println("Appuyer sur une touche pour valider");
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));//lecture de la touche tappee au clavier
		char inChar = (char) buf.read();
			
		Frame frame = controller.frame();
		FrameTS framets = new FrameTS(frame);
		Entree entree = new Entree(framets);
		
		Kppv classificateur = new Kppv(banque,5);
		
		/*for(Apprentissage apprentissage : banque.getAllApprentissage()){
			System.out.println(apprentissage.getCible());
		}
		*/
		
			
		System.out.println(classificateur.classifier(entree));
		
				

	}




}
