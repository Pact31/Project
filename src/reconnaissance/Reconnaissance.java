package reconnaissance;

import com.leapmotion.leap.Controller;

import classif.Cible;
import classif.ClassificateurInterface;
import classif.Entree;

public class Reconnaissance implements ReconnaissanceInterface{
	
	private ClassificateurInterface classificateur;
	private long time; //Temps caracteristique de la reonnaissance en nanosecondes
	Controller controller = new Controller();
	
	public Reconnaissance (ClassificateurInterface classificateur, long time){
		this.classificateur = classificateur;
		setTime(time);
	}
	
	public long getTime(){
		return this.time;
	}
	
	public void setTime(long time){
		this.time = (long) (time * Math.pow(10,9));
	}
	
	
	public Cible reconnaitre(Cible cible){
		Cible currentCible = null;
		System.out.println("Tu as " + time + " secondes pour signer la syllabe " + cible);
		long start = System.nanoTime();
		while((System.nanoTime() - start < time) || (currentCible != cible)){
			currentCible = classificateur.classifier(new Entree(controller));
		}
		if(currentCible == cible){
			System.out.println("Bravo, tu as bien signe!");
		}
		else {
			System.out.println("Oups, tu as signe " + currentCible + " a la place de " + cible);
		}
		return currentCible;
	}

}
