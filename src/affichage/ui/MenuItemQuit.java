package affichage.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JMenuItem;

import affichage.ui.mainMenu.DrawingMainMenu;


public class MenuItemQuit extends JMenuItem
implements ActionListener
{
	
   private final DrawingApp drawingApp ;

   public MenuItemQuit(DrawingApp drawingApp)
   {
	   super("Quit") ; // Text of menu item
       this.drawingApp = drawingApp;
       this.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	   
	   drawingApp.close();
	   
   }

}