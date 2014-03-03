import classif.adaboost.Adaboost;
import classif.classification.BanqueApprentissage;
import classif.kppv.Kppv;
import affichage.leapMotion.ThreadLeapMotion;
import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;
import affichage.control.HandSpeakController;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		if(args.length!=3){
			System.out.print("utilisation : filename, T, numsteps, K");
		}
		
		String j = args[0];
		
		int T = Integer.valueOf(args[1]).intValue();
		
		float seuilMax = 50;
		
		int numSteps = Integer.valueOf(args[2]).intValue();
		
		int k = Integer.valueOf(args[3]).intValue();
		
		Adaboost a=new Adaboost(j, T, seuilMax, numSteps);
		
		System.out.print("AdaBoost initialisé");
		
		BanqueApprentissage banque = new BanqueApprentissage();
		
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
