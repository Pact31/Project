package affichage.ui.OptionMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import leapmotion.LeapDataBase;
import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;

public class ButtonLaunchSave extends JButton
implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final DrawingAppModel drawingAppModel;
	private final String name;
	
	public ButtonLaunchSave(DrawingApp drawingApp, String name){
		
		super(name);

		this.name = name;
		this.drawingApp = drawingApp;
		this.drawingAppModel = drawingApp.getModel();
		
		addActionListener(this);
	
	}
	
	private File file;
	public void actionPerformed(ActionEvent arg0) {
		
		String u = (String)this.drawingAppModel.getUsersComboBox().getSelectedItem();
		String v = (String)this.drawingAppModel.getVoyelleComboBox().getSelectedItem();
		String c = (String)this.drawingAppModel.getConsonneComboBox().getSelectedItem();
		
		this.launchSaveOperation(v, c);
		
	}
	
	private void launchSaveOperation(String v, String c){
		
		System.out.println("Enregistrer la geste :" + v + " et " + c);
		drawingApp.getHandSpeakController().launchEnregister(v, c);
	}
	
	
}
