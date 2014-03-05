package affichage.test_classification;

import java.util.ArrayList;

public class FingerCar {
	
	private float length	=	0;
	private float width	=	0;
	private ArrayList<Float> car = new ArrayList<Float>();
	
	public FingerCar(){
		car.add(length);
		car.add(width);
	}
	
	public FingerCar(float l, float w){
		length = l;
		width = w;
		car.add(length);
		car.add(width);
	}
	
	public void setCar(float l, float w){
		car.set(0, l);
		car.set(1, w);
	}
	
	public float getLength(){
		return car.get(0);
	}
	
	public float getWidth(){
		return car.get(1);
	}
	
}
