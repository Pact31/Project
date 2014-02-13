package ui;

import javax.swing.*;

import java.awt.*;

public class ResultPanel extends JLabel{
	
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
