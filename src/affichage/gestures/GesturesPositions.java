package affichage.gestures;

import java.util.Hashtable;

import classif.Cible;


public class GesturesPositions 
{
	private Hashtable<Cible, Gestures> allGestures	 = new Hashtable<Cible, Gestures>();
	
	public GesturesPositions() {
		
		/*
		allGestures.put(Cible.BNUI_B, new Gestures(10, 410));
		allGestures.put(Cible.BNUI_C, new Gestures(100, 410));
		allGestures.put(Cible.BNUI_G, new Gestures(190, 410));
		allGestures.put("BNUI", new Gestures(280, 410));
		allGestures.put(" G  ", new Gestures(10, 490));
		allGestures.put("KVZ ", new Gestures(100, 490));
		allGestures.put("YNG ", new Gestures(190, 490));
		allGestures.put("ICHG", new Gestures(280, 490));
		*/
	}
	
	public Gestures getGestures(Cible cible){
		
		return allGestures.get(cible);
	
	}
	
}
