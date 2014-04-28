package affichage.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;

public class ButtonExecution extends JButton
implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final Image			image;
	private final int             width =	100;
	private final int				height = 100;
	
	public ButtonExecution(DrawingApp drawingApp) throws IOException{
		
		super();
		this.drawingApp = drawingApp;
		this.setSize(width, height);
		image = ImageIO.read(new File("src/affichage/start_icon.png"));
		addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		DrawingAppModel model = drawingApp.getModel();
		
		try {
			drawingApp.getHandSpeakController().launchLeapMotion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		drawingApp.update(model, null);
		
	}
	
	@Override
	public void paintComponent(Graphics g){

		g.drawImage(image, 0, 0, width, height, null);
		
	}

}
