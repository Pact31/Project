package affichage.ui;

import javax.swing.JMenu;

public class OptionMenu 
extends JMenu
{
	
	private final MenuItemQuit quitMenuItem ;
	private final MenuItemOpenBank menuItemOpenBank;
	private final MenuItemCreatBank menuItemCreatBank;
	
	public OptionMenu(DrawingApp drawingApp){
		super("Option") ; // Text of the menu
	    // Create and add menu items
		add(menuItemCreatBank = new MenuItemCreatBank(drawingApp));
		add(menuItemOpenBank = new MenuItemOpenBank(drawingApp));
	    add(quitMenuItem = new MenuItemQuit(drawingApp)) ;
	}

}
