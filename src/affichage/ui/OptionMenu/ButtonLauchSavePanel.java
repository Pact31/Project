package affichage.ui.OptionMenu;

import javax.swing.JPanel;
import affichage.ui.DrawingApp;

public class ButtonLauchSavePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final ButtonLaunchSave buttonLaunchSave;
	private final DrawingApp drawingApp;
	
	
	public ButtonLauchSavePanel(DrawingApp drawingApp, String name){
		
		super();
		this.drawingApp = drawingApp;
		
		//setPreferredSize(new Dimension(50,50));	
		add(buttonLaunchSave = new ButtonLaunchSave(drawingApp, name));
		
	}
	
}
