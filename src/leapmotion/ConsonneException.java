package leapmotion;

//Exception pour une lettre ne correspondant a aucune clef.


public class ConsonneException extends Exception{
	

	private static final long serialVersionUID = 1L;

	public ConsonneException (String c){
		super("La consonnee entree n'est pas valide : " + c);
	}
}
