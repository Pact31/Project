package classif.kppv;


import java.io.BufferedReader;
import java.io.InputStreamReader;

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
		leapDataBase.read("LeapHnv22.dat");
		
		BanqueApprentissage banque = new BanqueApprentissage(leapDataBase);
		
				
		Controller controller = new Controller();
		
		System.out.println("Appuer sur une touche pour valider");
		
	/*	BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));//lecture de la touche tappee au clavier
		char inChar = (char) buf.read();
			
		Frame frame = controller.frame();
		FrameTS framets = new FrameTS(frame);
		Entree entree = new Entree(framets);*/
		
		Adaboost classificateur = new Adaboost(banque,5);
		
	/*	for(Apprentissage apprentissage : banque.getAllApprentissage()){
			System.out.println(apprentissage.getCible());
		}*/
		
		
		BanqueApprentissage banquetekppv = classificateur.getBanque();
		
		System.out.println(banquetekppv.size());
		
		System.out.println(classificateur.crossTest());
		

	}




}
