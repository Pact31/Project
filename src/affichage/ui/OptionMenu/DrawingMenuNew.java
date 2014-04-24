package affichage.ui.OptionMenu;

import java.awt.Dimension;

import javax.swing.JDialog;
import affichage.ui.DrawingApp;

public class DrawingMenuNew 
extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final MenuApprentiWindow menuApprentiWindow;
	
	public DrawingMenuNew(DrawingApp drawingApp){
		
		super();
		
		this.setPreferredSize(new Dimension(1000,300));
		this.setResizable(false);
		this.setLocation(100, 200);
		
		//window content creation
		//windowPanel = new WindowPanel(this);
		menuApprentiWindow = new MenuApprentiWindow(drawingApp);
		setContentPane(menuApprentiWindow);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Choose a cible");
		
		this.setModal(true);
		this.pack();//this sets components sizes,positions
		this.setVisible(true);
		
	}

}
