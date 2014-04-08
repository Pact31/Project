package affichage.ui.OptionMenu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import affichage.ui.DrawingApp;


public class TextPanel 
extends JLabel
{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	
	public TextPanel(DrawingApp drawingApp, String msg){

		super(msg);
		
		this.drawingApp = drawingApp;

	}
}