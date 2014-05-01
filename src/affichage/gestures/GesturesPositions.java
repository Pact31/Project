package affichage.gestures;

import java.util.Hashtable;
import java.util.ArrayList;

import classif.Cible;


public class GesturesPositions 
{
	private Hashtable<Cible, Gestures> allGestures	 = new Hashtable<Cible, Gestures>();
	
	public GesturesPositions() {
		
		
		allGestures.put(Cible.BNUI_B, new Gestures("BNUI", "B"));
		allGestures.put(Cible.BNUI_C, new Gestures("BNUI", "C"));
		allGestures.put(Cible.BNUI_G, new Gestures("BNUI", "GV"));
		allGestures.put(Cible.BNUI_M, new Gestures("BNUI", "M"));
		allGestures.put(Cible.BNUI_P, new Gestures("BNUI", "P"));
		
		allGestures.put(Cible.G_B, new Gestures("GC", "B"));
		allGestures.put(Cible.G_C, new Gestures("GC", "C"));
		allGestures.put(Cible.G_G, new Gestures("GC", "GV"));
		allGestures.put(Cible.G_M, new Gestures("GC", "M"));
		allGestures.put(Cible.G_P, new Gestures("GC", "P"));
		
		allGestures.put(Cible.ICHGNW_B, new Gestures("ICHGNW", "B"));
		allGestures.put(Cible.ICHGNW_C, new Gestures("ICHGNW", "C"));
		allGestures.put(Cible.ICHGNW_G, new Gestures("ICHGNW", "GV"));
		allGestures.put(Cible.ICHGNW_M, new Gestures("ICHGNW", "M"));
		allGestures.put(Cible.ICHGNW_P, new Gestures("ICHGNW", "P"));
		
		allGestures.put(Cible.KVZ_B, new Gestures("KVZ", "B"));
		allGestures.put(Cible.KVZ_C, new Gestures("KVZ", "C"));
		allGestures.put(Cible.KVZ_G, new Gestures("KVZ", "GV"));
		allGestures.put(Cible.KVZ_M, new Gestures("KVZ", "M"));
		allGestures.put(Cible.KVZ_P, new Gestures("KVZ", "P"));
		
		allGestures.put(Cible.SR_B, new Gestures("SR", "B"));
		allGestures.put(Cible.SR_C, new Gestures("SR", "C"));
		allGestures.put(Cible.SR_G, new Gestures("SR", "GV"));
		allGestures.put(Cible.SR_M, new Gestures("SR", "M"));
		allGestures.put(Cible.SR_P, new Gestures("SR", "P"));
		
		allGestures.put(Cible.YNG_B, new Gestures("YNG", "B"));
		allGestures.put(Cible.YNG_C, new Gestures("YNG", "C"));
		allGestures.put(Cible.YNG_G, new Gestures("YNG", "GV"));
		allGestures.put(Cible.YNG_M, new Gestures("YNG", "M"));
		allGestures.put(Cible.YNG_P, new Gestures("YNG", "P"));
		
		allGestures.put(Cible.MTF_B, new Gestures("MTF", "B"));
		allGestures.put(Cible.MTF_C, new Gestures("MTF", "C"));
		allGestures.put(Cible.MTF_G, new Gestures("MTF", "GV"));
		allGestures.put(Cible.MTF_M, new Gestures("MTF", "M"));
		allGestures.put(Cible.MTF_P, new Gestures("MTF", "P"));
		
		allGestures.put(Cible.PDJ_B, new Gestures("MTF", "B"));
		allGestures.put(Cible.PDJ_C, new Gestures("MTF", "C"));
		allGestures.put(Cible.PDJ_G, new Gestures("MTF", "GV"));
		allGestures.put(Cible.PDJ_M, new Gestures("MTF", "M"));
		allGestures.put(Cible.PDJ_P, new Gestures("MTF", "P"));
		
		
	}
	
	public Gestures getGestures(Cible cible){
		
		return allGestures.get(cible);
	
	}
	
	
	
}
