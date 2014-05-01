package affichage.ui.game;

import java.awt.Color;

import javax.swing.JPanel;

import affichage.ui.DrawingApp;
import affichage.ui.OptionMenu.TextPanel;

public class ScorePanel 
extends JPanel
{
	
	private final TextPanel scorePanel;
	private final TextPanel levelPanel;
	
	public ScorePanel(DrawingApp drawingApp, DrawingGame drawingGame){
		
		this.setLayout(null);
		this.setBackground(Color.CYAN);
		
		scorePanel		= 	new TextPanel(drawingApp, "Score : ");
		scorePanel.setBounds(50, 50, 100, 20);
		this.add(scorePanel);
		
		levelPanel      = 	new TextPanel(drawingApp, "Level : ");
		levelPanel.setBounds(50, 100, 100, 20);
		this.add(levelPanel);
		
	}
	
}