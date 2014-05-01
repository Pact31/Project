package affichage.ui.game;


import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JDialog;

import affichage.ui.DrawingApp;
import affichage.ui.game.model.DrawingGameModel;

public class DrawingGame extends JDialog
{
	
	private static final long serialVersionUID = 1L;
	
	private final WindowGame					windowGame;
	private  		DrawingApp					drawingApp;
	private  		GameOverPanel				gameOverPanel;
	private    		DrawingGameModel				drawingGameModel;
	
	public DrawingGame(DrawingApp drawingApp) throws IOException{
		
		
		super();
		
		this.drawingApp	= drawingApp;
		drawingGameModel = new DrawingGameModel();
		
		
		/* intiation du panel Game Over*/
		gameOverPanel = new GameOverPanel(drawingApp, this);
		gameOverPanel.setBounds(0, 0, 500, 500);
		/*-----------------------------*/
		
		this.setPreferredSize(new Dimension(1200,600));
		this.setResizable(false);
		this.setLocation(100, 100);

		//window content creation
		windowGame = new WindowGame(drawingApp, this);
		drawingGameModel.setWindowGame(windowGame);
		this.setContentPane(windowGame);
		
		// add containers
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Hand Speak");
		
		this.pack();//this sets components sizes,positions
		this.setModal(true);
		this.setVisible(true);
		
		this.close();
	}
	
	public void close(){
		
		//this.setVisible(false);
		this.getModel().setGameThreadRunning(false);
		this.getModel().getCurrentThreadTimeCount().stopThread();
		this.dispose();
		
	}
	
	public void setGameOver() throws IOException{
		
		this.setContentPane(gameOverPanel);
		this.setVisible(true);
	
	}
	
	public void pauseGame() throws IOException{
		
		this.getModel().setGameThreadRunning(false);
		this.setGameOver();
		//this.setEnabled(false);
	
	}
	
	public void reprend(){
		
		drawingGameModel.setGameThreadRunning(true);
		this.setContentPane(windowGame);
		this.setVisible(true);
		
	}
	
	public DrawingGameModel getModel(){
		
		return drawingGameModel;
	
	}
	
	public void gameOver(int score){
		
		
		if(score > 5){
			this.drawingGameModel.setGameProcess("win");
		}
		else{
			this.drawingGameModel.setGameProcess("fail");
		}
		
		this.windowGame.setEnableStart(true);
		this.windowGame.setEnableLevel(true);
		
	}
	
	public WindowGame getWindowGame(){
		
		return this.windowGame;
		
	}
}