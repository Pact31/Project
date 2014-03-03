package leapmotion;
import java.io.IOException;
import java.util.ArrayList;

import com.leapmotion.leap.*;
public class Test{
	   public enum Key {
	 	      PDJ, KVZ, SR, BNUI, MTF, ICHGNW, G, YNG; //Correspond aux différentes "consonnes" codées par les clefs.
	 	}
	 	
public static void main(String[] args) {
       
       Controller controller = new Controller();
       DataFK table =new DataFK() ;
    
        
        int inChar;
        System.out.println("Press Enter to quit...");
        try {
            inChar = System.in.read();
            Frame frame = controller.frame();
            table.put(frame, inChar);
            
			
		}
       		 
            
         catch (IOException e) {
            e.printStackTrace();

      
        }

    }

}
