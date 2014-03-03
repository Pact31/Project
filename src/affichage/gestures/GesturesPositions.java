package affichage.gestures;

import java.util.Hashtable;


public class GesturesPositions 
{
	private Hashtable<String, Gestures> allGestures	 = new Hashtable<String, Gestures>();
	
	public GesturesPositions() {
		
		allGestures.put("M", new Gestures(100, 410));
		allGestures.put("R", new Gestures(190, 410));
		allGestures.put("P", new Gestures(280, 410));
		allGestures.put("B", new Gestures(370, 410));
		allGestures.put("G", new Gestures(100, 490));
		
		allGestures.put("NO detection!",new Gestures(0,0,0,0));
		
	}
	
	public Gestures getGestures(String key){
		return allGestures.get(key);
	}
	
}
