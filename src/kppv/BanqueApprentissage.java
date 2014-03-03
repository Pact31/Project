package kppv;
import java.util.ArrayList;


public class BanqueApprentissage {
	
	private ArrayList<Apprentissage> banque;
	
	public BanqueApprentissage(){
		this.banque=new ArrayList<Apprentissage>();
	}

	public void addAprrentissage(Apprentissage apprentissage){
		
		this.banque.add(apprentissage);
	}
	
	public ArrayList<Apprentissage> getAllApprentissage(){
		
		return banque;
	}
	
	public Apprentissage getApprentissage(int i){
		
		return this.banque.get(i);
				
	}
	
	public int size(){
		return this.banque.size();
	}
	
	public TableauCibles getAllCibles(){
		TableauCibles t= new TableauCibles();
		for (int i=0;i<this.size();i++){
			int k=0;
			while (this.getApprentissage(k).getCible().compareSyllabe(this.getApprentissage(i).getCible().getSyllabe())==0 && k<i){
				k=k+1;
			}
			if (k==i) t.add(this.getApprentissage(i).getCible());
			
		}
		
		for (int i=0;i<t.size();i++){
			t.get(i).setCompteur(0);
		}
		return t;
	}
	
}
