package leapmotion;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;

import LeapTS.LeapData;
import classification.Cible;


/*************************************************************************************************
 *                                                                                               *
 * Cette classe permet de creer une base de donnees                                              *
 * d'information relatives a la LeapMotion                                                       *
 *                                                                                               *
 * Elle contient une ArrayList de LeapData                                                       *
 * On peut  : - creer cette base de donnee via interaction avec le clavier                       *
 *            - sauvegarder la base dans un fichier                                              *
 *            - importer la base depuis un fichier                                               *
 *                                                                                               *
 *************************************************************************************************/
public final class LeapDataBase implements Serializable, LeapDataBaseInterface {
	
	/***********************Attributs***************************/
	
	private static final long serialVersionUID = 1L;
	public ArrayList<LeapData> table;

	
	
	
	/***********************Consctruceurs************************/	
	
	public LeapDataBase(){
		this.table = new ArrayList<LeapData>(); 
	}

	
    /*************************Fonctions diverses***********************/
	//Associe une frame avec une cible et la met dans la base en fonction d'un char tappe au clavier
	public void put( Frame frame,char inChar) throws IllegalArgumentException, NullPointerException, LetterException{
		switch(inChar){
		case 'a' : 
			this.table.add(new LeapData(frame, Cible.PDJ));
			break;
		case 'z':
			this.table.add(new LeapData(frame, Cible.KVZ));
			break;
		case 'e':
			this.table.add(new LeapData(frame, Cible.SR));
			break;
		case 'r':
			this.table.add(new LeapData(frame, Cible.G));
			break;
		case 't':
			this.table.add(new LeapData(frame, Cible.ICHGNW));
			break;
		case 'y': 			
			this.table.add(new LeapData(frame, Cible.MTF));
			break;
		case 'u': 
			this.table.add(new LeapData(frame, Cible.YNG));
			break;
		case 'i':
			this.table.add(new LeapData(frame, Cible.BNUI));
			break;
		default: 
			throw (new LetterException(inChar));
			
		}
	}
	
	
	//Enregistre la base dans un fichier
	public void write(String file) throws Exception {

		Controller controller = new Controller();
		char inChar = 0;
		BufferedReader entree;
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;


		System.out.println("Veuillez positionner votre main au dessus de la Leap motion, appuyer sur la touche de la clef correspondante et valider pour enregistrer.");


		while(true){//on gere la sortie de la boucle par le clavier

			fos = new FileOutputStream(file); //on reeouvre un fichier a chaque tour de boucle pour enregistrer le fichier a chaque tour de boucle
			oos = new ObjectOutputStream(fos);


			entree = new BufferedReader(new InputStreamReader(System.in));//lecture de la touche tappee au clavier
			inChar = (char) entree.read();


			if(inChar == 'q'){ //quitter le programme
				oos.writeObject(this.table);
				oos.flush();
				oos.close();
				fos.close();
				return;
			}

			Frame frame = controller.frame();//capute de l'image leapmotion
			
			if(frame.hands().count() > 0 && frame.fingers().count() > 0){//on verifie que l'image n'est pas vide et qu'il y a bien une main
				try{
				this.put(frame, inChar); 
				} catch (LetterException e){
					System.out.println("Caractere non valide");
				} finally {}
			}
			else {
				System.out.println("L'image capturee n'est pas valide. Elle n'est pas enregistreee.");
			}
						
			
			oos.writeObject(this.table);
			oos.flush();
			oos.close();
			fos.close();

		}



	}

	
	//Importation d'une base depuis un fichier
	public void read(String file) throws Exception{

		FileInputStream fis = null;
		ObjectInputStream ois = null;


		fis = new FileInputStream(file);
		ois = new ObjectInputStream(fis); 

		try{
			this.table = (ArrayList<LeapData>) ois.readObject();
		}catch(EOFException e){

		}
		ois.close();
		fis.close();
	}





}

