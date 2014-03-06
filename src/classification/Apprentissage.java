package classification;



/*Cette classe est celle des elements que nous appellerons Apprentissage de la base de donnees */

public class Apprentissage extends Entree {
	
	/*Memes attributs que les elements de la classe Entree plus un attribut cible qui permet de realiser l'association donn√e-syllabe */
	private Cible cible;
	
	/*Constructeur de classe*/
	public Apprentissage(Vertex d1, Vertex d2, Vertex d3, Vertex d4, Vertex d5, Point m, Cible cible){
		super(d1,d2,d3,d4,d5,m);
		this.cible=cible;
	}
	
	/*renvoie la cible de l'element de la base de donnees*/
	public Cible getCible(){
		return cible;
	}
}
