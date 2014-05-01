package affichage.ui;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;


public class ButtonExecutionPanel 
extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	private final ButtonExecution buttonExecution;
	
	public ButtonExecutionPanel(DrawingApp drawingApp) throws IOException{

		super();

		this.setLayout(null);
		this.add(buttonExecution = new ButtonExecution(drawingApp));
	}
	
}