package affichage.ui.game;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JPanel;

import affichage.ui.DrawingApp;

public class ButtonGameLevelPanel 
extends JPanel
{

	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final ButtonGameLevel buttonGameLevel;
	private final ButtonGameLevel buttonGameLevel2;
	private final ButtonGameLevel buttonGameLevel3;
	
	public ButtonGameLevelPanel(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{

		super();

		this.drawingApp = drawingApp;
		
		this.setLayout(null);
		
		buttonGameLevel = new ButtonGameLevel(drawingApp, drawingGame, "easy", this);
		buttonGameLevel.setBounds(0, 0, 50, 50);
		this.add(buttonGameLevel);
		
		buttonGameLevel2 = new ButtonGameLevel(drawingApp, drawingGame, "moyen", this);
		buttonGameLevel2.setBounds(50, 0, 50, 50);
		this.add(buttonGameLevel2);
		
		buttonGameLevel3 = new ButtonGameLevel(drawingApp, drawingGame, "difficult", this);
		buttonGameLevel3.setBounds(100, 0, 50, 50);
		this.add(buttonGameLevel3);
		
	}
	
	public void setEnableAction(boolean b){
		
		this.buttonGameLevel.setEnabled(b);
		this.buttonGameLevel2.setEnabled(b);
		this.buttonGameLevel3.setEnabled(b);
		
	}
	
}
