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
		
		fos = new FileOutputStream("test.test");
		oos = new ObjectOutputStream(fos);

		
		System.out.println("Veuillez positionner votre main au dessus de la Leap motion, appuyer sur la touche de la clef correspondante et valider pour enregistrer.");
		
		for(int i = 0; i < 3; i ++){
			
	//		try {
				
/*			}  catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/ 

			entree = new BufferedReader(new InputStreamReader(System.in));
			//try {
				inChar = (char) entree.read();
			/*} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/

			if(inChar == 'q'){ //quitter le programme
				return;
			}

			FrameTS framets = new FrameTS(controller.frame());

		//	try{
				this.put(framets, inChar); 
		/*	} 
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
			}*/

		//	try {
				oos.writeObject(this.table);
				oos.flush();
		/*	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {*/
				/*} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				try {*/
				/*} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		//	}
		//	}


	}
				oos.close();

		fos.close();


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

