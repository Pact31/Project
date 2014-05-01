package affichage.ui.LeapMotion;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.HandList;
import com.leapmotion.leap.Pointable;
import com.leapmotion.leap.PointableList;
import com.leapmotion.leap.Vector;
import com.leapmotion.leap.InteractionBox;

import affichage.ui.DrawingApp;
import affichage.ui.LeapPanel;
import affichage.ui.game.DrawingGame;

public class ThreadLeapMotion 	
extends Thread
{
	
	private  DrawingApp drawingApp;
	private  DrawingGame drawingGame;
	private  LeapPanel leapPanel;
	
	public ThreadLeapMotion(DrawingApp drawingApp){
	
		this.drawingApp = drawingApp;
		leapPanel = drawingApp.getWindowPanel().getLeapPanel();
	}
	
	public ThreadLeapMotion(DrawingGame drawingGame){
		
		this.drawingGame = drawingGame;
		leapPanel = drawingGame.getWindowGame().getLeapPanel();
	
	}
	
	private boolean threadRunning = true;
	public void threadStop(){
		
		threadRunning = false;
		
		
	}
	private Vector normalizedPosition;
	private Controller leap = new Controller();
	
	@Override
	public void run(){
	/**
	 * http://2froblog.wordpress.com/2013/09/01/developper-sur-la-leap-motion-en-java/
	 * @author francois
	 */	
		while(threadRunning){
			
			//System.out.println("leap run");
			InteractionBox ibox 	  = leap.frame().interactionBox();
			PointableList  pointables = leap.frame().pointables();
			HandList hands = leap.frame().hands();

			
			for(int p = 0; p < pointables.count(); p++) {
            
				Pointable pointable = pointables.get(p);
				normalizedPosition  = ibox.normalizePoint(pointable.stabilizedTipPosition());
            
				int x = (int) (normalizedPosition.getX()       * leapPanel.getWidth());
				int y = (int) (600 - normalizedPosition.getY() * leapPanel.getHeight());
				int z = (int) (normalizedPosition.getZ()       * 100);
            	
				/*int x =100;
				int y =100;
				int z =100;*/
				leapPanel.setPosition( new OurFinger(x, y, z) );
				//j= p;
			}
			
			//drawingApp.getModel().setCurrentMessage(String.format("Number of fingers %d", j));
			//drawingApp.update(drawingApp.getModel(), null);
			for(int p = 0; p < hands.count(); p++) {
            
				Hand hand = hands.get(p);
				normalizedPosition  = ibox.normalizePoint(hand.stabilizedPalmPosition());
            
				int x = (int) (normalizedPosition.getX()       * leapPanel.getWidth());
				int y = (int) (600 - normalizedPosition.getY() * leapPanel.getHeight());
				int z = (int) (normalizedPosition.getZ()       * 100);
            
				leapPanel.setPosition( new OurFinger(x, y, z) );
				//j= p;
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
