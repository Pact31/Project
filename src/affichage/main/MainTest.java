package affichage.main;

import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;
import affichage.ui_leapmotion.ThreadLeapMotion;
import affichage.control.HandSpeakController;

public class MainTest {
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception
	{
		
		/*
		 * the principal window
		 */
		DrawingAppModel		model				=	new	DrawingAppModel();
		HandSpeakController handSpeakController = 	new HandSpeakController(model);
		DrawingApp 			drawingApp 			= 	new DrawingApp(handSpeakController);
		//
		/*
		 * use second thread for showing the detection of Leap Motion
		 */
		ThreadLeapMotion threadLeapMotion 		=	new	ThreadLeapMotion(drawingApp);
		threadLeapMotion.start();
		
		//System.out.println(123);
	}
}

