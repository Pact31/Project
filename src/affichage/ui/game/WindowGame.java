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
	
	private final TitlePanel             		titlePanel;
	private final ScorePanel					scorePanel;
	private final GestureShowPanel     		gestureShowPanel;
	private final TimeCountPanel       		timeCountPanel;
	private final ButtonGameStartPanel        	buttonGameStartPanel;
	private final ButtonGameStopPanel			buttonGameStopPanel;
	
	public WindowGame(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{
		
		super();
		
		//Dimension(1366,768)
		//setLayout(new BorderLayout());
		this.setLayout(null);
		//this.setBackground(Color);
		
		titlePanel = new TitlePanel(drawingGame);
		titlePanel.setBounds(320, 0, 200, 100);
		this.add(titlePanel);
		
		scorePanel = new ScorePanel(drawingApp, drawingGame);
		scorePanel.setBounds(480, 120, 320, 500);
		this.add(scorePanel);
		
		gestureShowPanel = new GestureShowPanel(drawingApp, drawingGame);
		gestureShowPanel.setBounds(0, 120, 480, 500);
		this.add(gestureShowPanel);
		
		timeCountPanel = new TimeCountPanel(drawingApp, drawingGame);
		timeCountPanel.setBounds(0, 100, 800, 20);
		this.add(timeCountPanel);
		
		buttonGameStartPanel = new ButtonGameStartPanel(drawingApp, drawingGame);
		buttonGameStartPanel.setBounds(10, 20, 100, 70);
		this.add(buttonGameStartPanel);
	
		buttonGameStopPanel = new ButtonGameStopPanel(drawingApp, drawingGame);
		buttonGameStopPanel.setBounds(700, 20, 100, 70);
		this.add(buttonGameStopPanel);
	}
	
	
}
