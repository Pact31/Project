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
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;

import LeapTS.FrameTS;
import classification.Cible;

public final class LeapDataBase implements Serializable, LeapDataBaseInterface {
	
	//////////////////////////////////////////////
	//         Declaration des variables        //
	//////////////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	Hashtable<Cible, FrameTS> table;

	
	
	
	//////////////////////////////////////////////
	//                Constructeur              //
	//////////////////////////////////////////////	
	
	public LeapDataBase(){
		this.table = new Hashtable<Cible, FrameTS>(); 
	}

	
	public Set<Map.Entry<Cible, FrameTS>> getMapEntry(){
		return table.entrySet();
	}
	
		
	public void put( FrameTS framets,char inChar) throws IllegalArgumentException, NullPointerException, LetterException{
		switch(inChar){
		case 'a' : 
			table.put(Cible.PDJ, framets);
			break;
		case 'z':
			table.put(Cible.KVZ, framets);
			break;
		case 'e':
			table.put(Cible.SR, framets);
			break;
		case 'r':
			table.put(Cible.G, framets);
			break;
		case 't':
			table.put(Cible.ICHGNW, framets);
			break;
		case 'y':
			table.put(Cible.MTF, framets);
			break;
		case 'u':
			table.put(Cible.YNG, framets);
			break;
		case 'i':
			table.put(Cible.BNUI, framets);
			break;
		default: 
			throw (new LetterException(inChar));

		}
	}
	
	
	public void write(String file) throws Exception {

		Controller controller = new Controller();
		char inChar = 0;
		BufferedReader entree;
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;


		System.out.println("Veuillez positionner votre main au dessus de la Leap motion, appuyer sur la touche de la clef correspondante et valider pour enregistrer.");


		while(true){//on gere la sortie de la boucle par le clavier

			fos = new FileOutputStream("test.test"); //on reeouvre un fichier a chaque tour de boucle pour enregistrer le fichier a chaque tour de boucle
			oos = new ObjectOutputStream(fos);


			entree = new BufferedReader(new InputStreamReader(System.in));//lecture de la touche tappee au clavier
			inChar = (char) entree.read();


			if(inChar == 'q'){ //quitter le programme
				return;
			}

			Frame frame = controller.frame();//capute de l'image leapmotion
			
			if(frame.hands().count() > 0 && frame.fingers().count() > 0){//on verifie que l'image n'est pas vide et qu'il y a bien une main
				FrameTS framets = new FrameTS(frame);
				this.put(framets, inChar); 
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

	public void read(String file) throws Exception{

		FileInputStream fis = null;
		ObjectInputStream ois = null;

	
			fis = new FileInputStream("test.test");
			ois = new ObjectInputStream(fis); 

	try{
				this.table = (Hashtable<Cible, FrameTS>) ois.readObject();
	}catch(EOFException e){
		
	}
					ois.close();
				
					fis.close();


	}
	


}

