package affichage.ui;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;


public class ButtonLeftPanel 
extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final ButtonLeft buttonLeft;
	
	public ButtonLeftPanel(DrawingApp drawingApp) throws IOException{

		super();

		this.drawingApp = drawingApp;
		this.setLayout(null);
		this.add(buttonLeft = new ButtonLeft(drawingApp));
	}
	
}