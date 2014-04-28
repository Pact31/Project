package affichage.ui.OptionMenu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;

public class ButtonClassifierOption extends JButton
	implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private String option = "KPPV";
	
	public ButtonClassifierOption(DrawingApp drawingApp){
		
		super("KPPV");
		this.drawingApp = drawingApp;		
		addActionListener(this);
		
	}
	
	@Override
	protected final void paintComponent(Graphics g){		
		
		super.paintComponents(g);
		int w = getWidth();
		int h = getHeight();
		
		g.setColor(Color.white);
		g.fillRect(0, 0, w+10, h);
		
		g.setColor(Color.red);
		g.drawString(option, w/2-31, h/2+5);
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		DrawingAppModel model = drawingApp.getModel();
		
		if(option == "KPPV"){
			option = "Adaboost";
		}
		else{
			option = "KPPV";
		}

		model.setCurrentClassifer(option);
	
	}
	
}
