package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GesturePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;	
	
	public GesturePanel(DrawingApp drawingApp){
		
		super();
		
		this.drawingApp = drawingApp;
		
		setPreferredSize(new Dimension(550,50));	
		setBackground(Color.WHITE);
		
	}
	
	private BufferedImage image;
	
	@Override
	protected void paintComponent(Graphics g) {
	
		try {
			image = ImageIO.read(new File("src/affichage/lpc2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null); 
	
	}
	
	public void notifyForUpdate(){
		//image	=	drawingApp.getModel().setCurrentGesture(file)
	}
}
