import leapmotion.LeapDataBase;
import classif.BanqueApprentissage;
import classif.kppv.Kppv;
import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;
import affichage.ui.LeapMotion.ThreadLeapMotion;
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
		/*int T = 6;
		int k = 3;
		LeapDataBase leapDataBase = new LeapDataBase();//initialisation de la base de donnée
		
		leapDataBase.read("baseTestPos.dat");
		
		System.out.println("Base de test initialisee");
		
		BanqueApprentissage banque = new BanqueApprentissage(leapDataBase);
		
		System.out.println("Banque d'apprentissage initialisee");
		
<<<<<<< HEAD
		Adaboost adaboost =new Adaboost(banque, T);
=======
	//	Adaboost adaboost =new Adaboost(banque, T);
>>>>>>> pactHub/hassen
		System.out.print("AdaBoost initialise");
			
		Kppv kppv = new Kppv(banque, k);
		System.out.print("Kppv initialise");

		DrawingAppModel		model				=	new	DrawingAppModel();
		HandSpeakController handSpeakController = 	new HandSpeakController(model);
		DrawingApp 			drawingApp 			= 	new DrawingApp(handSpeakController);
		
		ThreadLeapMotion threadLeapMotion 		=	new	ThreadLeapMotion(drawingApp);
		threadLeapMotion.start();
		
<<<<<<< HEAD
		System.out.print("Interface graphique initialise");*/
		System.out.print("Interface graphique initialise");
		
	}
	
	

}
