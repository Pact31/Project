package affichage.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import affichage.ui.DrawingApp;

public class ButtonLeft extends JButton
implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final int             width =	100;
	private final int				height = 100;

	public ButtonLeft(DrawingApp drawingApp) throws IOException{
		
		super();
		this.drawingApp = drawingApp;
		this.setSize(width, height);
		this.setIcon(new ImageIcon("src/affichage/hand-point-left.jpg"));
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		drawingApp.close();
		
	}
	
}
