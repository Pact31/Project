package affichage.ui.mainMenu;

import java.awt.Desktop;
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

public class ButtonHelp extends JButton
implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private final DrawingMainMenu drawingMainMenu;
	private final int             width =	150;
	private final int				height = 150;
	
	public ButtonHelp(DrawingMainMenu drawingMainMenu, DrawingAppModel drawingAppModel) throws IOException{
		
		super();
		
		this.setBounds(460, 250, width, height);
		this.setIcon(new ImageIcon("src/affichage/help1.png"));
		this.drawingMainMenu = drawingMainMenu;

		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		//this.drawingMainMenu.close();
		try {
			// ouvrir la page d'apprentissage du LPC
			Desktop.getDesktop().browse(java.net.URI.create("http://www.cis.gouv.fr/spip.php?article1196"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
