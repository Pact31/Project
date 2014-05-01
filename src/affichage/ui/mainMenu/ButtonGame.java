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
import affichage.ui.DrawingApp;
import affichage.ui.LeapMotion.ThreadLeapMotion;
import affichage.ui.game.DrawingGame;

public class ButtonGame extends JButton
implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private final DrawingMainMenu drawingMainMenu;
	private 		DrawingGame		drawingGame;
	private        DrawingAppModel drawingAppModel;
	//private final Image			image;
	private final int             width =	150;
	private final int				height = 150;
	
	public ButtonGame(DrawingMainMenu drawingMainMenu, DrawingAppModel drawingAppModel) throws IOException{
		
		super();
		this.setBounds(570, 90, width, height);
		this.setIcon(new ImageIcon("src/affichage/game1.png"));
		this.drawingMainMenu = drawingMainMenu;
		this.drawingAppModel = drawingAppModel;
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		drawingMainMenu.close();
		/*DrawingAppModel		model				=	new	DrawingAppModel();
		HandSpeakController handSpeakController = 	new HandSpeakController(model);
		DrawingApp 			drawingApp 			= 	new DrawingApp(handSpeakController);
		*/
		DrawingAppModel model = null;
		try {
			System.out.println("Init dawingAppModel");
			model = new	DrawingAppModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//HandSpeakController handSpeakController = 	new HandSpeakController(model);
		//DrawingApp drawingApp = null;
		
		System.out.println("Init dawingApp");
		DrawingApp drawingApp = null;
		drawingApp = new DrawingApp(model);
		
		//ThreadLeapMotion threadLeapMotion 		=	new	ThreadLeapMotion(drawingApp);
		//threadLeapMotion.start();
		
		try {
			DrawingGame drawingGame = new DrawingGame(drawingApp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Game done, Main menu open");
		//threadLeapMotion.stop();
		
		//this.drawingGame.getModel().getCurrentThreadTimeCount().stop();
		this.drawingMainMenu.open();
	
		
	}
	
}
