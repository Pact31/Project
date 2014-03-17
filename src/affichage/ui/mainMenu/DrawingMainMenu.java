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
	
	public DrawingMainMenu() throws IOException{
		
		super("Drawing Application");
		
		
		this.setPreferredSize(new Dimension(1100,600));
		this.setLocation(100, 100);
		
		//setLayout(new BorderLayout());
		//JLabel background = new JLabel(new ImageIcon("src/affichage/background.jpg"));
		//add(background);
		//window content creation
		mainMenuPanel = new MainMenuPanel(this);
		
		background = new Background(this);
		setContentPane(background);
		titlePanel = new TitlePanel(this);
		this.add(titlePanel);
	
		buttonLearn = new ButtonLearn(this);
		this.add(buttonLearn);
		buttonHelp 	= new ButtonHelp(this);
		this.add(buttonHelp);
		/*JButton b = new JButton("Click");
		JTextField tf=new JTextField();
 
 
		b.setBounds(318, 143, 98, 27);
		tf.setBounds(235, 104, 180, 27);
 
		this.add(b);
		this.add(tf);
		*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hand Speak");
		
		this.pack();//this sets components sizes,positions
		this.setVisible(true);
		
	}
	
	public void close(){
		this.setVisible(false);
	}
	
}