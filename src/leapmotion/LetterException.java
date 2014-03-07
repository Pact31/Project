package leapmotion;

public class LetterException extends Exception{
	

	private static final long serialVersionUID = 1L;

	public LetterException (char inChar){
		super("Le caractere entree n'est pas valide : " + inChar);
	}
}
