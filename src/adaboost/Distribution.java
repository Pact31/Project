package adaboost;

import java.util.ArrayList;

public class Distribution {

	private ArrayList<Double> distribution;
	private final double NUMBER_FINGERS = 5;
	
	public Distribution(){
		
		for(int i = 0;i < NUMBER_FINGERS;i++){
			distribution.add(1/NUMBER_FINGERS);
		}
		
	}
	
	public void set(ArrayList<Double> dis){
		
		distribution = dis;
	
	}
	
	public ArrayList<Double> getDistribution(){
		
		return distribution;
	}
	
}
