package leapmotion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

public class test {
	
	Hashtable<Integer, String> u;
	
	public test(){
		u = new Hashtable<Integer, String>();
	}
	
public void write() throws IOException{
FileOutputStream fos = new FileOutputStream("user.serial");
ObjectOutputStream oos= new ObjectOutputStream(fos);
try {
	// Ecriture dans le flux de sortie
//	oos.writeObject(u);

	// Vide le tampon
	oos.flush();

	} finally {
		try {
			oos.close();
		} finally {
		fos.close();
	}
	}
}


////////////////////////////////////////::

public void read(){
try {
	// Ouverture du flux d'entrée sur le fichier
	FileInputStream fis = new FileInputStream("user.serial");
	ObjectInputStream ois= new ObjectInputStream(fis);

	try {
		// Lecture du flux et attribution à l'objet u
		u = (Hashtable<Integer, String>) ois.readObject();
	} finally {

		// Fermeture des flux
		try {
		ois.close();
		} finally {
			fis.close();
		}
	}
} catch(IOException ioe) {
	ioe.printStackTrace();
} catch(ClassNotFoundException cnfe) {
	cnfe.printStackTrace();
}
}

}
