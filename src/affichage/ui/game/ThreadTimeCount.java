package affichage.ui.game;

import integration.Mot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import classif.Cible;
import affichage.gestures.GesturesPositions;
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
	private int numberWords = 18;
	private ArrayList<String> word = new ArrayList<String>();
	private ArrayList<Integer> imageList = new ArrayList<Integer>();
	private Mot mot;
	
 	@Override
	public void run(){
		
		boolean running = false;
		int randNum = 0;
		int i = 0;
		int counter2 = 0;
		boolean count = true; 
		
		this.initGame();
		
		while(threadRunning && !drawingGame.getModel().getGameDone()){

			running = drawingGameModel.getGameThreadRunning();
			System.out.print("");
			
			while(running && threadRunning){
				
				i		= 0;
				count   = true;
				
				
				randNum = imageList.get(counter);
				/* --- update the position of timer--- */
				word = drawingGameModel.getGameText(randNum);
				mot = drawingGameModel.getDico().getDictionnaire().get(randNum);
				
				try {
					drawingGameModel.getGameImagePanel().setImage(drawingGameModel.getGameImage(randNum));
				} catch (IOException e) {
					e.printStackTrace();
				}

				while(i < mot.getCibles().size() && !drawingGameModel.getGameDone()){
				
					if(counter < numberWords-1){
						//System.out.println(i);
						//launchDetectionSimulation(word.get(i));
						try {
							this.launchDetection(mot, i);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					while( !(threadRunning = drawingGameModel.getGameThreadRunning()) && !this.threadRunning ){
						//System.out.println("pause");
						if(drawingGameModel.getGameDone())
							break;
					}
					
					/*--------------- update text --------------------------------------*/
					if(counter2 <= 0){
						try {
							this.updateGamePanel(word, i);
							//System.out.println("update Game Panel" + word.get(i));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
					/*--------------- time counter panel --------------------------------*/
					if(count){
						this.timePanel.setLocation(counter2*600/this.levelTime.get(drawingGameModel.getGameLevel()));
						counter2++;
					}
					
					/*--------------- timeout ------------------------------------------*/
					if(counter2 >= this.levelTime.get(drawingGameModel.getGameLevel())){
						
						drawingGameModel.setGameProcess("timeOut");
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						
						counter2 = 0;
						i++;
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
					/*-------------------------------------------------------------------*/
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					/*----------------------------------------------------------------------*/
					
					if(drawingGameModel.getRightAnswer()){
						
						drawingGameModel.setGameProcess("true");
						//System.out.println("Process true");
						i++;
						counter2 = 0;
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
					else{
						drawingGameModel.setGameProcess("false");
					}
					
					//System.out.println(counter2);
				}
						
				this.clearGamePanel();
				System.out.println(counter);
				counter++;
				
				if(counter == this.numberWords){
					
					System.out.println("Game Over!");
					drawingGameModel.setGameThreadRunning(false);
					//this.threadRunning = false;
					
					this.updateGameBilan();
					this.drawingGame.gameOver(this.score);
					this.initGame();
				
				}
				running = drawingGameModel.getGameThreadRunning();
				
			}
			
		}
		System.out.println("Game thread done");
		
		
	}
	
 	private void clearGamePanel(){
 		
 		drawingGameModel.getGameCiblePanel().clear();
 		
 	}
 	
	private void updateGamePanel(ArrayList<String> word, int i) throws IOException{
		
		//System.out.println(i);
		System.out.println("update game panel");
		drawingGameModel.getScorePanel().setScore(score);
		drawingGameModel.getScorePanel().setLevel(level);
		drawingGameModel.getGameCiblePanel().setCible(word.get(i), i);
		//drawingAppModel.setRightAnswer(false);

	}
	
	private void updateGameBilan(){
		System.out.println("update game bilan");
		drawingGameModel.getGameCiblePanel().setBilan("Ton score: " + String.valueOf(this.score) , 0);
		this.imageList.clear();
	}
	
	

	private void initLevelTime(){
		
		levelTime.put("easy", 		30);
		levelTime.put("moyen", 		20);
		levelTime.put("difficult", 	4);
		
	}

	private void initGame(){
		
		int i = 0;
		while(this.imageList.size() != this.numberWords){
			i = random.nextInt(18);		
			if(!this.imageList.contains(i))
				this.imageList.add(i);
		}
		
		this.counter = 0;
		this.score = 0;
	
	}
	
	/*-----------------------------------------------------------------------
	 * il faut remplacer les codes ci-dessous par une méthode classification qui
 	 * revois le résultat par un string.
	 * 
	 * ---------------------------------------------------------------------*/
	
	private void launchDetectionSimulation(String w){
		
		int res = random.nextInt(10);// get a random number between 0-4
		
		if(res == 1){
			drawingGameModel.setRightAnswer(true);
			score++;
		}
		else{
			drawingGameModel.setRightAnswer(false);
		}
		
	}
	
	private GesturesPositions gesturesPositions = new GesturesPositions();
	private void launchDetection(Mot m, int i) throws Exception{
		drawingApp.getHandSpeakController().launchGame();
		String c = gesturesPositions.getGestures(drawingApp.getModel().getCurrentCible()).getC(); //currentMessage = consonne
		
		if(c.contains(gesturesPositions.getGestures(m.getCibles().get(i)).getC())){ // si getC et c sont égales. 
			drawingGameModel.setRightAnswer(true);
			System.out.println("Correct");
		//	WaveFile waveFile = new WaveFile();
			score++;
		}
		else{
			drawingGameModel.setRightAnswer(false);
			System.out.println("Incorrect");
		}
	
	}
}

