package affichage.ui.mainMenu;

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

import affichage.control.HandSpeakController;
import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;
import affichage.uiLeapMotion.ThreadLeapMotion;

public class ButtonQuit extends JButton
implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private final DrawingMainMenu drawingMainMenu;
	private final Image			image;
	private final int             width =	200;
	private final int				height = 150;
	
	public ButtonQuit(DrawingMainMenu drawingMainMenu, DrawingAppModel drawingAppModel) throws IOException{
		
		super();
		//this.setSize(new Dimension(100, 10));
		this.setBounds(430, 410, width, height);
		this.drawingMainMenu = drawingMainMenu;
		image = ImageIO.read(new File("src/affichage/quit.png"));
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		this.drawingMainMenu.close();

	}
	
	@Override
	public void paintComponent(Graphics g){

		g.drawImage(image, 0, 0, width, height, null);
		
	}

}
