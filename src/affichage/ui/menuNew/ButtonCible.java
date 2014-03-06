package affichage.ui.menuNew;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import leapmotion.LeapDataBase;

import affichage.ui.DrawingApp;

public class ButtonCible extends JButton
implements ActionListener

{
	private final DrawingApp drawingApp;
	private final String name;
	
	public ButtonCible(DrawingApp drawingApp, String name){
		super(name);
		this.name = name;
		this.drawingApp = drawingApp;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//drawingApp.getModel().setCurrentMessage("Veuillez positionner votre main au dessus de la Leap motion, appuyer sur la touche de la clef correspondante et valider pour enregistrer.");
		//drawingApp.update(drawingApp.getModel(), null);
		//LeapDataBase DB = new LeapDataBase();
		//DB.write(name);
		
	}
/*	
	@Override
	protected final void paintComponent(Graphics g){		
		
		super.paintComponents(g);
		
		int w = getWidth();
		int h = getHeight();
		
		
		g.setColor(Color.white);
		g.drawRect(2, 2, w - 5, h - 5);
			
		g.drawString("haha", h, w);
		
	}
*/
}
