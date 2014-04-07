package affichage.ui.game;

import java.io.IOException;

import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;

public class ThreadTimeCount 
extends Thread
{
	
	private int i =0;
	private TimeCountPanel timeCountPanel;
	private TimePanel      timePanel;
	private DrawingGame    drawingGame;
	private DrawingApp     drawingApp;
	private DrawingAppModel drawingAppModel;
	
	public ThreadTimeCount(DrawingApp drawingApp, DrawingGame drawingGame, TimeCountPanel timeCountPanel){
		
		this.timeCountPanel = timeCountPanel;
		this.timePanel	= timeCountPanel.getTimePanel();
		this.drawingGame = drawingGame;
		this.drawingApp = drawingApp;
		this.drawingAppModel	= drawingApp.getModel();		
	}
	
	@Override
	public void run(){
		
		boolean running = false;
		
		while(true){
			
			running = drawingAppModel.getGameThreadRunning();
			
			while(running){
				
				running = drawingAppModel.getGameThreadRunning();
					
				this.timePanel.setLocation(i);
				
				drawingAppModel.getTextPanel().setText(String.valueOf(i));
				
				try {
					drawingAppModel.getGameImagePanel().setImage(drawingAppModel.getGameImage(i));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				i++;
				/* timer */
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				if(i >= 45){
					try {
						this.drawingGame.setGameOver();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					this.currentThread().stop();
				}
					
			}
		}
		
	}
	
}
