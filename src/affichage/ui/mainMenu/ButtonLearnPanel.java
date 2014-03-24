package affichage.ui.mainMenu;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import affichage.ui.ButtonStart;
import affichage.ui.OptionMenu.ButtonClassifierOption;

public class ButtonLearnPanel 
extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	//private final ButtonLearn learn;
	private final DrawingMainMenu drawingMainMenu;
	
	public ButtonLearnPanel(DrawingMainMenu drawingMainMenu){

		super();
		
		this.drawingMainMenu = drawingMainMenu;
		this.setSize(new Dimension(100, 100));
		//add(learn = new ButtonLearn(drawingMainMenu));
	
	}
	
}
