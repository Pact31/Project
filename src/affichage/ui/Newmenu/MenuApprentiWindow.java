package affichage.ui.Newmenu;

import java.awt.FlowLayout;
import javax.swing.JPanel;

import affichage.ui.DrawingApp;

public class MenuApprentiWindow  extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final ButtonCiblePanel ciblePanel1;
	private final ButtonCiblePanel ciblePanel2;
	private final ButtonCiblePanel ciblePanel3;
	private final ButtonCiblePanel ciblePanel4;
	private final ButtonCiblePanel ciblePanel5;
	private final ButtonCiblePanel ciblePanel6;
	private final ButtonCiblePanel ciblePanel7;
	private final ButtonCiblePanel ciblePanel8;
	private final ButtonOptionPanel buttonOptionPanel;

	public MenuApprentiWindow(DrawingApp drawingApp){
		
		super();
		
		setLayout(new FlowLayout());
		
		add(ciblePanel1 	= 	new ButtonCiblePanel(drawingApp, "PDJ"));
		add(ciblePanel2 	=	new ButtonCiblePanel(drawingApp, "KVZ"));
		add(ciblePanel3 	= 	new ButtonCiblePanel(drawingApp, "SR"));
		add(ciblePanel4 	= 	new ButtonCiblePanel(drawingApp, "BNUI"));
		add(ciblePanel5 	= 	new ButtonCiblePanel(drawingApp, "MTF"));
		add(ciblePanel6 	= 	new ButtonCiblePanel(drawingApp, "ICHGNW"));
		add(ciblePanel7 	= 	new ButtonCiblePanel(drawingApp, "G"));
		add(ciblePanel8 	= 	new ButtonCiblePanel(drawingApp, "YNG"));
		add(buttonOptionPanel = new ButtonOptionPanel(drawingApp));
	}
	
}
