package ui;

import javax.swing.JMenuItem;


public class MenuItemQuit extends JMenuItem
{
	
   private final DrawingApp drawingApp ;

   public MenuItemQuit(DrawingApp drawingApp)
   {
      super("Quit") ; // Text of menu item
      this.drawingApp = drawingApp;
      this.addActionListener(new ActionListenerQuitApp());
   }

}