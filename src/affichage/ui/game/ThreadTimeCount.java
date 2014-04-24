package affichage.ui.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;
import affichage.ui.game.model.DrawingGameModel;

public class ThreadTimeCount 
extends Thread
{
	
	private int counter =0;
	private int score = 0;
	private int level = 0;
	private TimeCountPanel timeCountPanel;
	private TimePanel      timePanel;
	private DrawingGame    drawingGame;
	private DrawingApp     drawingApp;
	private DrawingGameModel drawingGameModel;
	private Hashtable<String, Integer> levelTime = new Hashtable<String, Integer>();
	
	public ThreadTimeCount(DrawingApp drawingApp, DrawingGame drawingGame, TimeCountPanel timeCountPanel){
		
		this.initLevelTime();//initiation of game time
		
		this.timeCountPanel = timeCountPanel;
		this.timePanel	= timeCountPanel.getTimePanel();
		this.drawingGame = drawingGame;
		this.drawingApp = drawingApp;
		this.drawingGameModel	= drawingGame.getModel();	
		
	}
	
	private boolean threadRunning = true;
	public void stopThread(){
		
		threadRunning = false;
	}
	
	private Random random = new Random();
	private int numberWords = 5;
	private ArrayList<String> word = new ArrayList<String>();
 	@Override
	public void run(){
		
		boolean running = false;
		int randNum = 0;
		int i = 0;
		int counter2 = 0;
		boolean count = true; 
		
		while(threadRunning){

			running = drawingGameModel.getGameThreadRunning();
			System.out.print("");
			
			while(running && threadRunning){
				
				i		= 0;
				count   = true;
				running = drawingGameModel.getGameThreadRunning();
				
				randNum = random.nextInt(5);// get a random number between 0-4
				/* --- update the position of timer--- */
				//this.timePanel.setLocation(i);
				word = drawingGameModel.getGameText(randNum);
				
				try {
					drawingGameModel.getGameImagePanel().setImage(drawingGameModel.getGameImage(randNum));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				while(i < word.size()){
					while( (!drawingGameModel.getGameThreadRunning()) && threadRunning){
						//System.out.println("pause");
						//System.out.println(drawingGameModel.getGameThreadRunning());
					}
					if(counter2 <= 0){
						try {
							this.updateGamePanel(word, i);
							System.out.println("update Game Panel" + word.get(i));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
					if(count){
						this.timePanel.setLocation(counter2*600/this.levelTime.get(drawingGameModel.getGameLevel()));
						counter2++;
					}

					if(counter2 >= this.levelTime.get(drawingGameModel.getGameLevel())){
						
						drawingGameModel.setGameProcess("timeOut");
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						
						i++;
						counter2 = 0;
						if(counter < numberWords-1){
							drawingGameModel.setGameProcess("continue");
							
						}
						else
							drawingGameModel.setGameProcess("lastWord");
						
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						
					}
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					//launchDetection(word.get(i));
					if(drawingGameModel.getRightAnswer()){
						
						drawingGameModel.setGameProcess("true");
						//System.out.println("Process true");
						i++;
						counter2 = 0;
						
					}
					else{
						drawingGameModel.setGameProcess("false");
					}
					
					//System.out.println(counter2);
				}
						
				this.clearGamePanel();
				System.out.println(counter);
				counter++;
				
				if(counter == 1){
					
					System.out.println("Game Over!");
					drawingGameModel.setGameThreadRunning(false);
					this.initGame();
					this.updateGameBilan();
					this.drawingGame.gameOver(this.score);
				}
			
			}
			
		}
		System.out.println("Game thread done");
		
		
	}
	
 	private void clearGamePanel(){
 		
 		drawingGameModel.getGameCiblePanel().clear();
 		
 	}
 	
	private void updateGamePanel(ArrayList<String> word, int i) throws IOException{
		
		//System.out.println(i);
		drawingGameModel.getScorePanel().setScore(score);
		drawingGameModel.getScorePanel().setLevel(level);
		drawingGameModel.getGameCiblePanel().setCible(word.get(i), i);
		//drawingAppModel.setRightAnswer(false);

	}
	
	private void updateGameBilan(){
	
		drawingGameModel.getGameCiblePanel().setCible("Ton scores: " + String.valueOf(this.score) , 0);
	
	}
	
	private void launchDetection(String w){
		
		//DrawingAppModel model = drawingApp.getModel();
		try {
			drawingApp.getHandSpeakController().launchGame();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(drawingApp.getModel().getCurrentMessage() == w){
			drawingGameModel.setRightAnswer(true);
			score++;
		}
	}

	private void initLevelTime(){
		
		levelTime.put("easy", 		30);
		levelTime.put("moyen", 		20);
		levelTime.put("difficult", 	10);
		
	}
	
	private void initGame(){
		this.counter = 0;
		this.score = 0;
	}
	
}
