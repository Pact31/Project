package leapmotion;

//Exception pour une lettre ne correspondant a aucune clef.


public class VoyelleException extends Exception{
	

	private static final long serialVersionUID = 1L;

	public VoyelleException (String v){
		super("La voyelle entree n'est pas valide : " + v);
	}
}
