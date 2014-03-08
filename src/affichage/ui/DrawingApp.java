package affichage.ui;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import affichage.model.DrawingAppModel;
import affichage.control.HandSpeakController;

public class DrawingApp extends JFrame
	implements Observer
{
	
	private static final long serialVersionUID = 1L;
	
	private final WindowPanel 				windowPanel;
	private final HandSpeakController 		handSpeakController;
	private final DrawingMenuBar 			drawingMenuBar ;
	private 		DrawingAppModel 		drawingAppModel;
	
	public DrawingApp(HandSpeakController controller){
		
		super("Drawing Application");
		
		handSpeakController		=		controller;
		drawingAppModel			=		handSpeakController.getDrawingAppModel();
		
		this.setPreferredSize(new Dimension(1366,768));
		this.setLocation(0, 200);
		
		setJMenuBar(drawingMenuBar = new DrawingMenuBar(this));
		//window content creation
		windowPanel = new WindowPanel(this);
		setContentPane(windowPanel);
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hand Speak");
		
		this.pack();//this sets components sizes,positions
		this.setVisible(true);
	
	}
	
	
	public final DrawingAppModel getModel(){
		
		return drawingAppModel;
		
	}
	
	
	public WindowPanel getWindowPanel(){
		
		return windowPanel;
	
	}
	
	public HandSpeakController getHandSpeakController(){
		
		return handSpeakController;
		
	}
	
	@Override
	public void update(Observable obervable, Object parameter) {
	
		notifyForUpdate();
	
	}
	
	public void notifyForUpdate(){
	
		windowPanel.notifyForUpdate();
	
	}
}