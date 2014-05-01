package affichage.ui;

import javax.swing.JMenu;

public class WindowOptionMenu 
extends JMenu
{
	
	private final MenuItemQuit quitMenuItem ;
	private final MenuItemOpenBank menuItemOpenBank;
	private final MenuItemSetting menuItemSetting;
	
	public WindowOptionMenu(DrawingApp drawingApp){
	
		super("Option") ; // Text of the menu

		// Create and add menu items
		add(menuItemOpenBank = new MenuItemOpenBank(drawingApp));
		add(menuItemSetting = new MenuItemSetting(drawingApp));
	    add(quitMenuItem = new MenuItemQuit(drawingApp)) ;
	
	}

}
