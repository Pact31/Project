package classification;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Classificateur implements ClassificateurInterface{
	
	private BanqueApprentissage banque;
	
	public Classificateur(){
		this.banque = new BanqueApprentissage();
	}
	
	public Classificateur(String file) throws Exception{
		this.banque = new BanqueApprentissage(file);
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
				reussite = reussite + 1/length;
			}
		}
		
		return reussite;
	}
	
	public float crossTest(){
		float reussite = 0;
		ArrayList<CoupleBanqueApprentissage> banques = this.banque.divise();
		int size = banque.size();
		for (CoupleBanqueApprentissage couple : banques){
			Classificateur classificateur = new Classificateur(couple.getBanqueClassificateur());
			reussite = reussite + classificateur.test(couple.getBanqueTest())/size;
		}
	}
	
	
	
}
