package affichage.ui.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import affichage.ui.DrawingApp;
import affichage.ui.game.model.DrawingGameModel;

public class ButtonGameLevel extends JButton
implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private final DrawingApp drawingApp;
	private final DrawingGame drawingGame;
	private final ButtonGameLevelPanel buttonGameLevelPanel;
	private final Image			image;
	private final int             width =	50;
	private final int				height = 50;
	private final String			level;
	
	public ButtonGameLevel(DrawingApp drawingApp, DrawingGame drawingGame, String icon, ButtonGameLevelPanel p) throws IOException{
		
		super();
		this.drawingApp = drawingApp;
		this.drawingGame = drawingGame;
		this.buttonGameLevelPanel = p;
		this.level = icon;
		
		this.setSize(width, height);
		image = ImageIO.read(new File("src/affichage/ui/game/images/levelIcon/" + icon + ".png"));
		
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		DrawingGameModel model = drawingGame.getModel();
		
		model.setGameProcess("welcome"+level);
		model.setGameLevel(level);
		
		this.buttonGameLevelPanel.setEnableAction(false);
		model.getWindowGame().setEnableStart(true);
		//GameTimer gameTimer = new GameTimer(drawingApp, drawingGame);
		//gameTimer.start();
		

	}

	@Override
	public void paintComponent(Graphics g){

		g.drawImage(image, 0, 0, width, height, null);
		
	}

}
