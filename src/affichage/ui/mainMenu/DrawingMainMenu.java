package affichage.ui.mainMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import affichage.control.HandSpeakController;
import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;
import affichage.ui.LeapMotion.ThreadLeapMotion;


public class DrawingMainMenu extends JDialog
{
	
	private static final long serialVersionUID = 1L;
	
	//private final MainMenuPanel 				mainMenuPanel;
	private final 		Background					background;
	private final 		ButtonLearn              	buttonLearn;
	private final 		ButtonHelp                  buttonHelp;
	private final 		TitlePanel             		titlePanel;
	private final		ButtonQuit                  buttonQuit;
	private final		ButtonGame					buttonGame;
	private			DrawingAppModel				drawingAppModel;
		
	public DrawingMainMenu() throws IOException{
		
		super();
		this.initClassifier();
		this.setResizable(false);
		this.setPreferredSize(new Dimension(1100,600));
		this.setLocation(100, 100);
		
		//window content creation
		//mainMenuPanel = new MainMenuPanel(this);
		background = new Background(this);
		setContentPane(background);
		
		titlePanel = new TitlePanel(this);
		this.add(titlePanel);
		
		// add containers
		this.add(buttonLearn  = new ButtonLearn(this, drawingAppModel));
		this.add(buttonGame   = new ButtonGame(this, drawingAppModel));
		this.add(buttonHelp   = new ButtonHelp(this, drawingAppModel));
		this.add(buttonQuit   = new ButtonQuit(this, drawingAppModel));
		
		//setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Hand Speak");
		
		this.pack();//this sets components sizes,positions
		this.setModal(true);
		this.setVisible(true);
		
		System.out.println("Main menu done.");
	}
	
	public void close(){
		
		this.dispose();
		
	}
	
	public void open(){
		
		this.setVisible(true);
		
	}
	
	private void initClassifier(){
		
		try {
			drawingAppModel = new	DrawingAppModel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HandSpeakController handSpeakController = 	new HandSpeakController(drawingAppModel);
		
		DrawingApp drawingApp = null;
		
		try {
			drawingApp = new DrawingApp(handSpeakController);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		drawingAppModel.setDrawingApp(drawingApp);
	}
	
}