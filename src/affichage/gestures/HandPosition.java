package affichage.gestures;

import java.util.Hashtable;


public class HandPosition 
{
	private Hashtable<String, Hand> allHandsPosition = new Hashtable<String, Hand>();
	
	public HandPosition() {
		
		allHandsPosition.put("MTF ", new Hand(10, 410));
		allHandsPosition.put("SR  ", new Hand(100, 410));
		allHandsPosition.put("PDJ ", new Hand(190, 410));
		allHandsPosition.put("BNUI", new Hand(280, 410));
		allHandsPosition.put("BNUI", new Hand(280, 410));
		
		allHandsPosition.put("NO detection!",new Hand(0,0,0,0));
		
	}
	
	public Hand getHand(String key){
	
		return allHandsPosition.get(key);
	
	}
	
}
