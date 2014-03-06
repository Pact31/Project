package affichage.ui.menuNew;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import affichage.ui.DrawingApp;

public class ButtonOption extends JButton
implements ActionListener

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp;
	private boolean option = true;
	public ButtonOption(DrawingApp drawingApp){
		
		super("Son");
		this.drawingApp = drawingApp;
		
		addActionListener(this);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//drawingApp.getModel().setCurrentMessage("Veuillez positionner votre main au dessus de la Leap motion, appuyer sur la touche de la clef correspondante et valider pour enregistrer.");
		//drawingApp.update(drawingApp.getModel(), null);
		drawingApp.getModel().setCurrentCibleOption(option);
		option = !option;
	}

	@Override
	protected final void paintComponent(Graphics g){		
		
		super.paintComponents(g);	
		int x = this.getX();
		int y = this.getY();
		g.setColor(Color.white);
		if(option)
			g.drawString("Store", x+11, y+11);
		else
			g.drawString("Sound", x+11, y+11);
	}

}
