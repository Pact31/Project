package affichage.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import affichage.model.DrawingAppModel;
import affichage.ui.OptionMenu.DrawingMenuNew;

public class MenuItemNewBank extends JMenuItem
implements ActionListener
{
	
   private final DrawingApp drawingApp ;
   private JFileChooser fc;
   
   public MenuItemNewBank(DrawingApp drawingApp){
	   
      super("New") ; // Text of menu item
      this.addActionListener(this);
      this.drawingApp = drawingApp;
   
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	   
	   fc = new JFileChooser();
	   DrawingAppModel drawingAppModel = drawingApp.getModel();
	   
	   int returnVal = fc.showOpenDialog(MenuItemNewBank.this);
	   
	   if (returnVal == JFileChooser.APPROVE_OPTION) {
           File file = fc.getSelectedFile();
           try {
        	   drawingAppModel.setCurrentBank(file);
           } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
           }
           //This is where a real application would open the file.
           drawingAppModel.setCurrentMessage("Opening: " + file.getName() + "." + "\n");
       } 
	   else {
           drawingAppModel.setCurrentMessage("Open command cancelled by user." + "\n");
       }
	   
	   drawingApp.update(drawingAppModel, null);
   }
}