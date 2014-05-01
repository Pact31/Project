package affichage.ui.game;

import java.awt.Color;

import javax.swing.JPanel;

import affichage.ui.DrawingApp;

public class TimePanel 
extends JPanel
{

	
	public TimePanel(DrawingGame drawingGame, Color c){
		
		this.setLayout(null);
		this.setBackground(c);
		
	}
	
	public void setLocation(int i){
	
		this.setBounds(i/*20*i*/, 0, 20, 20);
		
		/*if(i > 10){
			this.setBackground(Color.red);
		}
		else if(i > 5){
			this.setBackground(Color.orange);
		}*/
		
	}

}
