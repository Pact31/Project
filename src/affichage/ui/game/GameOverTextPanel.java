package affichage.ui.game;

import java.awt.Font;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import affichage.ui.mainMenu.DrawingMainMenu;

public class GameOverTextPanel 
extends JLabel
{
	private static final long serialVersionUID = 1L;
	
	//private final Background backgroundPanel;

	public GameOverTextPanel(DrawingGame drawingGame){
		
		super();
		this.setBounds(200, 100,450,200);
		//this.setOpaque(false);
		//add(backgroundPanel = new Background("src/affichage/background.png"));
		//this.setBounds(500, 600, 500, 200);
		setFont(new Font("Serif", Font.BOLD, 60));
		setText("Pause!");
	}
	
	
}
