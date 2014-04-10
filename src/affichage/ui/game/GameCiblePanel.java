package affichage.ui.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

import affichage.ui.DrawingApp;

public class GameCiblePanel 
extends JLabel
{

	private DrawingApp drawingApp;
	private String 		cible = "Bonjour!";
	
	public GameCiblePanel(DrawingApp drawingApp, String msg){
		
		super();
		
		this.drawingApp = drawingApp;
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		int h = this.getHeight();
		int w = this.getWidth();

		g.setColor(Color.blue);
		g.drawRect(0, 0, w-1, h-1);
		
		g.setColor(Color.black);
		g.setFont(new Font("Serif", Font.BOLD, 18));
		g.drawString(cible, 0, 25);
		
		this.repaint();
			
	}
	
	public void setCible(String c){
		cible = c;
	}
	
	
}
