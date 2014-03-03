package affichage.ui;

import affichage.gestures.GesturesPositions;
import affichage.gestures.Gestures;

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
	private final GesturesPositions gesturesPositions = new GesturesPositions();
	
	public GesturePanel(DrawingApp drawingApp){
		
		super();
		
		this.drawingApp = drawingApp;
		
		setPreferredSize(new Dimension(550,50));	
		setBackground(Color.WHITE);
		
	}
	
	private BufferedImage image;
	private String gesture = "src/affichage/lpc2.jpg";
	
	@Override
	protected void paintComponent(Graphics g) {
	
		try {
			image = ImageIO.read(new File("src/affichage/lpc2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.paintComponent(g);
		g.drawImage(image, 100, 0, null);
	}
	

	public void notifyForUpdate(){
		
		gesture	=	drawingApp.getModel().getCurrentGesture();
		showGestures(this.getGraphics(), gesture);
	
	}
	
	
	private void showGestures(Graphics g, String gesture){
		
		Gestures gestures=gesturesPositions.getGestures(gesture);
		
		g.drawImage(image, 100, 0, null);
		g.setColor(Color.blue);
		g.drawOval(gestures.getX(), gestures.getY(), gestures.getHeight(), gestures.getWidth());
	}

}
