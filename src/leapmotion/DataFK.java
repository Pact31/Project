package leapmotion;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

import LeapTS.FrameTS;

import com.leapmotion.leap.*;

import classification.Cible;

public class DataFK implements Serializable {
	
		
	   Hashtable<FrameTS, Integer> table;
	   
	   public DataFK(){
	    this.table = new Hashtable<FrameTS, Integer>(); 
	   }
	   
	   public void put( FrameTS framets,Integer inchar) throws Exception{
		   switch(inchar){
		   case 1 : 
			   table.put(framets, 1);
			   break;
		  /* case 'z':
			   table.put(framets, Cible.KVZ);
			   break;
		   case 'e':
			   table.put(framets, Cible.SR);
			   break;
		   case 'r':
			   table.put(framets, Cible.G);
			   break;
		   case 't':
			   table.put(framets, Cible.ICHGNW);
			   break;
		   case 'y':
			   table.put(framets, Cible.MTF);
			   break;
		   case 'u':
			   table.put(framets, Cible.YNG);
			   break;
		   case 'i':
			   table.put(framets, Cible.BNUI);
			   break;*/
		   default: 
			   throw (new Exception("Caractere invalide\n"));
			   
		   }
	   
		  
	   }
	   
	   		   
	/*	public Cible test(){
			return this.table.elements().nextElement();
		}*/
		   

}
