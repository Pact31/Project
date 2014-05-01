package affichage.ui.mainMenu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import affichage.model.DrawingAppModel;

public class ButtonQuit extends JButton
implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private final DrawingMainMenu 		drawingMainMenu;
	private final DrawingAppModel     drawingAppModel;
	private final int             	width 		=		200;
	private final int					height 		= 		150;
	
	public ButtonQuit(DrawingMainMenu drawingMainMenu, DrawingAppModel drawingAppModel) throws IOException{
		
		super();

		this.setBounds(430, 410, width, height);
		this.setIcon(new ImageIcon("src/affichage/quit1.png"));
		this.drawingMainMenu = drawingMainMenu;
		this.drawingAppModel = drawingAppModel;
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		this.drawingMainMenu.close();
		this.drawingAppModel.getDrawingApp().close();
		
	}
}
