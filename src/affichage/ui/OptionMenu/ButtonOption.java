package affichage.ui.OptionMenu;

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
		g.fillRect(0, 0, x+80, y+20);
		
		g.setColor(Color.red);
		g.drawString(mark, x-15, y+10);
	
	}

}
