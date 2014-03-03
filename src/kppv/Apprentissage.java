package kppv;

public class Apprentissage extends Entree {
	
	private Cible cible;
	private BanqueApprentissage banque;
	
	public Apprentissage(Vertex d1, Vertex d2, Vertex d3, Vertex d4, Vertex d5, Point m,int k, Cible cible){
		super(d1,d2,d3,d4,d5,m,k);
		this.cible=cible;
	}
	
	public Cible getCible(){
		return cible;
	}
	
	

}
