package affichage.ui.mainMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Background 
extends JComponent{
	
	private Image image;
	//private MainMenuPanel mainMenuPanel;
	
	
	public Background(DrawingMainMenu drawingMainMenu) throws IOException{
		
		image = ImageIO.read(new File("src/affichage/background.jpg"));
		//mainMenuPanel = new MainMenuPanel(drawingMainMenu);
	}
	
	@Override
	public void paintComponent(Graphics g) {
 
		g.drawImage(image, 0, 0, null);  // Drawing image using drawImage method
 
	}
		
}
