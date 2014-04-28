package affichage.ui.mainMenu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import affichage.model.DrawingAppModel;
import affichage.ui.LeapMotion.ThreadLeapMotion;

public class ButtonLearn extends JButton
implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private final DrawingMainMenu drawingMainMenu;
	private final DrawingAppModel drawingAppModel;
	private final Image			image;
	private final int             width =	150;
	private final int				height = 150;
	
	public ButtonLearn(DrawingMainMenu drawingMainMenu, DrawingAppModel drawingAppModel) throws IOException{
		
		super();
		
		this.drawingMainMenu = drawingMainMenu;
		this.drawingAppModel = drawingAppModel;
		this.setBounds(350, 90, width, height);
		
		image = ImageIO.read(new File("src/affichage/learning_icon.png"));
		
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		this.drawingMainMenu.close();
	
		/*
		 * use second thread for showing the detection of Leap Motion
		*/ 
		ThreadLeapMotion threadLeapMotion 		=	new	ThreadLeapMotion(drawingAppModel.getDrawingApp());
		threadLeapMotion.start();
		
		this.drawingAppModel.getDrawingApp().open();
		System.out.println("Learn App done, Main menu open");
		threadLeapMotion.threadStop();
		this.drawingMainMenu.open();
	
	}
	
	@Override
	public void paintComponent(Graphics g){

		g.drawImage(image, 0, 0, width, height, null);
		
	}
	

}
