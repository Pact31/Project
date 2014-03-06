package affichage.ui;

import java.awt.Dimension;
import javax.swing.JPanel;


public class ButtonsPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private final ButtonStart start;
	
	public ButtonsPanel(DrawingApp drawingApp){
		
		super();
		
		setPreferredSize(new Dimension(32,32));	
		add(start = new ButtonStart(drawingApp));
		
	}
	
	public ButtonStart getButtonStart(){
		
		return start;
		
	}
	
}
