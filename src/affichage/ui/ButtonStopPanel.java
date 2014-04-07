package affichage.ui;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;


public class ButtonStopPanel 
extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final ButtonStop buttonStop;
	
	public ButtonStopPanel(DrawingApp drawingApp) throws IOException{

		super();

		this.drawingApp = drawingApp;
		this.setLayout(null);
		this.add(buttonStop = new ButtonStop(drawingApp));
	}
	
}