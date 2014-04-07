package affichage.ui;

import javax.swing.JMenuBar;


public class DrawingMenuBar extends JMenuBar{

	private final WindowOptionMenu fileMenu ;
	
	public DrawingMenuBar(DrawingApp drawingApp)
	{
		super() ;
		
		// Create and add menus
		add(fileMenu = new WindowOptionMenu(drawingApp)) ;
	}
}