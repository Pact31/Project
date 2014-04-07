package affichage.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import affichage.ui.DrawingApp;
import affichage.ui.mainMenu.DrawingMainMenu;

public class ButtonStop extends JButton
implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final Image			image;
	private final int             width =	100;
	private final int				height = 50;
	
	public ButtonStop(DrawingApp drawingApp) throws IOException{
		
		super();
		this.drawingApp = drawingApp;
		this.setSize(width, height);
		image = ImageIO.read(new File("src/affichage/stop_icon.png"));
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		
		
	}
	
	@Override
	public void paintComponent(Graphics g){

		g.drawImage(image, 0, 0, width, height, null);
		
	}

}
