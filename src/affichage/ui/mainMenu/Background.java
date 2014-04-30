package affichage.ui.mainMenu;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Background 
extends JComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1872806178250761250L;

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
