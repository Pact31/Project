package ui;

import javax.swing.*;

import com.leapmotion.leap.*;

import java.awt.*;
import java.util.Vector;

import leapMotion.Finger;

public class LeapPanel extends JPanel{
	
	private final DrawingApp drawingApp;
	private final int width = 800, height = 630;
    
	private Color color = Color.BLUE;
    private Vector<Finger> tab = new Vector<Finger>();
     
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
            //g.fillOval(tab.elementAt(i).getX(), tab.elementAt(i).getY(), 20, 20);
            g.fillArc(tab.elementAt(i).getX(), tab.elementAt(i).getY(), 20, 200, 0, 200);
        
        }
        
        tab.clear();
    }
    
    public void setPosition(Finger d) {
        
        tab.add(d);
        
    }
    
    public int getWidth(){
    	
    	return width;
    
    }
    
    public int getHeight(){
    
    	return height;
    
    }
    
    }
