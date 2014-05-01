package affichage.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import affichage.gestures.Gestures;
import affichage.gestures.GesturesPositions;


public class GesturePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp 			drawingApp;	
	private final GesturesPositions 	gesturesPositions = new GesturesPositions();
	private final Image				image;
	private final int             	width =	400;
	private final int					height = 600;
	private String gesture = "src/affichage/lpc2.jpg";
	
	
	public GesturePanel(DrawingApp drawingApp) throws IOException{
		
		super();
		
		this.drawingApp = drawingApp;
		image = ImageIO.read(new File(gesture));
		setBackground(Color.WHITE);
		
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		g.drawImage(image, 0, 0, width, height, null);
	}
	

	public void notifyForUpdate(){
		
		gesture	=	drawingApp.getModel().getCurrentGesture();
		showGestures(this.getGraphics(), gesture);
	
		//image	=	drawingApp.getModel().setCurrentGesture(file)
	}
	
	
	private void showGestures(Graphics g, String gesture){
		
		Gestures gestures=gesturesPositions.getGestures(gesture);
		
		g.drawImage(image, 0, 0, width, height, null);
		g.setColor(Color.blue);
		g.drawOval(gestures.getX(), gestures.getY(), gestures.getHeight(), gestures.getWidth());
	}

}
