package affichage.ui.OptionMenu;


import java.awt.Dimension;
import javax.swing.JPanel;

import affichage.ui.DrawingApp;
import affichage.ui.OptionMenu.ButtonClassifierOption;


public class ButtonClassifierOptionPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private final ButtonClassifierOption buttonClassifier;
	
	public ButtonClassifierOptionPanel(DrawingApp drawingApp){
		
		super();
		
		add(buttonClassifier = new ButtonClassifierOption(drawingApp));
	
	}
	
	
}
