package affichage.ui.mainMenu;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;


public class TitlePanel 
extends JLabel
{
	
	private static final long serialVersionUID = 1L;
	
	//private final ButtonLearn learn;
	private final DrawingMainMenu drawingMainMenu;
	
	public TitlePanel(DrawingMainMenu drawingMainMenu){

		super();
		
		this.drawingMainMenu = drawingMainMenu;
		this.setSize(new Dimension(100, 200));
		this.setBounds(520, 0, 200, 100);
		//add(learn = new ButtonLearn(drawingMainMenu));
		setFont(new Font("Serif", Font.ITALIC, 18));
		setText("Hand Speak");
	}
	
}