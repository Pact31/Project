package kppv;
//<<<<<<< HEAD
/*
=======
import leapmotion.*;
>>>>>>> hassen


public class Entree {

<<<<<<< HEAD
	
=======
	private SampleListener samplelistner;
>>>>>>> hassen
	private Vertex d1;
	private Vertex d2;
	private Vertex d3;
	private Vertex d4;
	private Vertex d5;
	private Point m;
	private BanqueApprentissage banque;
	private int k;



	public Entree(Vertex d1, Vertex d2, Vertex d3, Vertex d4, Vertex d5, Point m, int k ){

		this.d1=(Vertex)samplelistner.VecteurDonnées().get(0);
		this.d2=(Vertex)samplelistner.VecteurDonnées().get(1);
		this.d3=(Vertex)samplelistner.VecteurDonnées().get(2);
		this.d4=(Vertex)samplelistner.VecteurDonnées().get(3);
		this.d5=(Vertex)samplelistner.VecteurDonnées().get(4);
		this.m=m;
		this.k=k;

	}

	public void setK(int k){
		this.k=k;
	}

	public Vertex getD1() {
		return d1;
	}

	public Vertex getD2() {
		return d2;
	}
	public Vertex getD3() {
		return d3;
	}
	public Vertex getD4() {
		return d4;
	}
	public Vertex getD5() {
		return d5;
	}
	public Point getM(){
		return m;
	}

	public double getDistance(Apprentissage element){

		return (this.d1.getDistance(element.getD1())
				+this.d2.getDistance(element.getD2())
				+this.d3.getDistance(element.getD3())
				+this.d4.getDistance(element.getD4())
				+this.d5.getDistance(element.getD5())
				+this.m.getDistance(element.getM()));

	}

	public Voisins getVoisins(){

		Voisins v=new Voisins();
		Distances d=new Distances();
		int dist = 1000;
		int indiceDist=0;

		for (int i=0; i<this.k; i++){
			v.add(banque.getApprentissage(i));
			d.add(this.getDistance(banque.getApprentissage(i)));
		}

		for (int i=k; i<this.banque.size(); i++){
			indiceDist=d.indiceLePlusPres();
			dist=d.get(indiceDist);
			if(this.getDistance(banque.getApprentissage(i))<dist){
				v.set(indiceDist,banque.getApprentissage(i));
				d.set(indiceDist,this.getDistance(banque.getApprentissage(i)));
			}
		}
		return v;
	}

	public TableauCibles countCible(){
		Cible pivot;
		Voisins v=this.getVoisins();
		TableauCibles t=this.banque.getAllCibles();
		for (int i=0;i<v.size();i++){
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> hassen
			int k=0;
			pivot = v.get(i).getCible();
			while(pivot.compareSyllabe(t.get(k).getSyllabe())!=0){
				k=k+1;
			}
			t.get(k).setCompteur(t.get(k).getCompteur()+1);
			t.set(k,t.get(k));
		}
		return t;
<<<<<<< HEAD
=======
			
		}
				
		return null;
>>>>>>> refs/remotes/origin/xgan_ui
	}
=======

			
		}

>>>>>>> hassen

	public String associeSyllabe(){
		TableauCibles t = this.countCible();
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
*/
