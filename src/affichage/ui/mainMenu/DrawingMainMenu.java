package affichage.ui.mainMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class DrawingMainMenu extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	
	private final MainMenuPanel 				mainMenuPanel;
	private final Background					background;
	private final ButtonLearn              	buttonLearn;
	private final ButtonHelp                  	buttonHelp;
	private final TitlePanel             		titlePanel;
	private final ButtonQuit                  	buttonQuit;
	private final ButtonGame					buttonGame;
	
	public DrawingMainMenu() throws IOException{
		
		super("Drawing Application");
		
		
		this.setPreferredSize(new Dimension(1100,600));
		this.setLocation(100, 100);
		
		//window content creation
		mainMenuPanel = new MainMenuPanel(this);
		
		background = new Background(this);
		setContentPane(background);
		
		titlePanel = new TitlePanel(this);
		this.add(titlePanel);
		
		// add containers
		this.add(buttonLearn = new ButtonLearn(this));
		this.add(buttonHelp = new ButtonHelp(this));
		this.add(buttonQuit = new ButtonQuit(this));
		this.add(buttonGame = new ButtonGame(this));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hand Speak");
		
		this.pack();//this sets components sizes,positions
		this.setVisible(true);
		
	}
	
	public void close(){
		
		this.setVisible(false);
	
	}
	
}