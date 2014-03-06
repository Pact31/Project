package affichage.ui;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JPanel;


public class WindowPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private final LeapPanel leapPanel;
	private final ButtonsPanel buttonsPanel;
	private final ResultPanel resultPanel;
	private final GesturePanel gesturePanel;
	
	public WindowPanel(DrawingApp drawingApp){
	
		super();
		
		setLayout(new BorderLayout());
		
		add(leapPanel = new LeapPanel(drawingApp), BorderLayout.CENTER);
		add(resultPanel = new ResultPanel(drawingApp), BorderLayout.SOUTH);
		add(buttonsPanel = new ButtonsPanel(drawingApp), BorderLayout.NORTH);
		add(gesturePanel = new GesturePanel(drawingApp), BorderLayout.EAST);
		
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