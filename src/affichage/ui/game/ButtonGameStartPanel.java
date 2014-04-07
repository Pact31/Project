package affichage.ui.game;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;

import affichage.ui.DrawingApp;


public class ButtonGameStartPanel 
extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final ButtonGameStart buttonGameStart;
	
	public ButtonGameStartPanel(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{

		super();

		this.drawingApp = drawingApp;
		this.setLayout(null);
		this.add(buttonGameStart = new ButtonGameStart(drawingApp, drawingGame));
	
	}
	
}