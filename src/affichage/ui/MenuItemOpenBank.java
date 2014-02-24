package ui;

import javax.swing.JMenuItem;


public class MenuItemOpenBank extends JMenuItem
{
	
   private final DrawingApp drawingApp ;

   public MenuItemOpenBank(DrawingApp drawingApp)
   {
      super("Open") ; // Text of menu item
      
      this.drawingApp = drawingApp;
   }

}