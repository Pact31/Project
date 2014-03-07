package leapmotion;

import com.leapmotion.leap.Frame;

public interface LeapDataBaseInterface {
	
	//Ajout d'une frame associee � une clef dans la base de donnee.
	//On associe une clef � chaque clef du clavier.
	public void put( Frame frame, char inChar) throws IllegalArgumentException, NullPointerException, LetterException;
	
	//Creation de la base de donnee et enregistrement a la suite du fichier 
	//passe en argument. L'utilisateur positionne sa main, appuie sur la
	//touche correspondant a la clef et valide son choix en appuyant
	//sur la touche entree.
	public void write(String file) throws Exception;
	
	//public Set<Map.Entry<Cible, FrameTS>> getMapEntry();
	
	//Renvoit la table de hachage enregistree a l'adresse specifiee
//	public Hashtable<FrameTS, Cible> read(String file);
	
//	public void print();

}
