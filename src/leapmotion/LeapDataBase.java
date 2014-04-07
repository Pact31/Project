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
	
	public LeapDataBase(String file) throws Exception{
		this.table = new ArrayList<LeapData>();
		read(file);
	}

	
    /*************************Fonctions diverses***********************/
	
	//Enregistre la base dans un fichier
	public void write(String file) throws Exception {

		Controller controller = new Controller();
		char inChar = 0;
		int inPos= 0;
		BufferedReader entree;
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		int i = 0;

		System.out.println("Veuillez positionner votre main au dessus de la Leap motion, appuyer sur la touche de la clef correspondante et valider pour enregistrer.");


		while(true){//on gere la sortie de la boucle par le clavier
			i++;
			fos = new FileOutputStream(file); //on reeouvre un fichier a chaque tour de boucle pour enregistrer le fichier a chaque tour de boucle
			oos = new ObjectOutputStream(fos);


			entree = new BufferedReader(new InputStreamReader(System.in));//lecture de la touche tappee au clavier
			inChar = (char) entree.read();
			inPos = (int) entree.read();


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
				System.out.println(i);
				this.table.add(new LeapData(frame, inChar, inPos)); 
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

