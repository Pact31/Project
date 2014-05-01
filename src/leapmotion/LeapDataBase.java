package leapmotion;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
	public void write(String file) {

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
			try {
				fos = new FileOutputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("Erreur lors de l'ouverture du fichier.");
				e1.printStackTrace();
			} //on reeouvre un fichier a chaque tour de boucle pour enregistrer le fichier a chaque tour de boucle
			try {
				oos = new ObjectOutputStream(fos);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Erreur lors de l'ouverture du ObjectOutputStream.");
				e1.printStackTrace();
			}


			entree = new BufferedReader(new InputStreamReader(System.in));//lecture de la touche tappee au clavier

			try {
				inChar = (char) entree.read();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Erreur lors de la lecture au clavier du premier caract�re.");
				e1.printStackTrace();
			}
			try {
				inPos = (int) entree.read() - 48;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Erreur lors de la lecture au clavier du second caract�re.");
				e1.printStackTrace();
			} //le 1 correspond a 49

			
			System.out.println(inChar + "___" + inPos);


			if(inChar == 'q'){ //quitter le programme
				try {
					oos.writeObject(this.table);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Erreur lors de l'�criture de la table dans le fichier.");
					e.printStackTrace();
				}
				try {
					oos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Erreur lors du flush.");
					e.printStackTrace();
				}
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Erreur lors de la fermeture du ObjectOutputStream");
					e.printStackTrace();
				}
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Erreur lors de la fermeture du fichier.");
					e.printStackTrace();
				}
				return;
			}

			Frame frame = controller.frame();//capute de l'image leapmotion
			
			if(frame.hands().count() > 0 && frame.fingers().count() > 0){//on verifie que l'image n'est pas vide et qu'il y a bien une main
				try{
				System.out.println(i);

				try {
					this.table.add(new LeapData(frame, inChar, inPos));
				} catch (IllegalArgumentException | NullPointerException e)
				{
					// TODO Auto-generated catch block
					System.out.println("Erreur lors de la cr�ation d'un nouvel objet LeapData");
					e.printStackTrace();
				}

				} finally {}
			}
			else {
				System.out.println("L'image capturee n'est pas valide. Elle n'est pas enregistreee.");
			}
						
			
			//Cette section de code est obligatoire pour le bon foncitonnement du programme mais n'est jamais execut�e
			//car l'utilisateur appuie toujours sur "q".
			try {
					oos.writeObject(this.table);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Erreur lors de l'écriture de la table dans le fichier.");
					e.printStackTrace();
				}
				try {
					oos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Erreur lors du flush.");
					e.printStackTrace();
				}
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Erreur lors de la fermeture du ObjectOutputStream");
					e.printStackTrace();
				}
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Erreur lors de la fermeture du fichier.");
					e.printStackTrace();
				}

		}



	}
	
	
		//Enregistre la base dans un fichier
	public void write(String file, String c, String v) {

		Controller controller = new Controller();
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;


			try {
				fos = new FileOutputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("Erreur lors de l'ouverture du fichier.");
				e1.printStackTrace();
			} //on reeouvre un fichier a chaque tour de boucle pour enregistrer le fichier a chaque tour de boucle
			try {
				oos = new ObjectOutputStream(fos);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Erreur lors de l'ouverture du ObjectOutputStream.");
				e1.printStackTrace();
			}

			Frame frame = controller.frame();//capute de l'image leapmotion
			
			if(frame.hands().count() > 0 && frame.fingers().count() > 0){//on verifie que l'image n'est pas vide et qu'il y a bien une main
				try{
				try {
					this.table.add(new LeapData(frame, c, v));
				} catch (IllegalArgumentException | NullPointerException e)
				{
					// TODO Auto-generated catch block
					System.out.println("Erreur lors de la création d'un nouvel objet LeapData");
					e.printStackTrace();
				}
				} finally {}
			}
			else {
				System.out.println("L'image capturee n'est pas valide. Elle n'est pas enregistreee.");
			}
						
	}

	
	//Importation d'une base depuis un fichier
	public void read(String file){

		FileInputStream fis = null;
		ObjectInputStream ois = null;


		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

		try {
			this.table = (ArrayList<LeapData>) ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





}

