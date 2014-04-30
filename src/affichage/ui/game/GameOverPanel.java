package affichage.ui.game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import affichage.ui.DrawingApp;


public class GameOverPanel 
extends JComponent
{
	
	private final Image image;
	private ButtonRestart buttonRestart;
	private ButtonMainMenu buttonMainMenu;
	private ButtonGameReprend buttonGameReprend;
	private GameOverTextPanel gameOverTextPanel;

	public GameOverPanel(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{
		
		image = ImageIO.read(new File("src/affichage/background.jpg"));
		
		gameOverTextPanel = new GameOverTextPanel(drawingGame);
		this.add(gameOverTextPanel);
		
		buttonRestart = new ButtonRestart(drawingApp, drawingGame);
		//this.add(buttonRestart);
		
		buttonMainMenu = new ButtonMainMenu(drawingGame);
		this.add(buttonMainMenu);
		
		buttonGameReprend = new ButtonGameReprend(drawingApp, drawingGame);
		this.add(buttonGameReprend);
	
	}
	
	@Override
	public void paintComponent(Graphics g) {
 
		g.drawImage(image, 0, 0, null);  // Drawing image using drawImage method
 
	}
	
}
