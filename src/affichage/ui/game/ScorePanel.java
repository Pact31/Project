package affichage.ui.game;

import java.awt.Color;
import java.util.Hashtable;

import javax.swing.JPanel;

import affichage.ui.DrawingApp;
import affichage.ui.OptionMenu.TextPanel;

public class ScorePanel 
extends JPanel
{
	
	private final TextPanel scorePanel;
	private final TextPanel levelPanel;
	private DrawingGame drawingGame;
	private Hashtable<String, String> levelText = new Hashtable<String, String>();
	
	public ScorePanel(DrawingApp drawingApp, DrawingGame drawingGame){
		
		this.drawingGame = drawingGame;
		
		this.setLayout(null);
		this.setBackground(Color.orange);
		
		scorePanel		= 	new TextPanel(drawingApp, "Score : ");
		scorePanel.setBounds(50, 50, 120, 20);
		this.add(scorePanel);
		
		levelPanel      = 	new TextPanel(drawingApp, "Niveau : ");
		levelPanel.setBounds(50, 100, 120, 20);
		this.add(levelPanel);
		
		setLevelText();
		
	}
	
	public void setScore(int i){
		scorePanel.setText("Score : " + String.valueOf(i));
	}
	
	public void setLevel(int i){
		levelPanel.setText("Level : " + levelText.get(drawingGame.getModel().getGameLevel()));
	}
	
	private void setLevelText(){
		levelText.put("easy", "Facile");
		levelText.put("moyen", "Moyen");
		levelText.put("difficult", "Difficil");
	}
}
