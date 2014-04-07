package affichage.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import affichage.model.DrawingAppModel;

public class ButtonStart extends JButton
	implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private			Color	   currentButtonClor	= Color.CYAN;
	private			String	   currentButtonMark	= "Start";
	
	public ButtonStart(DrawingApp drawingApp){
		
		super("Start");
		this.drawingApp = drawingApp;
		
		addActionListener(this);
		
	}
	
	@Override
	protected final void paintComponent(Graphics g){		
		
		super.paintComponents(g);
		
		int w = getWidth();
		int h = getHeight();
		
		g.setColor(this.currentButtonClor);
		g.fillRect(0, 0, w, h);
		
		g.setColor(Color.BLACK);
		g.drawRect(2, 2, w - 5, h - 5);
			
		g.drawString(this.currentButtonMark, w/2 - 15 , h/2 + 5);
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		DrawingAppModel model = drawingApp.getModel();
		try {
			drawingApp.getHandSpeakController().launchceLeapMotion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		drawingApp.update(model, null);

	}
	
	public void notifyForUpdate(){
		
		this.currentButtonMark	=	drawingApp.getModel().getCurrentBottonMark();
		this.currentButtonClor	=	drawingApp.getModel().getCurrentBottonColor();
		
	}

}
