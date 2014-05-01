package affichage.ui.mainMenu;

import java.io.IOException;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MainMenuPanel 
extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	//private final Background backgroundPanel;
	private final ButtonLearnPanel buttonLearnPanel;
	
	public MainMenuPanel(DrawingMainMenu drawingMainMenu) throws IOException{
		
		super();
		this.setBounds(200, 200,300,200);
		//this.setOpaque(false);
		//add(backgroundPanel = new Background("src/affichage/background.png"));
		add(buttonLearnPanel = new ButtonLearnPanel(drawingMainMenu));
		//this.setBounds(500, 600, 500, 200);
		
	}
}
