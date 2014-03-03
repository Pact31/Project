package affichage.main;

import affichage.leapMotion.ThreadLeapMotion;
import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;
import affichage.control.HandSpeakController;

public class MainTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		DrawingAppModel		model				=	new	DrawingAppModel();
		HandSpeakController handSpeakController = 	new HandSpeakController(model);
		DrawingApp 			drawingApp 			= 	new DrawingApp(handSpeakController);
		
		
		ThreadLeapMotion threadLeapMotion 		=	new	ThreadLeapMotion(drawingApp);
		threadLeapMotion.start();
		
	}
}

