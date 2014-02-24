package ui;

import javax.swing.JMenuItem;

public class MenuItemCreatBank extends JMenuItem{
	
   private final DrawingApp drawingApp ;

   public MenuItemCreatBank(DrawingApp drawingApp)
   {
      super("Open") ; // Text of menu item

      this.drawingApp = drawingApp;
   }

}