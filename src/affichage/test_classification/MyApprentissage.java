package affichage.test_classification;


import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.FingerList;



public class MyApprentissage {
	
	FingerCar car = new FingerCar();
	MyBanqueApprentissage bank = new MyBanqueApprentissage();
	
	public MyApprentissage(){
		
	}
	
	private Controller leap = new Controller();
	
	public void setBank(){
		
		
		FingerList  allFingers = leap.frame().fingers();
		int numOfFinger = allFingers.count();
		
		for(int p = 0; p < numOfFinger; p++) {
            
			Finger finger = allFingers.get(p);
			bank.setCar(p, finger);
        
		}
		
		
	}
	
	public void saveBank(String filename) throws Exception{
		FileOutputStream     fos = new FileOutputStream(filename) ;
	    BufferedOutputStream bos = new BufferedOutputStream(fos) ;
	    DataOutputStream     dos = new DataOutputStream(bos) ;
	    
	    for(int i = 0;i < 5;i++){
	    	
	    	float l = bank.getCar(i).getLength();
	    	float w = bank.getCar(i).getWidth();
	    	dos.writeUTF( String.format("length: %f, width: %f", l, w) );
	    }
	    
	    //dos.writeUTF(String.format("abc %d \n", i));
	    dos.close();
	}
}
