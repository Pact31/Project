package ui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;


public class ResultPanel extends JLabel{
	
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;	
	
	public ResultPanel(DrawingApp drawingApp){
		
		super();
		
		this.drawingApp = drawingApp;
		
		setPreferredSize(new Dimension(64,64));	
		setBackground(Color.GREEN);
		
	}
	
	public void notifyForUpdate(){
		
		String msg = drawingApp.getModel().getCurrentMessage();
		setText(msg);
		
	}
}
