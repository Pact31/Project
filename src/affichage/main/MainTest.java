package main;

import leapMotion.ThreadLeapMotion;
import model.DrawingAppModel;
import ui.DrawingApp;
import control.HandSpeakController;

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

