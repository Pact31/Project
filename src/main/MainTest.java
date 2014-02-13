package main;

import model.DrawingAppModel;
import ui.DrawingApp;
import ui_leapmotion.ThreadLeapMotion;
import control.HandSpeakController;

public class MainTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
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

