package classif.classification;
import java.util.ArrayList;

/************************************************************
 * Cette classe regroupe dans un tableau les elements de    *
 * la base d'apprentissage, utile pour calculer les         *
 * distances d'une entree a� la base d'apprentissage et     *
 * permettre de regrouper les apprentissages par cible      *
 * **********************************************************/


public class BanqueApprentissage {

	private ArrayList<Apprentissage> banque;

	
	
	public BanqueApprentissage(){
		this.banque=new ArrayList<Apprentissage>();
	}

	public void addApprentissage(Apprentissage apprentissage){
		this.banque.add(apprentissage);
	}

	/*retourne toute la banque d'apprentissage*/
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
