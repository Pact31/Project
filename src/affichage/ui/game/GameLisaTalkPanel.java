package affichage.ui.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import affichage.model.DrawingAppModel;
import affichage.ui.DrawingApp;
import affichage.ui.game.model.DrawingGameModel;

public class GameLisaTalkPanel 
extends JLabel
implements MouseListener
{

	private DrawingGame drawingGame;
	private DrawingGameModel drawingGameModel;
	
	public GameLisaTalkPanel(DrawingGame drawingGame, String msg){
		
		super("hello");
		
		this.drawingGame = drawingGame;
		this.drawingGameModel = drawingGame.getModel();
		addMouseListener(this);
	
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		int h = this.getHeight();
		int w = this.getWidth();

		g.setColor(Color.green);
		g.drawRect(0, 0, w-1, h-1);
		
		g.setColor(Color.black);
		g.setFont(new Font("Serif", Font.BOLD, 15));
				
		g.drawString("Lisa : " + drawingGameModel.getLisaTalkText(drawingGameModel.getGameProcess()), 5, 22);
		
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		// TODO Auto-generated method stub
		if(drawingGameModel.getGameProcess().contains("welcome")){
			drawingGameModel.setGameProcess("start");
			drawingGameModel.setGameStart(true);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
