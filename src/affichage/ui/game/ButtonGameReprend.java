package affichage.ui.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import affichage.ui.DrawingApp;

public class ButtonGameReprend extends JButton
implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private final DrawingGame		drawingGame;
	private final int             width =	100;
	private final int				height = 100;
	
	public ButtonGameReprend(DrawingApp drawingApp, DrawingGame drawingGame) throws IOException{
		
		super();
		this.drawingGame = drawingGame;
		
		this.setBounds(510, 300, width, height);
		this.setIcon(new ImageIcon("src/affichage/start_icon.png"));
		//image = ImageIO.read(new File("src/affichage/start_icon.png"));
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		drawingGame.reprend();
		
	}


}
