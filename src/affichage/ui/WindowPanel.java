package affichage.ui;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;

public class WindowPanel 
extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	private final LeapPanel leapPanel;
	private final ButtonStartPanel buttonsPanel;
	private final ResultPanel resultPanel;
	private final GesturePanel gesturePanel;
	//private final ButtonLeftPanel buttonLeftPanel;
	public WindowPanel(DrawingApp drawingApp) throws IOException{
	
		super();
		
		setLayout(new BorderLayout());
		
		add(leapPanel = new LeapPanel(drawingApp), BorderLayout.CENTER);
		add(resultPanel = new ResultPanel(drawingApp), BorderLayout.SOUTH);
		add(gesturePanel = new GesturePanel(drawingApp), BorderLayout.EAST);
		add(buttonsPanel = new ButtonStartPanel(drawingApp), BorderLayout.NORTH);
		
		/*add(leapPanel = new LeapPanel(drawingApp));
		add(resultPanel = new ResultPanel(drawingApp));
		add(gesturePanel = new GesturePanel(drawingApp));
		add(buttonsPanel = new ButtonStartPanel(drawingApp));
		*/
		//add(buttonLeftPanel = new ButtonLeftPanel(drawingApp), BorderLayout.PAGE_START);
	}
	
	public LeapPanel getLeapPanel(){
		
		return leapPanel;
	
	}
	
	public void notifyForUpdate(){
		
		buttonsPanel.getButtonStart().notifyForUpdate();
		resultPanel.notifyForUpdate();
		gesturePanel.notifyForUpdate();
		
	}
}