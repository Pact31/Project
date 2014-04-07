package affichage.ui.game;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import affichage.ui.DrawingApp;
import affichage.ui.mainMenu.TitlePanel;
import affichage.ui.mainMenu.TitlePanel;

public class DrawingGame extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	
	private final WindowGame					windowGame;
	
	private  GameOverPanel				gameOverPanel;
	
	public DrawingGame(DrawingApp drawingApp) throws IOException{
		
		super("Drawing Application");
		
		/* intiation du panel Game Over*/
		gameOverPanel = new GameOverPanel(drawingApp, this);
		gameOverPanel.setBounds(0, 0, 500, 500);
		/*-----------------------------*/
		
		this.setPreferredSize(new Dimension(800,600));
		this.setLocation(100, 100);
		
		//window content creation
		windowGame = new WindowGame(drawingApp, this);
		this.setContentPane(windowGame);
		
		// add containers
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setTitle("Hand Speak");
		
		this.pack();//this sets components sizes,positions
		this.setVisible(true);
		
	}
	
	public void close(){
		
		this.setVisible(false);
	
	}
	
	public void setGameOver() throws IOException{
		
		this.setContentPane(gameOverPanel);
		this.setVisible(true);
	
	}
	
}