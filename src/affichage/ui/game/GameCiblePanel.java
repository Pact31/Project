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
	private String     previousCible = "";
	private Color      color = Color.black;
	private int		location = 0;
	
	public GameCiblePanel(DrawingApp drawingApp, String msg){
		
		super();
		
		this.drawingApp = drawingApp;
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		int h = this.getHeight();
		int w = this.getWidth();

		g.setColor(Color.cyan);
		g.drawRect(0, 0, w-1, h-1);
		
		g.setFont(new Font("Serif", Font.BOLD, 18));
		g.setColor(color);
		
		switch(location){
		case 0: g.drawString(cible, 10, 30);
			break;
		case 1:	g.drawString(previousCible, 10, 30); 
				//g.drawString(cible, 80, 30);
			break;
		case 2:	g.drawString(previousCible, 10, 30);
				//g.drawString(cible, 150, 30);
			break;
		}
		
	
		//this.repaint();
			
	}
	
	public void setCible(String c, int l){
	
		cible = c;
		location = l;
		
		//System.out.println(c);
		this.repaint();
	
		previousCible = previousCible + c;
	}
	
	public void setColor(Color c){
		
		color = c;
	
	}
	
	public void clear(){
		
		previousCible = "";
		location = 0;
		this.repaint();
		
	}
	
	
}
