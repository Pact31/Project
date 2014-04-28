package affichage.ui.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import affichage.ui.DrawingApp;


public class GameLevelPanel 
extends JPanel
{
	
	private Image 				image = null;
	private ButtonRestart 		buttonRestart;
	private ButtonMainMenu 		buttonMainMenu;
	private GameOverTextPanel 	gameOverTextPanel;
	
	public GameLevelPanel(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{
		
		image = ImageIO.read(new File("src/affichage/ui/game/images/maison.jpg"));
		
	}
	
	@Override
	public void paintComponent(Graphics g) {

		boolean i = g.drawImage(image, 0, 0, 600, 400, Color.yellow, null);  // Drawing image using drawImage method
		
		this.repaint();
 
	}
	
	public void setImage(String imageLocation) throws IOException{

		image = ImageIO.read(new File(imageLocation));
	
	}
	
}