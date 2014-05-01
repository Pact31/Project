package affichage.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import affichage.ui.LeapMotion.OurFinger;


public class LeapPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final int width = 400, height = 600;
    
	private Color color = Color.blue;
    private Vector<OurFinger> tab = new Vector<OurFinger>();
     
    public LeapPanel (DrawingApp drawingApp) {
    	
    	
    	this.drawingApp = drawingApp;
    		
    }
   
    @Override
    public void paintComponent(Graphics g) {
    	g.setColor(Color.white);
    	g.fillRect(0,0,width,height);
        try {
			Image image = ImageIO.read(new File("src/affichage/face.png"));
			g.drawImage(image, 0, 0, 300, height, null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        g.setColor(Color.black);
        g.drawLine(0, 150, 400, 150);
        g.drawLine(0, 300, 400, 300);
        g.drawLine(0, 450, 400, 450);
        g.drawLine(200, 0, 200, 150);
        g.drawLine(399,0,399,600);
        
        for (int i =0; i< tab.size(); i++) {
        	
            color = new Color(0, 0, 0, 100 - tab.elementAt(i).getZ());
            g.setColor(color);
            g.fillOval(tab.elementAt(i).getX(), tab.elementAt(i).getY()+30, 20, 20);//circle
            //g.fillArc(tab.elementAt(i).getX(), tab.elementAt(i).getY(), 20, 200, 0, 200);//triangle
        
        }
        
        tab.clear();
    }
    
    public void setPosition(OurFinger ourFinger) {
        
        tab.add(ourFinger);
        
    }
    
    public int getWidth(){
    	
    	return width;
    
    }
    
    public int getHeight(){
    
    	return height;
    
    }
    
    }
