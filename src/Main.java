import leapmotion.LeapDataBase;
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
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		

		if(args.length!=3){
			System.out.print("utilisation : classifier num, T, K");//classifier num = 1 lance adaboost, le reste lance kppv
		}
		
		int classifierNum = Integer.valueOf(args[0]).intValue();
		
		int T = Integer.valueOf(args[1]).intValue();
		
		int k = Integer.valueOf(args[2]).intValue();
		
		LeapDataBase leapDataBase = new LeapDataBase();
		
		leapDataBase.read("test.test");
		
		BanqueApprentissage banque = new BanqueApprentissage(leapDataBase);
		
		if(classifierNum == 1){
			Adaboost a=new Adaboost(banque, T);
			System.out.print("AdaBoost initialisé");
			
		}
		
		else{
			Kppv a = new Kppv(banque, k);
			System.out.print("Kppv initialisé");
			
		}

		DrawingAppModel		model				=	new	DrawingAppModel();
		HandSpeakController handSpeakController = 	new HandSpeakController(model);
		DrawingApp 			drawingApp 			= 	new DrawingApp(handSpeakController);
		
		
		ThreadLeapMotion threadLeapMotion 		=	new	ThreadLeapMotion(drawingApp);
		threadLeapMotion.start();
		
		System.out.print("Interface graphique initialisé");
		
		
		
		
	}
	
	

}
