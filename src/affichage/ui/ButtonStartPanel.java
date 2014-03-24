package affichage.ui;

import java.awt.Dimension;
import javax.swing.JPanel;

import affichage.ui.OptionMenu.ButtonClassifierOption;


public class ButtonStartPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private final ButtonStart start;
	
	public ButtonStartPanel(DrawingApp drawingApp){
		
		super();
		add(start = new ButtonStart(drawingApp));
	
	}
	
	public ButtonStart getButtonStart(){
		
		return start;
		
	}
	
}
