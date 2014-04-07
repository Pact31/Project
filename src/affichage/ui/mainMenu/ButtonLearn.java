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

public class ButtonLearn extends JButton
implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private final DrawingMainMenu drawingMainMenu;
	private final Image			image;
	private final int             width =	250;
	private final int				height = 100;
	
	public ButtonLearn(DrawingMainMenu drawingMainMenu) throws IOException{
		
		super();
		//this.setSize(new Dimension(100, 10));
		this.setBounds(450, 90, width, height);
		this.drawingMainMenu = drawingMainMenu;
		image = ImageIO.read(new File("src/affichage/learning_icon.png"));
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.drawingMainMenu.close();
		// TODO Auto-generated method stub
		DrawingAppModel model = null;
		try {
			model = new	DrawingAppModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HandSpeakController handSpeakController = 	new HandSpeakController(model);
		DrawingApp drawingApp = null;
		try {
			drawingApp = new DrawingApp(handSpeakController);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * use second thread for showing the detection of Leap Motion
		*/ 
		ThreadLeapMotion threadLeapMotion 		=	new	ThreadLeapMotion(drawingApp);
		threadLeapMotion.start();
	}
	
	@Override
	public void paintComponent(Graphics g){

		g.drawImage(image, 0, 0, width, height, null);
		
	}

}
