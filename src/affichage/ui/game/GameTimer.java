package affichage.ui.game;


import java.io.IOException;
import java.util.Random;
import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;
public class GameTimer 
extends Thread
{
	
	private DrawingGame drawingGame;
	private DrawingApp drawingApp;
	private DrawingGameModel model;

	public GameTimer(DrawingApp drawingApp, DrawingGame drawingGame){
		
		this.drawingGame = drawingGame;
		this.drawingApp = drawingApp;
		this.model	= drawingGame.getModel();	
		
	}
	
	@Override
	public void run(){

		threadSleep(3000);
		model.setGameProcess("Start3");
		System.out.print(3);
		threadSleep(1000);
		model.setGameProcess("Start2");
		threadSleep(1000);
		model.setGameProcess("Start1");
		threadSleep(1000);
		model.setGameProcess("Start");
		
	}
	
	private void threadSleep(int t){
		
		try {
			Thread.sleep(t);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
}