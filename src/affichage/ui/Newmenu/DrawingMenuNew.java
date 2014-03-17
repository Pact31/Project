package affichage.ui.Newmenu;

import java.awt.Dimension;
import javax.swing.JFrame;
import affichage.ui.DrawingApp;

public class DrawingMenuNew 
extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final MenuApprentiWindow menuApprentiWindow;
	
	public DrawingMenuNew(DrawingApp drawingApp){
		
		super("Drawing Application");
		
		this.setPreferredSize(new Dimension(800,100));
		this.setLocation(0, 200);
		
		//window content creation
		//windowPanel = new WindowPanel(this);
		menuApprentiWindow = new MenuApprentiWindow(drawingApp);
		setContentPane(menuApprentiWindow);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Choose a cible");
		
		this.pack();//this sets components sizes,positions
		this.setVisible(true);
	
	}

}
