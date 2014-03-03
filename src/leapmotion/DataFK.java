package leapmotion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import com.leapmotion.leap.*;
public class DataFK {
	public enum Key {
	      PDJ, KVZ, SR, BNUI, MTF, ICHGNW, G, YNG; //Correspond aux différentes "consonnes" codées par les clefs.
	}
	
	   Hashtable<Frame, Key> table
	     = new Hashtable<Frame, Key>();
	
	   public void put( Frame frame,Integer inchar){
		   switch(inchar){
		   case 97 : table.put(frame, Key.PDJ);
		   case 122:table.put(frame, Key.KVZ);
		   case 101:table.put(frame, Key.SR);
		   case 100:table.put(frame, Key.G);
		   case 115:table.put(frame, Key.ICHGNW);
		   case 113:table.put(frame, Key.MTF);
		   case 102:table.put(frame, Key.YNG);
		   case 114:table.put(frame, Key.BNUI);
		   }
		   
		   
		   
		  
	   }

}
