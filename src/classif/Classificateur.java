package classif;

import java.util.ArrayList;
import java.util.Iterator;


public abstract class Classificateur implements ClassificateurInterface{
	
	protected BanqueApprentissage banque;
	
	
	public Classificateur(){
		this.banque = new BanqueApprentissage();
	}
	
	public Classificateur(String file) throws Exception{
		this.banque = new BanqueApprentissage(file);
	}
	
	public Classificateur(BanqueApprentissage banque){
		this.banque=banque;
	}
	
	public void setBanque(BanqueApprentissage banque){
		this.banque = banque;
	}
	
	public BanqueApprentissage getBanque(){
		return this.banque;
	}
	
	public abstract Cible classifier(Entree entree);
		
	
	
	public float test(BanqueApprentissage banqueApprentissage){
		float reussite = 0;
		int length = banqueApprentissage.size();
		Iterator<Apprentissage> iterator = banqueApprentissage.iterator();
		
		while(iterator.hasNext()){
			Apprentissage apprentissage = iterator.next();
			Entree entree = (Entree) apprentissage;
			Cible cible = apprentissage.getCible();
			Cible cibleFound = classifier(entree);
			if (cible == cibleFound){
				reussite = reussite + 1;
			}
		}
		return reussite/length;
	}
	
	public float crossTest(){
		float reussite = 0;
		ArrayList<CoupleBanqueApprentissage> banques = this.banque.divise();
		int size = banque.size();
		int i = 0;
		for (CoupleBanqueApprentissage couple : banques){
			i++;
			setBanque(couple.getBanqueClassificateur());
			BanqueApprentissage banqueTest = couple.getBanqueTest();
			reussite = reussite + test(couple.getBanqueTest());
		}
		return reussite/(float) i;
	}

	
	
	
}
