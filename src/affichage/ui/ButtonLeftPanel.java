package affichage.ui;

import java.io.IOException;
import javax.swing.JPanel;


public class ButtonLeftPanel 
extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	
	public ButtonLeftPanel(DrawingApp drawingApp) throws IOException{

		super();

		this.setLayout(null);
		this.add(new ButtonLeft(drawingApp));
	
	}
	
}