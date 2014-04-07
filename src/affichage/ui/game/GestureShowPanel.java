package affichage.ui.game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

import affichage.ui.DrawingApp;
import affichage.ui.OptionMenu.TextPanel;

public class GestureShowPanel 
extends JPanel
{
	
	private final TextPanel 	textPanel;
	private TextPanel 			wordPanel;
	
	public GestureShowPanel(DrawingApp drawingApp, DrawingGame drawingGame){
		
		this.setLayout(null);
		this.setBackground(Color.pink);
		
		textPanel = new TextPanel(drawingApp, "Show this gesture : ");
		textPanel.setBounds(120, 320, 300, 20);
		this.add(textPanel);
		
		wordPanel = new TextPanel(drawingApp, "G");
		wordPanel.setBounds(180, 350, 100, 20);
		this.add(wordPanel);
		
		
		
	}
	
	
}
