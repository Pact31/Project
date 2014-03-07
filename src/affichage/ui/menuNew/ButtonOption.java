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
	private String	  mark   = "save";
	
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
		
		if(option)
			mark = "save";
		else
			mark = "sound";
		
		option = !option;
	
	}

	@Override
	protected final void paintComponent(Graphics g){		
		
		super.paintComponents(g);	
		int x = this.getX();
		int y = this.getY();
		
		g.setColor(Color.white);
		g.fillRect(0, 0, x+120, y+20);
		
		g.setColor(Color.red);
		g.drawString(mark, x+10, y+10);
	}

}
