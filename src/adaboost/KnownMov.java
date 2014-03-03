package adaboost;

public class KnownMov {
	private Mouvement mov;
	private int classe;
	
	public KnownMov(Mouvement mov, int value) {
		this.mov = mov;
		if(value >=0){
			this.classe=1;
		}
		else{
			this.classe=-1;
		}
	}

	public Mouvement getMov() {
		return mov;
	}

	public int getClasse() {
		return classe;
	}
	
	

}
