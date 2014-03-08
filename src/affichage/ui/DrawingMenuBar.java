package affichage.ui;

import javax.swing.JMenuBar;


public class DrawingMenuBar extends JMenuBar{

	private final OptionMenu fileMenu ;
	
	public DrawingMenuBar(DrawingApp drawingApp)
	{
		super() ;
		
		// Create and add menus
		add(fileMenu = new OptionMenu(drawingApp)) ;
	}
}