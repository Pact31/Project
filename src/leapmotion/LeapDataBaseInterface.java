package leapmotion;

import LeapTS.FrameTS;

public interface LeapDataBaseInterface {
	
	//Ajout d'une frame associee à une clef dans la base de donnee.
	//On associe une clef à chaque clef du clavier.
	public void put( FrameTS frame, char inChar) throws IllegalArgumentException, NullPointerException, LetterException;
	
	//Creation de la base de donnee et enregistrement a la suite du fichier 
	//passe en argument. L'utilisateur positionne sa main, appuie sur la
	//touche correspondant a la clef et valide son choix en appuyant
	//sur la touche entree.
	public void write(String file);
	
	//Renvoit la table de hachage enregistree a l'adresse specifiee
//	public Hashtable<FrameTS, Cible> read(String file);
	
//	public void print();

}
