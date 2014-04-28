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

public class ButtonGameReprend extends JButton
implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final DrawingGame drawingGame;
	private final Image			image;
	private final int             width =	100;
	private final int				height = 100;
	
	public ButtonGameReprend(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{
		
		super();
		this.drawingApp = drawingApp;
		this.drawingGame = drawingGame;
		
		this.setBounds(510, 300, width, height);
		image = ImageIO.read(new File("src/affichage/start_icon.png"));
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		drawingGame.reprend();
		
	}
	
	@Override
	public void paintComponent(Graphics g){

		g.drawImage(image, 0, 0, width, height, null);
		
	}

}
