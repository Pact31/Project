package affichage.ui.OptionMenu;

import javax.swing.JPanel;
import affichage.ui.DrawingApp;

public class ButtonOptionPanel 
extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final ButtonOption	 	buttonOption;
	private final DrawingApp 		drawingApp;
	
	
	public ButtonOptionPanel(DrawingApp drawingApp){
		
		super();
		this.drawingApp = drawingApp;
		
		//setPreferredSize(new Dimension(50,50));	
		add(buttonOption = new ButtonOption(drawingApp));
		
	}
	
}
