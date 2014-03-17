package affichage.ui;

import java.awt.Dimension;
import javax.swing.JPanel;


public class ButtonStartPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private final ButtonStart start;
	private final ButtonClassifierOption buttonClassifier;
	
	public ButtonStartPanel(DrawingApp drawingApp){
		
		super();
		setPreferredSize(new Dimension(32,32));	
		add(start = new ButtonStart(drawingApp));
		add(buttonClassifier = new ButtonClassifierOption(drawingApp));
	
	}
	
	public ButtonStart getButtonStart(){
		
		return start;
		
	}
	
}
