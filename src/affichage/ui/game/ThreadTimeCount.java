package affichage.ui.game;

import java.io.IOException;
import java.util.Random;

import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;

public class ThreadTimeCount 
extends Thread
{
	
	private int i =0;
	private int score = 0;
	private int level = 0;
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
	
	private Random random = new Random();
	@Override
	public void run(){
		
		boolean running = false;
		int randNum = 0;
		while(true){
			
			running = drawingAppModel.getGameThreadRunning();
			
			while(running){
				
				running = drawingAppModel.getGameThreadRunning();
				/* --- update the position of timer--- */
				this.timePanel.setLocation(i);
				
				//drawingAppModel.getTextPanel().setText(String.valueOf(i));
				
				/* --- update the image and the text in the game panel ---*/
				if(drawingAppModel.getRightAnswer()){
					randNum = random.nextInt(8);// get a random number between 0-7
					updateGamePanel(randNum);
				}
				else
					launchDetection(randNum);
				
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
	
	private void updateGamePanel(int i){
		
		drawingAppModel.getScorePanel().setScore(score);
		drawingAppModel.getScorePanel().setLevel(level);
		try {
			drawingAppModel.getGameImagePanel().setImage(drawingAppModel.getGameImage(i));
			drawingAppModel.getTextPanel().setText(drawingAppModel.getGameText(i));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		score++;
		drawingAppModel.setRightAnswer(false);
		
	}
	
	private void launchDetection(int i){
		
		DrawingAppModel model = drawingApp.getModel();
		try {
			drawingApp.getHandSpeakController().launchGame();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(model.getCurrentMessage()==model.getGameText(i))
			model.setRightAnswer(true);
	}

}
