package classif.adaboost;

import classif.Apprentissage;
import classif.Cible;

public class KnownMov {
	private Mouvement mov;
	private int classe;
	
	public KnownMov(Apprentissage a) {
		this.mov = new Mouvement(a);
		
		if(a.getCible()==Cible.PDJ){
			this.classe=0;
		}
		else if (a.getCible()==Cible.KVZ){
			this.classe=1;
		}
		else if (a.getCible()==Cible.SR){
			this.classe=2;
		}
		else if (a.getCible()==Cible.BNUI){
			this.classe=3;
		}
		else if (a.getCible()==Cible.MTF){
			this.classe=4;
		}
		else if (a.getCible()==Cible.ICHGNW){
			this.classe=5;
		}
		else if (a.getCible()==Cible.G){
			this.classe=6;
		}
		else if (a.getCible()==Cible.YNG){
			this.classe=7;
		}
	}

	public Mouvement getMov() {
		return mov;
	}

	public int getClasse() {
		return this.classe;
	}
	

}
