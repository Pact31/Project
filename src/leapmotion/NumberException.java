package leapmotion;

//Exception pour une lettre ne correspondant a aucune clef.


public class NumberException extends Exception{
	

	private static final long serialVersionUID = 1L;

	public NumberException (int inPos){
		super("Le chiffre entree n'est pas valide : " + inPos);
	}
}
