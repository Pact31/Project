import leapmotion.LeapDataBase;
import classif.BanqueApprentissage;
import classif.adaboost.Adaboost;
import classif.kppv.Kppv;
import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;
import affichage.uiLeapMotion.ThreadLeapMotion;
import affichage.control.HandSpeakController;


public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		

		if(args.length!=3){
			System.out.println("utilisation : T, k");
		}
		
		
		//int T = Integer.valueOf(args[0]).intValue();//nombre de tour d'apprentissage pour adaboost
		
		//int k = Integer.valueOf(args[1]).intValue();//nombre de voisins pour kppv
		
		int T = 6;
		int k = 3;
		LeapDataBase leapDataBase = new LeapDataBase();//initialisation de la base de donnée
		
		leapDataBase.read("baseLeap3.dat");
		
		System.out.println("Base de test initialisée");
		
		BanqueApprentissage banque = new BanqueApprentissage(leapDataBase);
		
		System.out.println("Banque d'apprentissage initialisée");
		
		Adaboost adaboost =new Adaboost(banque, T);
		System.out.print("AdaBoost initialisé");
			
		Kppv kppv = new Kppv(banque, k);
		System.out.print("Kppv initialisé");

		DrawingAppModel		model				=	new	DrawingAppModel();
		HandSpeakController handSpeakController = 	new HandSpeakController(model);
		DrawingApp 			drawingApp 			= 	new DrawingApp(handSpeakController);
		
		ThreadLeapMotion threadLeapMotion 		=	new	ThreadLeapMotion(drawingApp);
		threadLeapMotion.start();
		
		System.out.print("Interface graphique initialisé");
		
		
	}
	
	

}
