package kppv;
import java.util.ArrayList;

/*Cette classe regroupe dans un tableau les éléments de 
 * la base d'apprentissage, utile pour calculer les 
 * distances d'une entrée à la base d'apprentissage et 
 * permettre de regrouper les apprentissages par cible*/ 
public class BanqueApprentissage {

	private ArrayList<Apprentissage> banque;

	public BanqueApprentissage(){
		this.banque=new ArrayList<Apprentissage>();
	}

	/*ajoute un apprentissage au tableau*/
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

	/*retourne un tableau de cibles qui énumère toutes 
	 * les cibles existantes dans la base d'apprentissage 
	 * avec pour chacune un compteur initialisé à 0*/
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
