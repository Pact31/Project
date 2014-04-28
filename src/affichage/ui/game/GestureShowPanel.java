package affichage.ui.game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JPanel;

import affichage.ui.DrawingApp;
import affichage.ui.OptionMenu.TextPanel;

public class GestureShowPanel 
extends JPanel
{
	
	private final TextPanel 	textPanel;
	private GameCiblePanel 		gameCiblePanel;
	private GameImagePanel     gameImagePanel;
	private GameLisaTalkPanel      lisaTalkPanel;
	private TimeCountPanel       		timeCountPanel;
	
	public GestureShowPanel(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{
		
		this.setLayout(null);
		this.setBackground(Color.pink);
		
		//imagePanel = new ImagePanel(drawingApp);
		lisaTalkPanel = new GameLisaTalkPanel(drawingGame, "hello!");
		lisaTalkPanel.setBounds(40, 20, 400, 30);
		this.add(lisaTalkPanel);
		
		textPanel = new TextPanel(drawingApp, "Show this gesture : ");
		textPanel.setBounds(120, 20, 300, 30);
		//this.add(textPanel);
		
		gameCiblePanel = new GameCiblePanel(drawingApp, drawingGame.getModel().getCurrentWord());
		gameCiblePanel.setBounds(100, 470, 400, 50);
		drawingGame.getModel().setGameCiblePanel(gameCiblePanel);//add wordpanel in drawingAppModel
		this.add(gameCiblePanel);
		
		gameImagePanel = new GameImagePanel(drawingApp, drawingGame);
		gameImagePanel.setBounds(0, 50, 600, 500);
		drawingGame.getModel().setGameImagePanel(gameImagePanel);
		this.add(gameImagePanel);
		
		timeCountPanel = new TimeCountPanel(drawingApp, drawingGame);
		timeCountPanel.setBounds(0, 550, 600, 20);
		this.add(timeCountPanel);
		
	}
	
	
}
