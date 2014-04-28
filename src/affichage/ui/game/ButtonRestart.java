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
import affichage.ui.mainMenu.DrawingMainMenu;

public class ButtonRestart extends JButton
implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingGame drawingGame;
	private final DrawingApp drawingApp;
	private final Image			image;
	private final int             width =	100;
	private final int				height = 100;
	
	public ButtonRestart(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{
		
		super();

		this.drawingGame = drawingGame;
		this.drawingApp = drawingApp;
		//this.setSize(new Dimension(100, 10));
		this.setBounds(270, 300, width, height);
		image = ImageIO.read(new File("src/affichage/restart_icon.png"));
		addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		drawingGame.getModel().setGameDone(true);
		drawingGame.close();
		
		/*
		try {
			DrawingGame drawingGame = new DrawingGame(drawingApp);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
	}
	
	@Override
	public void paintComponent(Graphics g){

		g.drawImage(image, 0, 0, width, height, null);
		
	}

}
