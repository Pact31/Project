package affichage.ui.mainMenu;
import java.awt.Dimension;

import javax.swing.JPanel;


public class ButtonHelpPanel 
extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	//private final ButtonLearn learn;
	private final DrawingMainMenu drawingMainMenu;
	
	public ButtonHelpPanel(DrawingMainMenu drawingMainMenu){

		super();
		
		this.drawingMainMenu = drawingMainMenu;
		this.setSize(new Dimension(100, 100));
		//add(learn = new ButtonLearn(drawingMainMenu));
	
	}
	
}