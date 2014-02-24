package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import model.DrawingAppModel;


public class MenuItemOpenBank extends JMenuItem
implements ActionListener
{
	
   private final DrawingApp drawingApp ;
   private JFileChooser fc;
   
   public MenuItemOpenBank(DrawingApp drawingApp){
	   
      super("Open") ; // Text of menu item
      this.addActionListener(this);
      this.drawingApp = drawingApp;
   
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	   fc = new JFileChooser();
	   DrawingAppModel drawingAppModel = drawingApp.getModel();
	   
	   int returnVal = fc.showOpenDialog(MenuItemOpenBank.this);
	   
	   if (returnVal == JFileChooser.APPROVE_OPTION) {
           File file = fc.getSelectedFile();
           drawingAppModel.setCurrentBank(file);
           //This is where a real application would open the file.
           drawingAppModel.setCurrentMessage("Opening: " + file.getName() + "." + "\n");
       } 
	   else {
           //log.append("Open command cancelled by user." + newline);
       }
	   
	   drawingApp.update(drawingAppModel, null);
   }
}