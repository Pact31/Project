package affichage.ui.game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JPanel;

import affichage.ui.DrawingApp;
import affichage.ui.OptionMenu.TextPanel;

public class GestureShowPanel 
extends JPanel
{
	
	private final TextPanel 	textPanel;
	private TextPanel 			wordPanel;
	private GameImagePanel     gameImagePanel;
	
	public GestureShowPanel(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{
		
		this.setLayout(null);
		this.setBackground(Color.pink);
		
		//imagePanel = new ImagePanel(drawingApp);
		
		
		textPanel = new TextPanel(drawingApp, "Show this gesture : ");
		textPanel.setBounds(120, 320, 300, 20);
		this.add(textPanel);
		
		wordPanel = new TextPanel(drawingApp, drawingApp.getModel().getCurrentWord());
		wordPanel.setBounds(180, 350, 100, 20);
		drawingApp.getModel().setTextPanel(wordPanel);//add wordpanel in drawingAppModel
		this.add(wordPanel);
		
		gameImagePanel = new GameImagePanel(drawingApp, drawingGame);
		gameImagePanel.setBounds(100, 20, 300, 500);
		drawingApp.getModel().setGameImagePanel(gameImagePanel);
		this.add(gameImagePanel);
	}
	
	
}
