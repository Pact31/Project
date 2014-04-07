package affichage.ui.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;

import affichage.ui.DrawingApp;


public class GameImagePanel 
extends JPanel
{
	
	private Image image = null;
	private ButtonRestart buttonRestart;
	private ButtonMainMenu buttonMainMenu;
	private GameOverTextPanel gameOverTextPanel;
	
	public GameImagePanel(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{
		
		//image = ImageIO.read(new File("src/affichage/ui/game/images/consonnes_bn1.png"));
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		g.drawImage(image, 0, 0, null);  // Drawing image using drawImage method
 
	}
	
	public void setImage(String imageLocation) throws IOException{
		System.out.println(imageLocation);
		image = ImageIO.read(new File(imageLocation));
	}
	
}