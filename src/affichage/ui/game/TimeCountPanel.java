package affichage.ui.game;

import java.awt.Color;

import javax.swing.JPanel;

import affichage.ui.DrawingApp;

public class TimeCountPanel 
extends JPanel
{
	private TimePanel time1;
	private ThreadTimeCount threadTimeCount;
	
	public TimeCountPanel(DrawingApp drawingApp, DrawingGame drawingGame){
		
		this.setLayout(null);
		this.setBackground(Color.black);
		
		time1 = new TimePanel(drawingGame, Color.green);
		//time1.setBounds(0, 0, 20, 20);
		this.add(time1);
		
		threadTimeCount = new ThreadTimeCount(drawingApp, drawingGame, this);
		drawingGame.getModel().setCurrentThreadTimeCount(threadTimeCount);
		
		threadTimeCount.start();
	}
	
	public TimePanel getTimePanel(){
		
		return time1;
	
	}
	
}
