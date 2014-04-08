package main;

import java.io.File;

import affichage.control.HandSpeakController;
import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;
import affichage.ui.game.DrawingGame;
import affichage.ui.mainMenu.DrawingMainMenu;
import affichage.uiLeapMotion.ThreadLeapMotion;


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
		/*
		 * use second thread for showing the detection of Leap Motion
		 */
		
		//ThreadLeapMotion threadLeapMotion 		=	new	ThreadLeapMotion(drawingApp);
		//threadLeapMotion.start();
 				
		//DrawingMainMenu drawingMainMenu = new DrawingMainMenu();
		
		DrawingAppModel		model				=	new	DrawingAppModel();
		DrawingApp drawingApp = new DrawingApp(model);
		DrawingGame drawingGame = new DrawingGame(drawingApp);
	}
}

