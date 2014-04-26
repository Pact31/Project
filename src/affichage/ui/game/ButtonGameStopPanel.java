package affichage.ui.game;

import java.io.IOException;
import javax.swing.JPanel;
import affichage.ui.DrawingApp;


public class ButtonGameStopPanel 
extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final ButtonGameStop buttonGameStop;
	
	public ButtonGameStopPanel(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{

		super();

		this.drawingApp = drawingApp;
		this.setLayout(null);
		this.add(buttonGameStop = new ButtonGameStop(drawingApp, drawingGame));
	
	}
	
	public void setButtonEnable(boolean b){
		
		buttonGameStop.setEnabled(b);
		
	}
	
}