package kppv;

/*Cette classe est celle des éléments que nous appellerons Apprentissage de la base de données */

public class Apprentissage extends Entree {
	
	/*Mêmes attributs que les éléments de la classe Entrée plus un attribut cible qui permet de réaliser l'association donnée-syllabe */
	private Cible cible;
	
	/*Constructeur de classe*/
	public Apprentissage(Vertex d1, Vertex d2, Vertex d3, Vertex d4, Vertex d5, Point m,int k, Cible cible){
		super(d1,d2,d3,d4,d5,m,k);
		this.cible=cible;
	}
	
	/*renvoie la cible de l'élément de la base de données*/
	public Cible getCible(){
		return cible;
	}
}
