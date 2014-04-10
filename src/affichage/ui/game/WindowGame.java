package affichage.ui.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JPanel;

import affichage.ui.DrawingApp;
import affichage.ui.mainMenu.TitlePanel;

public class WindowGame 
extends JPanel
{
	
	//private final TitlePanel             		titlePanel;
	private final ScorePanel					scorePanel;
	private final GestureShowPanel     		gestureShowPanel;
	private final TimeCountPanel       		timeCountPanel;
	private final ButtonGameStartPanel        	buttonGameStartPanel;
	private final ButtonGameStopPanel			buttonGameStopPanel;
	private final GameLisaPanel				gameLisaPanel;
	private final ButtonGameLevelPanel        	gameButtonLevelPanel;
	
	public WindowGame(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{
		
		super();
		
		this.setLayout(null);
		/*
		titlePanel = new TitlePanel(drawingGame);
		titlePanel.setBounds(320, 0, 200, 100);
		this.add(titlePanel);
		*/
		scorePanel = new ScorePanel(drawingApp, drawingGame);
		scorePanel.setBounds(600, 300, 200, 200);
		this.add(scorePanel);
		drawingGame.getModel().setScorePanel(scorePanel);
		
		gestureShowPanel = new GestureShowPanel(drawingApp, drawingGame);
		gestureShowPanel.setBounds(0, 0, 600, 600);
		this.add(gestureShowPanel);
		
		timeCountPanel = new TimeCountPanel(drawingApp, drawingGame);
		timeCountPanel.setBounds(0, 100, 800, 20);
		//this.add(timeCountPanel);
		
		gameLisaPanel =	new GameLisaPanel(drawingApp, drawingGame);
		gameLisaPanel.setBounds(600, 0, 200, 300);
		this.add(gameLisaPanel);
		/*------------ Buttons ----------------------*/
		gameButtonLevelPanel = new ButtonGameLevelPanel(drawingApp, drawingGame);
		gameButtonLevelPanel.setBounds(450, 0, 150, 50);
		this.add(gameButtonLevelPanel);

		buttonGameStartPanel = new ButtonGameStartPanel(drawingApp, drawingGame);
		buttonGameStartPanel.setBounds(600, 500, 100, 100);
		this.add(buttonGameStartPanel);
	
		buttonGameStopPanel = new ButtonGameStopPanel(drawingApp, drawingGame);
		buttonGameStopPanel.setBounds(700, 500, 100, 100);
		this.add(buttonGameStopPanel);
		
		/*--------------------------------------------*/
	}
	
	
}
