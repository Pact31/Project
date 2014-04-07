package affichage.ui.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JPanel;

import affichage.ui.DrawingApp;
import affichage.ui.mainMenu.TitlePanel;

public class WindowGame 
extends JPanel
{
	
	private final TitlePanel             		titlePanel;
	private final ScorePanel					scorePanel;
	private final GestureShowPanel     		gestureShowPanel;
	private final TimeCountPanel       		timeCountPanel;
	
	public WindowGame(DrawingApp drawingApp, DrawingGame drawingGame){
		
		super();
		
		//Dimension(1366,768)
		//setLayout(new BorderLayout());
		this.setLayout(null);
		
		titlePanel = new TitlePanel(drawingGame);
		titlePanel.setBounds(320, 0, 200, 100);
		this.add(titlePanel);
		
		scorePanel = new ScorePanel(drawingApp, drawingGame);
		scorePanel.setBounds(480, 120, 320, 500);
		this.add(scorePanel);
		
		gestureShowPanel = new GestureShowPanel(drawingApp, drawingGame);
		gestureShowPanel.setBounds(0, 120, 480, 500);
		this.add(gestureShowPanel);
		
		timeCountPanel = new TimeCountPanel(drawingApp, drawingGame);
		timeCountPanel.setBounds(0, 100, 800, 20);
		this.add(timeCountPanel);
	}
	
	
}
