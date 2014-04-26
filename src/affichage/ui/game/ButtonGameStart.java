package affichage.ui.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import affichage.ui.DrawingApp;

public class ButtonGameStart extends JButton
implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp 		drawingApp;
	private final DrawingGame 		drawingGame;
	private final Image			image;
	private final int             width =	100;
	private final int				height = 100;
	
	public ButtonGameStart(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{
		
		super();
		this.drawingApp 	 = 	drawingApp;
		this.drawingGame	 = 	drawingGame;
		
		this.setSize(width, height);
		image = ImageIO.read(new File("src/affichage/start_icon.png"));
		addActionListener(this);
		this.setEnabled(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		drawingGame.getModel().setGameThreadRunning(true);
		drawingGame.getWindowGame().setEnableStop(true);
		
		System.out.println("Game starts!");
		//drawingApp.getModel().getCurrentThreadTimeCount().start();
		//drawingApp.getModel().getCurrentThreadTimeCount().notify();
		this.setEnabled(false);
	}
	
	@Override
	public void paintComponent(Graphics g){

		g.drawImage(image, 0, 0, width, height, null);
		
	}

}
