package leapmotion;

import com.leapmotion.leap.Frame;

public interface LeapDataBaseInterface {
	
	//Ajout d'une frame associee à une clef dans la base de donnee.
	//On associe une clef a huits touches du clavier, ici des char.
	
	//Creation de la base de donnee et enregistrement a la suite du fichier 
	//passe en argument. L'utilisateur positionne sa main, appuie sur la
	//touche correspondant a la clef et valide son choix en appuyant
	//sur la touche entree.
	public void write(String file) throws Exception;
	
	
	//importe une base de donnee depuis le fichier file.
	public void read(String file) throws Exception;

}
