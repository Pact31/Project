package affichage.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;

public class WindowPanel 
extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	private final LeapPanel leapPanel;
	//private final ButtonStartPanel buttonsPanel;
	private final ResultPanel resultPanel;
	private final GesturePanel gesturePanel;
	private final ButtonLeftPanel buttonLeftPanel;
	private final ButtonExecutionPanel buttonExecutionPanel;
	private final ButtonStopPanel buttonStopPanel;
	
	
	public WindowPanel(DrawingApp drawingApp) throws IOException{
	
		super();
		
		//Dimension(1366,768)
		//setLayout(new BorderLayout());
		this.setLayout(null);
		
		leapPanel = new LeapPanel(drawingApp);
		leapPanel.setBounds(0, 100, 400, 600);
		add(leapPanel);
		
		resultPanel = new ResultPanel(drawingApp);
		resultPanel.setBounds(500, 0, 400, 60 );
		add(resultPanel);
		
		gesturePanel = new GesturePanel(drawingApp);
		gesturePanel.setBounds(400, 100, 400, 600);
		add(gesturePanel);
				
		buttonExecutionPanel = new ButtonExecutionPanel(drawingApp);
		buttonExecutionPanel.setBounds(150, 0, 150, 150);
		add(buttonExecutionPanel);
		
		buttonStopPanel = new ButtonStopPanel(drawingApp);
		buttonStopPanel.setBounds(300, 0, 150, 150);
		//add(buttonStopPanel);
		
		buttonLeftPanel = new ButtonLeftPanel(drawingApp);
		buttonLeftPanel.setBounds(0, 0, 100, 100);
		add(buttonLeftPanel);
	}
	
	public LeapPanel getLeapPanel(){
		
		return leapPanel;
	
	}
	
	public void notifyForUpdate(){
		
		//buttonsPanel.getButtonStart().notifyForUpdate();
		resultPanel.notifyForUpdate();
		gesturePanel.notifyForUpdate();
		
	}
}