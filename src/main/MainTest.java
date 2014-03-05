package main;

import affichage.model.DrawingAppModel;
import affichage.test_classification.MyApprentissage;
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
		/*DrawingAppModel		model				=	new	DrawingAppModel();
		HandSpeakController handSpeakController = 	new HandSpeakController(model);
		DrawingApp 			drawingApp 			= 	new DrawingApp(handSpeakController);
		*/
		MyApprentissage app = new MyApprentissage();
		
		app.saveBank("123");
		/*
		 * use second thread for showing the detection of Leap Motion
		 */
		/*ThreadLeapMotion threadLeapMotion 		=	new	ThreadLeapMotion(drawingApp);
		threadLeapMotion.start();
		*/
	}
}

