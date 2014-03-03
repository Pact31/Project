package affichage.leapMotion;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Pointable;
import com.leapmotion.leap.PointableList;
import com.leapmotion.leap.Vector;
import com.leapmotion.leap.InteractionBox;
import affichage.ui.DrawingApp;
import affichage.ui.LeapPanel;

public class ThreadLeapMotion 	extends Thread
{
	
	private final DrawingApp drawingApp;
	
	public ThreadLeapMotion(DrawingApp drawingApp){
	
		this.drawingApp = drawingApp;
	
	}
	
	private Vector normalizedPosition;
	private Controller leap = new Controller();
	
	@Override
	public void run(){
		
		LeapPanel leapPanel = drawingApp.getWindowPanel().getLeapPanel();
		
		while(true){
			
			InteractionBox ibox 	  = leap.frame().interactionBox();
			PointableList  pointables = leap.frame().pointables();
		    
			for(int p = 0; p < pointables.count(); p++) {
            
				Pointable pointable = pointables.get(p);
				normalizedPosition  = ibox.normalizePoint(pointable.stabilizedTipPosition());
            
				int x = (int) (normalizedPosition.getX()       * leapPanel.getWidth());
				int y = (int) (600 - normalizedPosition.getY() * leapPanel.getHeight());
				int z = (int) (normalizedPosition.getZ()       * 100);
            
				leapPanel.setPosition( new Finger(x, y, z) );
			}
			
			leapPanel.repaint();
		
			try {
				Thread.currentThread();
				Thread.sleep(50);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
        }
		
	}
	
}
