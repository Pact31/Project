package classification;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import LeapTS.FrameTS;
import leapmotion.LeapDataBase;

/************************************************************
 * Cette classe regroupe dans un tableau les elements de    *
 * la base d'apprentissage, utile pour calculer les         *
 * distances d'une entree a  la base d'apprentissage et     *
 * permettre de regrouper les apprentissages par cible      *
 * **********************************************************/


public class BanqueApprentissage {

	private ArrayList<Apprentissage> banque;

	public BanqueApprentissage(){
		this.banque=new ArrayList<Apprentissage>();
	}
	
	public BanqueApprentissage(LeapDataBase leapDataBase){
		this.banque=new ArrayList<Apprentissage>();
		Set<Map.Entry<Cible, FrameTS>> mapEntry = leapDataBase.getMapEntry();
		for(Map.Entry<Cible, FrameTS> entry : mapEntry){
			Apprentissage apprentissage = new Apprentissage(entry.getValue().getFingerList(), entry.getValue().getHandList().get(0).getPalmPosition(), entry.getKey());
			this.banque.add(appentissage);
		}
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
