package adaboost;
import java.util.ArrayList;

import test_classification.Classifier;


public class mainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {//will be the backbone of the project, this is where the integration will take place
		Adaboost test = new Adaboost();
		ArrayList<ArrayList<Integer>> classifiers = test.getClassifers();
		ArrayList<Double> poids = new ArrayList<Double>();
		poids = test.getPoids();
		ArrayList<Double> res = new ArrayList<Double>();
		
		double tmp=0;
		
		test.print();
		for(int i=0;i<poids.size();i++){
			System.out.println(poids.get(i));
		}
		for(int y=0;y<classifiers.get(0).size();y++){
			tmp=0;
			for(int x=0;x<3;x++){
				// System.out.print(classifiers.get(x).get(y) + " ");
				 tmp += (double)classifiers.get(x).get(y)*poids.get(x);
			}
			res.add(tmp);
			//System.out.print("\n");
		}
		
		for(int i=0;i<10;i++){
			
			System.out.println("result:" + res.get(i));
		}
	}

}
