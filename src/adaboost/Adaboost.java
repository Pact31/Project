package adaboost;

import java.util.ArrayList;

public class Adaboost {
	
	private ArrayList<Integer> car = new ArrayList<Integer>();
	private ArrayList<ArrayList<Integer>> classifierList = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Double> poidsList = new ArrayList<Double>();
	
	public Adaboost(/*ArrayList<Integer> enter*/){
		//car = enter;
		car.add(1);
		car.add(1);
		car.add(1);
		car.add(-1);
		car.add(-1);
		car.add(-1);
		car.add(1);
		car.add(1);
		car.add(1);
		car.add(-1);
		car.add(-1);
		car.add(1);
		car.add(1);
		car.add(1);
		car.add(-1);
		car.add(-1);
		car.add(1);
		car.add(1);
		car.add(1);
		car.add(-1);
		
		calculClassifiers();
	}
	public void print(){
		
		for(int i=0;i<car.size();i++){
			System.out.print(car.get(i));
		}
		System.out.print("\n");
	}
	
	public ArrayList<ArrayList<Integer>> getClassifers(){
		return classifierList;
	}
	
	public ArrayList<Double> getPoids(){
		return poidsList;
	}
	
	
	private void calculClassifiers(){
		
		ArrayList<Double> distribution = new ArrayList<Double>();
		ArrayList<Integer> classifier = new ArrayList<Integer>();
		ArrayList<Integer> bestClassifier = new ArrayList<Integer>();
		
		double minError = 0;
		double error = 0;
		double poids = 0;
		/*--------- Initialization ---------*/
		for(int i=0;i<car.size();i++){
			distribution.add(1.0/(double)car.size());
		}
		
		for(int j=0;j<100;j++){
		
			minError = 1;
			
			/*-------------find a best weak classifier----------------------*/
			for(int x=0;x<2*car.size();x++){
				
				if(x<10)
					classifier = getWeakClassifier(x,1);
				else
					classifier = getWeakClassifier(x%10,-1);
				
				error = compare(distribution, car, classifier);
		
				if(error < minError){
					minError = error;
					bestClassifier=classifier;
				}
				
			}
			/*---------------- update distribution--------------------------*/
			poids = 0.5*Math.log((1-minError)/minError);
			distribution = newDistribution(distribution, poids, bestClassifier);
			classifierList.add(bestClassifier);//list of classifiers 
			poidsList.add(poids);//list of poids
			
		}
		
	}
	public ArrayList<Integer> getFortClassifier(){
		
		ArrayList<Integer> fortClassifier = new ArrayList<Integer>();
		double res = 0;
		
		for(int i=0;i<classifierList.get(0).size();i++){
			
			for(int j=0;j<poidsList.size();j++){
				res += classifierList.get(j).get(i)*poidsList.get(j);
				System.out.println(res);
			}
			if(res>0)
				fortClassifier.add(1);
			else
				fortClassifier.add(-1);
			res=0;
		}
		
		return fortClassifier;
	}
	
	private ArrayList<Double> newDistribution(ArrayList<Double> distribution, double poids, ArrayList<Integer> classifier){
		ArrayList<Double> resDistribution = new ArrayList<Double>();
		double somme = 0;
		
		for(int i=0;i<car.size();i++){
			
			double dis	=	distribution.get(i)*Math.exp(-poids*car.get(i)*classifier.get(i));
			somme += dis;//for normalization
			resDistribution.add(dis);
		
		}
		
		for(int x=0;x<car.size();x++){
			resDistribution.set(x, resDistribution.get(x)/somme);
		}
		
		return resDistribution;
	}
	
	
	private ArrayList<Integer> getWeakClassifier(int seuil, int position){
		
		ArrayList<Integer> classifier = new ArrayList<Integer>();
		
		for(int i=0;i<car.size();i++){
			
			if(i<seuil+0.5)
				classifier.add(position);
			else
				classifier.add(-position);
		
		}
		
		return classifier;
	}
	
	private double compare(ArrayList<Double> distribution, ArrayList<Integer> car,ArrayList<Integer> e){
		
		double error = 0;
		
		for(int i=0;i<car.size();i++){
		
			if(car.get(i) != e.get(i))
				error += distribution.get(i);
		
		}
		
		return error;
	}
	
}
