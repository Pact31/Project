package affichage.ui;

import java.awt.Dimension;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JDialog;
import affichage.model.DrawingAppModel;
import affichage.control.HandSpeakController;

public class DrawingApp extends JDialog
implements Observer
{
	
	private static final long serialVersionUID = 1L;
	
	private final 		WindowPanel 				windowPanel;
	private final 		HandSpeakController 		handSpeakController;
	private final 		DrawingMenuBar 				drawingMenuBar ;
	private 			DrawingAppModel 			drawingAppModel;
	
	public DrawingApp(HandSpeakController controller) throws IOException{
		
		//super("Drawing Application");
		
		handSpeakController		=		controller;
		drawingAppModel			=		handSpeakController.getDrawingAppModel();
		
		this.setPreferredSize(new Dimension(820,1000));
		this.setResizable(false);
		this.setLocation(0, 0);
		
		setJMenuBar(drawingMenuBar = new DrawingMenuBar(this));
		
		//window content creation
		windowPanel = new WindowPanel(this);
		setContentPane(windowPanel);
			
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Hand Speak");
		
		this.pack();//this sets components sizes,positions
		this.setModal(true);
	
	}
	
	public DrawingApp(DrawingAppModel model){
	
		this.windowPanel	 = null;
		this.drawingMenuBar		= null;
		this.handSpeakController =	 	new HandSpeakController(model);
		this.drawingAppModel = 	handSpeakController.getDrawingAppModel();
	
	}
	
	
	public final DrawingAppModel getModel(){
		
		return this.drawingAppModel;
		
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
	
	public void close(){
		
		this.dispose();
		
	}
	
	public void open(){
	
		this.setVisible(true);
	
	}
	
}