package syntheseparole;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InterfaceGraph extends JFrame implements ActionListener{
	
	
	JButton playb = new JButton("Play");
	JButton pauseb = new JButton("Pause");
	JButton stopb = new JButton("Stop");
	JButton exitb = new JButton("Exit");
	
	
	
	public void actionPerformed(ActionEvent arg0) {

		
		
		if (arg0.getSource() == playb) { System.out.println("Vous venez d'appuyer sur le bouton Play"); }
		if (arg0.getSource() == pauseb) { System.out.println("Vous venez d'appuyer sur le bouton Pause"); }
		if (arg0.getSource() == stopb) { System.out.println("Vous venez d'appuyer sur le bouton Stop"); }
		if (arg0.getSource() == exitb) { System.out.println("Vous venez d'appuyer sur le bouton Exit"); }
		
	}
	
	public InterfaceGraph () {
		
		/* Initialisation des variables de la fenetre graphique */
		
		//JPanel jpan = new JPanel();
		JLabel jlab = new JLabel("texte par défaut");
		//JButton playb = new JButton("Play");
		//JButton pauseb = new JButton("Pause");
		//JButton stopb = new JButton("Stop");
		//JButton exitb = new JButton("Exit");
		
		/* Declaration du fait que la fentre InterfaceGraph doit écouter les 4 boutons */
		
		playb.addActionListener(this);
		pauseb.addActionListener(this);
		stopb.addActionListener(this);
		exitb.addActionListener(this);
		
		/* Paramétrage de la fenetre elle-meme */
		
		this.setTitle("Lecteur audio");
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    /* Positionnement des boutons */
		
		GridLayout gd = new GridLayout(2,2);
		this.setLayout(gd);
		this.getContentPane().add(playb);
		this.getContentPane().add(pauseb);
		this.getContentPane().add(stopb);
		this.getContentPane().add(exitb);
		
	
		
		
	}
}
	

