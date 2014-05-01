package affichage.ui.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JPanel;

import affichage.ui.DrawingApp;
import affichage.ui.LeapPanel;
import affichage.ui.mainMenu.TitlePanel;

public class WindowGame 
extends JPanel
{
	
	//private final TitlePanel             		titlePanel;
	private final ScorePanel					scorePanel;
	private final GestureShowPanel     		gestureShowPanel;
	//private final TimeCountPanel       		timeCountPanel;
	private final ButtonGameStartPanel        	buttonGameStartPanel;
	private final ButtonGameStopPanel			buttonGameStopPanel;
	private final GameLisaPanel				gameLisaPanel;
	private final ButtonGameLevelPanel        	gameButtonLevelPanel;
	private final LeapPanel					leapPanel;
	
	public WindowGame(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{
		
		super();
		
		this.setLayout(null);
		
		gameButtonLevelPanel = new ButtonGameLevelPanel(drawingApp, drawingGame);
		gameButtonLevelPanel.setBounds(850, 0, 150, 50);
		this.add(gameButtonLevelPanel);
			
		gestureShowPanel = new GestureShowPanel(drawingApp, drawingGame);
		gestureShowPanel.setBounds(400, 0, 600, 600);
		this.add(gestureShowPanel);
	
		gameLisaPanel =	new GameLisaPanel(drawingApp, drawingGame);
		gameLisaPanel.setBounds(1000, 0, 200, 300);
		this.add(gameLisaPanel);
		
		scorePanel = new ScorePanel(drawingApp, drawingGame);
		scorePanel.setBounds(1000, 300, 200, 200);
		this.add(scorePanel);
		drawingGame.getModel().setScorePanel(scorePanel);
		
		/*------------ Buttons ----------------------*/
		
		buttonGameStartPanel = new ButtonGameStartPanel(drawingApp, drawingGame);
		buttonGameStartPanel.setBounds(1000, 500, 100, 120);
		this.add(buttonGameStartPanel);
		
		buttonGameStopPanel = new ButtonGameStopPanel(drawingApp, drawingGame);
		buttonGameStopPanel.setBounds(1100, 500, 100, 120);
		this.add(buttonGameStopPanel);
		
		/*--------------------------------------------*/
		
		leapPanel = new LeapPanel(drawingApp);
		leapPanel.setBounds(0, 0, 400, 600);
		this.add(leapPanel);
		
	}
	
	public void setEnableStart(boolean b){
		
		buttonGameStartPanel.setButtonEnable(b);
	
	}
	
	public void setEnableStop(boolean b){
		
		buttonGameStopPanel.setButtonEnable(b);
		
	}
	
	public void setEnableLevel(boolean b){
		
		gameButtonLevelPanel.setEnableAction(b);
	
	}
	
	public LeapPanel getLeapPanel(){
		return this.leapPanel;
	}
	
}
