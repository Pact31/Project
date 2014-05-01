package affichage.ui.OptionMenu;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import affichage.ui.DrawingApp;

public class MenuApprentiWindow  extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final TextPanel textPanel;
	private final TextPanel optionSavePanel;
	private final TextPanel ciblePanel;
	private final TextPanel classifierPanel;
	private final TextPanel enregistrerPanel;
	private final TextPanel consonnePanel;
	private final TextPanel voyellePanel;
	//private final TextPanel warningPanel;

	
	private final ButtonClassifierOptionPanel buttonClassifierOptionPanel;

	private final ButtonCiblePanel ciblePanel1;
	private final ButtonCiblePanel ciblePanel2;
	private final ButtonCiblePanel ciblePanel3;
	private final ButtonCiblePanel ciblePanel4;
	private final ButtonCiblePanel ciblePanel5;
	private final ButtonCiblePanel ciblePanel6;
	private final ButtonCiblePanel ciblePanel7;
	private final ButtonCiblePanel ciblePanel8;
	private final ButtonOptionPanel buttonOptionPanel;
	private final ButtonLaunchSavePanel buttonLaunchSavePanel;
	
	private final String voyelleList[] = {"a o oe", "ain eu", "i on an", "ais ou o", "u un é"};
	private final String consonneList[] = {"PDJ", "KVZ", "SR", "BNUI", "MTF", "ICHGNW", "G", "YNG" };
	private final String users[]		=	{"pere", "mere", "moi"};
	
	private JComboBox voyelleComboBox;
	private JComboBox consonneComboBox;
	private JComboBox usersComboBox;
	
	public MenuApprentiWindow(DrawingApp drawingApp){
		
		super();
		this.drawingApp = drawingApp;
		
		this.initGaps();
		//setLayout(new FlowLayout());
		this.setLayout(null);
		
		textPanel = new TextPanel(drawingApp, "Configuration");
		textPanel.setBounds(450, 10, 100, 40);
		add(textPanel);
		
		// button classifier option
		classifierPanel = new TextPanel(drawingApp, "Classe :");
		classifierPanel.setBounds(20, 140, 100, 40);
		add(classifierPanel);
		
		buttonClassifierOptionPanel = new ButtonClassifierOptionPanel(drawingApp);
		buttonClassifierOptionPanel.setBounds(56, 140, 200, 40);
		add(buttonClassifierOptionPanel);
		/*-----------------------------------------------------------*/
		
		// button save gesture / test son
		optionSavePanel = new TextPanel(drawingApp, "Sons test :");
		optionSavePanel.setBounds(20, 60, 100, 40);
		//add(optionSavePanel);
		
		buttonOptionPanel = new ButtonOptionPanel(drawingApp);
		buttonOptionPanel.setBounds(100, 60, 100, 40);
		//add(buttonOptionPanel);
		/*----------------------------------------------------------*/
		
		// the cible panel
		ciblePanel = new TextPanel(drawingApp, "Sons test :");
		ciblePanel.setBounds(20, 100, 100, 40);
		add(ciblePanel);
		
		ciblePanel1 	= 	new ButtonCiblePanel(drawingApp, "PDJ ");
		ciblePanel1.setBounds(100, 100, 100, 40);
		add(ciblePanel1);
		
		ciblePanel2 	= 	new ButtonCiblePanel(drawingApp, "KVZ ");
		ciblePanel2.setBounds( 200, 100, 100, 40);
		add(ciblePanel2);
		
		ciblePanel3 	= 	new ButtonCiblePanel(drawingApp, "SR  ");
		ciblePanel3.setBounds( 300, 100, 100, 40);
		add(ciblePanel3);
		
		ciblePanel4 	= 	new ButtonCiblePanel(drawingApp, "BNUI");
		ciblePanel4.setBounds( 400, 100, 100, 40);
		add(ciblePanel4);
		
		ciblePanel5 	= 	new ButtonCiblePanel(drawingApp, "MTF ");
		ciblePanel5.setBounds( 500, 100, 100, 40);
		add(ciblePanel5);
		
		ciblePanel6 	= 	new ButtonCiblePanel(drawingApp, "ICHG");
		ciblePanel6.setBounds( 600, 100, 100, 40);
		add(ciblePanel6);
		
		ciblePanel7 	= 	new ButtonCiblePanel(drawingApp, " G  ");
		ciblePanel7.setBounds( 700, 100, 100, 40);
		add(ciblePanel7);
		
		ciblePanel8 	= 	new ButtonCiblePanel(drawingApp, "YNG ");
		ciblePanel8.setBounds( 800, 100, 100, 40);
		add(ciblePanel8);
		/*------------------------------------------------------------*/
		enregistrerPanel = new TextPanel(drawingApp, "Enregistrer les gestes: ");
		enregistrerPanel.setBounds(20, 200, 200, 40);
		add(enregistrerPanel);
		
		voyellePanel = new TextPanel(drawingApp, "Voyelle");
		voyellePanel.setBounds(210, 185, 100, 20);
		add(voyellePanel);
		
		voyelleComboBox.setBounds(200, 210, 100, 30);
		add(voyelleComboBox);
		
		consonnePanel = new TextPanel(drawingApp, "Consonne");
		consonnePanel.setBounds(330, 185, 100, 20);
		add(consonnePanel);
		
		consonneComboBox.setBounds(320, 210, 100, 30);
		add(consonneComboBox);
		
		usersComboBox.setBounds(580, 210, 100, 30);
		add(usersComboBox);
		
		buttonLaunchSavePanel = new ButtonLaunchSavePanel(drawingApp, "Enregistrer");
		buttonLaunchSavePanel.setBounds(450, 210, 120, 40);
		add(buttonLaunchSavePanel);
		
		//warningPanel = new TextPanel(drawingApp, "Il ne faut pas modifier  ")
	}
	
	private void initGaps(){
		
		voyelleComboBox = new JComboBox(voyelleList);
		consonneComboBox = new JComboBox(consonneList);
		usersComboBox = new JComboBox(users);
		this.drawingApp.getModel().setComboBox(voyelleComboBox, consonneComboBox, usersComboBox);
		
	}
	
}
