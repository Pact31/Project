package affichage.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import affichage.model.DrawingAppModel;
import affichage.ui.menuNew.DrawingMenuNew;

public class MenuItemNewBank extends JMenuItem
implements ActionListener
{
	
   private final DrawingApp drawingApp ;
   
   public MenuItemNewBank(DrawingApp drawingApp){
	   
      super("SonTest") ; // Text of menu item
      this.addActionListener(this);
      this.drawingApp = drawingApp;
   
   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
	
	  //DrawingAppModel drawingAppModel = drawingApp.getModel();
	  //drawingAppModel.setCurrentMessage("phase d'apprentissage");
	  //drawingApp.update(drawingAppModel, null);
	  DrawingMenuNew drawingMenuNew = new DrawingMenuNew(drawingApp);
		
   }

}