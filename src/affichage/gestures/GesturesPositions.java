package affichage.gestures;

import java.util.Hashtable;


public class GesturesPositions 
{
	private Hashtable<String, Gestures> allGestures	 = new Hashtable<String, Gestures>();
	
	public GesturesPositions() {
		
		allGestures.put("MTF ", new Gestures(10, 410));
		allGestures.put("SR  ", new Gestures(100, 410));
		allGestures.put("PDJ ", new Gestures(190, 410));
		allGestures.put("BNUI", new Gestures(280, 410));
		allGestures.put(" G  ", new Gestures(10, 490));
		allGestures.put("KVZ ", new Gestures(100, 490));
		allGestures.put("YNG ", new Gestures(190, 490));
		allGestures.put("ICHG", new Gestures(280, 490));
		
		allGestures.put("NO detection!",new Gestures(0,0,0,0));
		
	}
	
	public Gestures getGestures(String key){
		return allGestures.get(key);
	}
	
}
