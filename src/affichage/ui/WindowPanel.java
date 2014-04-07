package affichage.ui;

import java.awt.BorderLayout;
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
		
		/*add(leapPanel = new LeapPanel(drawingApp), BorderLayout.CENTER);
		add(resultPanel = new ResultPanel(drawingApp), BorderLayout.SOUTH);
		add(gesturePanel = new GesturePanel(drawingApp), BorderLayout.EAST);
		add(buttonsPanel = new ButtonStartPanel(drawingApp), BorderLayout.NORTH);
		*/
		leapPanel = new LeapPanel(drawingApp);
		leapPanel.setBounds(0, 50, 800, 595);
		add(leapPanel);
		
		resultPanel = new ResultPanel(drawingApp);
		resultPanel.setBounds(0, 600, 1366, 160 );
		add(resultPanel);
		
		gesturePanel = new GesturePanel(drawingApp);
		gesturePanel.setBounds(805, 50, 566, 595);
		add(gesturePanel);
		
		//buttonsPanel = new ButtonStartPanel(drawingApp);
		//buttonsPanel.setBounds(500, 20, 200, 50);
		//add(buttonsPanel);
		
		buttonExecutionPanel = new ButtonExecutionPanel(drawingApp);
		buttonExecutionPanel.setBounds(520, 0, 200, 50);
		add(buttonExecutionPanel);
		
		buttonStopPanel = new ButtonStopPanel(drawingApp);
		buttonStopPanel.setBounds(720, 0, 200, 50);
		add(buttonStopPanel);
		
		buttonLeftPanel = new ButtonLeftPanel(drawingApp);
		buttonLeftPanel.setBounds(0, 0, 100, 50);
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