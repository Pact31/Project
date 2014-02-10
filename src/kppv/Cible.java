package kppv;


public class Cible {
	
	private String syllabe;
	private int compteur;

	public String getSyllabe() {
		return syllabe;
	}

	public void setSyllabe(String syllabe) {
		this.syllabe = syllabe;
	}
	
	public int getCompteur() {
		return compteur;
	}
	
	public void setCompteur(int compteur){
		this.compteur=compteur;
	}
	
	public int compareSyllabe(String syllabe){
		return this.syllabe.compareTo(syllabe);
	}

}
