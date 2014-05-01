package affichage.ui.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
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
		
		image = ImageIO.read(new File("src/affichage/ui/game/images/games/maison.png"));
		//this.setIcon(new ImageIcon("src/affichage/ui/game/images/maison.png"));
	}
	
	@Override
	public void paintComponent(Graphics g) {

		boolean i = g.drawImage(image, 0, 0, 600, 400, Color.yellow, null);  // Drawing image using drawImage method
		
		this.repaint();
 
	}
	
	public void setImage(String imageLocation) throws IOException{

		image = ImageIO.read(new File(imageLocation));
		//this.setIcon(new ImageIcon(imageLocation));
	
	}
	
}