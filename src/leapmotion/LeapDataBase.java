package leapmotion;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;

import LeapTS.FrameTS;
import classification.Cible;

public final class LeapDataBase implements Serializable, LeapDataBaseInterface {
	
	//////////////////////////////////////////////
	//         Declaration des variables        //
	//////////////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	Hashtable<FrameTS, Cible> table;

	
	
	
	//////////////////////////////////////////////
	//                Constructeur              //
	//////////////////////////////////////////////	
	
	public LeapDataBase(){
		this.table = new Hashtable<FrameTS, Cible>(); 
	}

	
		
	public void put( FrameTS framets,char inChar) throws IllegalArgumentException, NullPointerException, LetterException{
		switch(inChar){
		case 'a' : 
			table.put(framets, Cible.PDJ);
			break;
		case 'z':
			table.put(framets, Cible.KVZ);
			break;
		case 'e':
			table.put(framets, Cible.SR);
			break;
		case 'r':
			table.put(framets, Cible.G);
			break;
		case 't':
			table.put(framets, Cible.ICHGNW);
			break;
		case 'y':
			table.put(framets, Cible.MTF);
			break;
		case 'u':
			table.put(framets, Cible.YNG);
			break;
		case 'i':
			table.put(framets, Cible.BNUI);
			break;
		default: 
			throw (new LetterException(inChar));

		}
	}
	
	
	public void write(String file) {

		Controller controller = new Controller();
		LeapDataBase table = new LeapDataBase() ;
		char inChar = 0;
		BufferedReader entree;
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

		
		System.out.println("Veuillez positionner votre main au dessus de la Leap motion, appuyer sur la touche de la clef correspondante et valider pour enregistrer.");

		while(true){

			entree = new BufferedReader(new InputStreamReader(System.in));
			try {
				inChar = (char) entree.read();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if(inChar == 'q'){ //quitter le programme
				return;
			}

			FrameTS framets = new FrameTS(controller.frame());

			try{
				this.put(framets, inChar); 
			} 
			catch (LetterException e){
				System.out.println("La touche pressee n'est pas valide");
				break;
			}
			catch (IllegalArgumentException e){
				e.printStackTrace();
			}
			catch (NullPointerException e){
				e.printStackTrace();
			}
			finally {
			}

			try {
				oos.writeObject(table);
				oos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}    

	} 
	


}

