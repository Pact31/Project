package main;

import java.io.File;

import affichage.control.HandSpeakController;
import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;
import affichage.ui_leapmotion.ThreadLeapMotion;


public class MainTest {
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception
	{
		//File file = new File("LeapHnv22.dat");
		//System.out.println(file.exists());
		
		
		/*
		 * the principal window
		 */
		DrawingAppModel		model				=	new	DrawingAppModel();
		HandSpeakController handSpeakController = 	new HandSpeakController(model);
		DrawingApp 			drawingApp 			= 	new DrawingApp(handSpeakController);
		
		/*
		 * use second thread for showing the detection of Leap Motion
		 */
		ThreadLeapMotion threadLeapMotion 		=	new	ThreadLeapMotion(drawingApp);
		threadLeapMotion.start();
	
	}
}

