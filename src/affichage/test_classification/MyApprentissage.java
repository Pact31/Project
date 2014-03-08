package affichage.test_classification;


import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.FingerList;



public class MyApprentissage {
	
	private MyBanqueApprentissage bank = new MyBanqueApprentissage();
	/*private ArrayList<Float> lengthSeuil = new ArrayList<Float>();
	private ArrayList<Float> widthSeuil = new ArrayList<Float>();
	*/
	public MyApprentissage(){
		
	}
	
	private Controller leap = new Controller();
	
	public void setBank() throws InterruptedException{
		
		
		FingerList  allFingers = leap.frame().fingers();
		int numOfFinger = allFingers.count();
		System.out.println(numOfFinger);
		
		for(int p = 0; p < numOfFinger; p++) {
            
			Finger finger = allFingers.get(p);
			bank.setCar(p, finger);
			System.out.println(String.format("leng: %f, wid: %f", finger.length(), finger.width()));
		}
		
	}
	
	public void saveBank(String filename) throws Exception{
		FileOutputStream     fos = new FileOutputStream(filename) ;
	    BufferedOutputStream bos = new BufferedOutputStream(fos) ;
	    DataOutputStream     dos = new DataOutputStream(bos) ;
	    
	    for(int i = 0;i < 5;i++){
	    	
	    	float l = bank.getCar(i).getLength();
	    	float w = bank.getCar(i).getWidth();
	    	//myFinger.carLength(seuil)
	    	dos.writeUTF( String.format("length: %f, width: %f", l, w) );
	    }
	    
	    //dos.writeUTF(String.format("abc %d \n", i));
	    dos.close();
	}
}
