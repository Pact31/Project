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
	
}
