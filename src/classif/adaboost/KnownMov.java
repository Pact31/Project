package classif.adaboost;

import classif.Apprentissage;
import classif.Cible;

public class KnownMov {
	private Mouvement mov;
	private int classe;
	
	public KnownMov(Apprentissage a) {
		this.mov = new Mouvement(a);
		
		if(a.getCible()==Cible.PDJ_G){
			this.classe=0;
		}
		else if (a.getCible()==Cible.KVZ_G){
			this.classe=1;
		}
		else if (a.getCible()==Cible.SR_G){
			this.classe=2;
		}
		else if (a.getCible()==Cible.BNUI_G){
			this.classe=3;
		}
		else if (a.getCible()==Cible.MTF_G){
			this.classe=4;
		}
		else if (a.getCible()==Cible.ICHGNW_G){
			this.classe=5;
		}
		else if (a.getCible()==Cible.G_G){
			this.classe=6;
		}
		else if (a.getCible()==Cible.YNG_G){
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
