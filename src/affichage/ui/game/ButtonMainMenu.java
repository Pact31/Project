package affichage.ui.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import affichage.ui.mainMenu.DrawingMainMenu;

public class ButtonMainMenu extends JButton
implements ActionListener
{

	private static final long serialVersionUID = 1L;
	
	private final DrawingGame drawingGame;
	private final Image			image;
	private final int             width =	100;
	private final int				height = 100;
	
	public ButtonMainMenu(DrawingGame drawingGame) throws IOException{
		
		super();

		this.drawingGame = drawingGame;
		//this.setSize(new Dimension(100, 10));
		this.setBounds(390, 300, width, height);
		image = ImageIO.read(new File("src/affichage/main_menu_icon.png"));
		addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		drawingGame.close();
		   
		try {
			DrawingMainMenu drawingMainMenu = new DrawingMainMenu();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g){

		g.drawImage(image, 0, 0, width, height, null);
		
	}
}
