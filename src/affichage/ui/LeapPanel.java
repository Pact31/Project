package affichage.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

import affichage.ui.LeapMotion.OurFinger;


public class LeapPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final int width = 400, height = 600;
    
	private Color color = Color.BLUE;
    private Vector<OurFinger> tab = new Vector<OurFinger>();
     
    public LeapPanel (DrawingApp drawingApp) {
    	
    	
    	this.drawingApp = drawingApp;
    		
    }
   
    @Override
    public void paintComponent(Graphics g) {
        
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        
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
