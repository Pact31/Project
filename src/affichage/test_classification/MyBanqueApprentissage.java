package affichage.test_classification;

import java.util.Hashtable;

import com.leapmotion.leap.Finger;

public class MyBanqueApprentissage {
	
	//private FingerCar car = new FingerCar();
	private Hashtable<Integer, FingerCar> bank =  new Hashtable<Integer, FingerCar>();
	
	public MyBanqueApprentissage(){
		
	}
	
	public void setCar(int num, Finger f){
		bank.put(num, new FingerCar(f.length(), f.width()));
	}
	
	public FingerCar getCar(int num){
		return bank.get(num);
	}
	
	

}
