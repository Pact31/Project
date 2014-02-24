package kppv;

public class Kppv {
	
	private BanqueApprentissage banque;
	private int k; 
	
	public Kppv(BanqueApprentissage banque, int k){
		this.banque=banque;
		this.k=k;
	}
	

	
	public int getDistance(Apprentissage element, Entree entree){

		return (entree.getD1().getDistance(element.getD1())
				+entree.getD2().getDistance(element.getD2())
				+entree.getD3().getDistance(element.getD3())
				+entree.getD4().getDistance(element.getD4())
				+entree.getD5().getDistance(element.getD5())
				+entree.getM().getDistance(element.getM()));

	}
	
	
	public Voisins getVoisins(Entree entree){

		Voisins v=new Voisins();
		Distances d=new Distances();
		int dist = 1000;
		int indiceDist=0;

		for (int i=0; i<this.k; i++){
			v.add(banque.getApprentissage(i));
			d.add(this.getDistance(banque.getApprentissage(i),entree));
		}

		for (int i=k; i<this.banque.size(); i++){
			indiceDist=d.indiceLePlusPres();
			dist=d.get(indiceDist);
			if(this.getDistance(banque.getApprentissage(i),entree)<dist){
				v.set(indiceDist,banque.getApprentissage(i));
				d.set(indiceDist,this.getDistance(banque.getApprentissage(i),entree));
			}
		}
		return v;
	}
	

	public TableauCibles countCible(Entree entree){
		Cible pivot;
		Voisins v=this.getVoisins(entree);
		TableauCibles t=this.banque.getAllCibles();
		for (int i=0;i<v.size();i++){

			int k=0;
			pivot = v.get(i).getCible();
			while(pivot.compareSyllabe(t.get(k).getSyllabe())!=0){
				k=k+1;
			}
			t.get(k).setCompteur(t.get(k).getCompteur()+1);
			t.set(k,t.get(k));
		}
		return t;
	}
	

	public String kppv(Entree entree){
		TableauCibles t = this.countCible(entree);
		int pivot = 1000;
		int indice = 0;
		for (int i=0;i<t.size();i=i+1){
			if (t.get(i).getCompteur()<pivot){
				pivot=t.get(i).getCompteur();
				indice=i;
			}
		}
		return t.get(indice).getSyllabe();
	}



}
