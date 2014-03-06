package affichage.ui;

import affichage.ui_leapmotion.OurFinger;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;


public class LeapPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final int width = 800, height = 595;
    
	private Color color = Color.BLUE;
    private Vector<OurFinger> tab = new Vector<OurFinger>();
     
    public LeapPanel (DrawingApp drawingApp) {
    	
    	this.drawingApp = drawingApp;
    		
    }
   
    @Override
    public void paintComponent(Graphics g) {
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        
        for (int i =0; i< tab.size(); i++) {
        	
            color = new Color(0, 0, 0, 100 - tab.elementAt(i).getZ());
            g.setColor(color);
            g.fillOval(tab.elementAt(i).getX(), tab.elementAt(i).getY(), 20, 20);//circle
            //g.fillArc(tab.elementAt(i).getX(), tab.elementAt(i).getY(), 20, 200, 0, 200);//triangle
        
        }
        
        tab.clear();
    }
    
    public void setPosition(OurFinger d) {
        
        tab.add(d);
        
    }
    
    public int getWidth(){
    	
    	return width;
    
    }
    
    public int getHeight(){
    
    	return height;
    
    }
    
    }
