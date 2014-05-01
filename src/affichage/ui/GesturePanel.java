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

import classif.Cible;

import affichage.gestures.Gestures;
import affichage.gestures.GesturesPositions;


public class GesturePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp 			drawingApp;	
	private final GesturesPositions 	gesturesPositions = new GesturesPositions();
	private final Image				image;
	private final int             	width =	400;
	private final int					height = 1000;
	private String gesture = "src/affichage/notice.png";
	
	
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
	
	
	private Cible cible;
	public void notifyForUpdate(){
		
		//gesture	=	drawingApp.getModel().getCurrentGesture();
		cible = drawingApp.getModel().getCurrentCible();
		showGestures(this.getGraphics(), cible);
	
		//image	=	drawingApp.getModel().setCurrentGesture(file)
	}
	
	private String				imageVoyelle;
	private String				imageConsonne;
	private void showGestures(Graphics g, Cible cible){
		
		//Gestures gestures=gesturesPositions.getGestures(gesture);
		Gestures gestures = gesturesPositions.getGestures(cible);
		
		imageVoyelle = gestures.getVoyelle();
		imageConsonne = gestures.getConsonne();
		g.drawImage(imageVoyelle, 0, 0, width, height, null);
		g.drawImage(imageVoyelle, 0, 0, width, height, null);
		//g.setColor(Color.blue);
		//g.drawOval(gestures.getX(), gestures.getY(), gestures.getHeight(), gestures.getWidth());
	}

}
