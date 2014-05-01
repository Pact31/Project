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
	//private final Image				image;
	private String gesture = "src/affichage/images/cible/";
	private Image				imageConsonne;
	private Image				imageVoyelle;
	
	public GesturePanel(DrawingApp drawingApp) throws IOException{
		
		super();
		
		this.drawingApp = drawingApp;

		imageVoyelle   = ImageIO.read(new File(gesture + "Image16.png"));
		imageConsonne  = ImageIO.read(new File(gesture + "Image30.png"));
		//this.showGestures(this.getGraphics(), Cible.BNUI_P);
		setBackground(Color.WHITE);
		
	}

	
	@Override
	protected void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		g.drawImage(imageVoyelle, 0, 0, 400, 300, null);
		g.drawImage(imageConsonne, 50, 300, 300,400, null);
		
	}
	
	
	private Cible cible;
	public void notifyForUpdate() throws IOException{
		
		//gesture	=	drawingApp.getModel().getCurrentGesture();
		cible = drawingApp.getModel().getCurrentCible();
		showGestures(this.getGraphics(), cible);
	
		//image	=	drawingApp.getModel().setCurrentGesture(file)
	}
	private void showGestures(Graphics g, Cible cible) throws IOException{
		
		//Gestures gestures=gesturesPositions.getGestures(gesture);
		Gestures gestures = gesturesPositions.getGestures(cible);
		
		System.out.println(gestures.getVoyelle());
		File file = new File(gestures.getVoyelle());
		System.out.println(file.exists());
		imageVoyelle = ImageIO.read(new File(gestures.getVoyelle()));
		imageConsonne = ImageIO.read(new File(gestures.getConsone()));
		this.repaint();
	}

}
