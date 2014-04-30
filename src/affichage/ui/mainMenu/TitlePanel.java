package affichage.ui.mainMenu;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import affichage.ui.game.DrawingGame;


public class TitlePanel 
extends JLabel
{
	
	private static final long serialVersionUID = 1L;
	
	public TitlePanel(DrawingMainMenu drawingMainMenu){

		super();
		
		this.setSize(new Dimension(100, 200));
		this.setBounds(480, 0, 200, 100);

		setFont(new Font("Serif", Font.ITALIC, 20));
		setText("Hand Speak");
	}
	

	public TitlePanel(DrawingGame drawingGame){

		super();
		
		this.setSize(new Dimension(100, 200));
		
		setFont(new Font("Serif", Font.ITALIC, 18));
		setText("Hand Speak Game");
	}
	

}