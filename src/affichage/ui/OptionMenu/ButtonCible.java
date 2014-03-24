package affichage.ui.OptionMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import leapmotion.LeapDataBase;
import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;

public class ButtonCible extends JButton
implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final String name;
	
	public ButtonCible(DrawingApp drawingApp, String name){
		
		super(name);

		this.name = name;
		this.drawingApp = drawingApp;
		
		addActionListener(this);
	
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		//drawingApp.getModel().setCurrentMessage("Veuillez positionner votre main au dessus de la Leap motion, appuyer sur la touche de la clef correspondante et valider pour enregistrer.");
		//drawingApp.update(drawingApp.getModel(), null);
		DrawingAppModel model = drawingApp.getModel();
		
		if(model.getCurrentCibleOption()){
			LeapDataBase DB = new LeapDataBase();
			try {
				//DB.write("test.txt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			model.setCurrentMessage(name);
			model.setCurrentSound(name);
		}
		
		drawingApp.update(model, null);
		
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
