package adaboost;
import java.util.ArrayList;


public class mainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {//will be the backbone of the project, this is where the integration will take place
		Adaboost test = new Adaboost();
		
		ArrayList<Integer> classifier = new ArrayList<Integer>();
		classifier = test.getFortClassifier();
		
		for(int i=0;i<20;i++){
			
			System.out.println("result:" + classifier.get(i));
		
		}
	}

}
