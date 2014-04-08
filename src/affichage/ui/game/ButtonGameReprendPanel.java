package affichage.ui.game;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;

import affichage.ui.DrawingApp;


public class ButtonGameReprendPanel 
extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final ButtonGameReprend buttonGameReprend;
	
	public ButtonGameReprendPanel(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{

		super();

		this.drawingApp = drawingApp;
		this.setLayout(null);
		this.add(buttonGameReprend = new ButtonGameReprend(drawingApp, drawingGame));
	
	}
	
}