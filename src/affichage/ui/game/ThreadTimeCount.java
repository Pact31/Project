package affichage.ui.game;

public class ThreadTimeCount 
extends Thread
{
	
	private int i =0;
	private TimeCountPanel timeCountPanel;
	private TimePanel      timePanel;
	
	public ThreadTimeCount(DrawingGame drawingGame, TimeCountPanel timeCountPanel){
		this.timeCountPanel = timeCountPanel;
		this.timePanel	= timeCountPanel.getTimePanel();
	}
	
	@Override
	public void run(){
		
		
		while(true){
			
			this.timePanel.setLocation(i);
			i++;
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}
