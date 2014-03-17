package affichage.ui.Newmenu;

import javax.swing.JPanel;
import affichage.ui.DrawingApp;

public class ButtonCiblePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final ButtonCible buttonCible;
	private final DrawingApp drawingApp;
	
	
	public ButtonCiblePanel(DrawingApp drawingApp, String name){
		
		super();
		this.drawingApp = drawingApp;
		
		//setPreferredSize(new Dimension(50,50));	
		add(buttonCible = new ButtonCible(drawingApp, name));
		
	}
	
}
