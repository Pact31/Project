package kppv;


public class Entree {

	private Vertex d1;
	private Vertex d2;
	private Vertex d3;
	private Vertex d4;
	private Vertex d5;
	private Point m;
	private BanqueApprentissage banque;
	private int k;



	public Entree(Vertex d1, Vertex d2, Vertex d3, Vertex d4, Vertex d5, Point m, int k ){

		this.d1=d1;
		this.d2=d2;
		this.d3=d3;
		this.d4=d4;
		this.d5=d5;
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

	public int getDistance(Apprentissage element){

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
	
	public Cible getCible(){
		
		TableauCibles c=new TableauCibles();
		Voisins v=this.getVoisins();
		for (int i=0;i<v.size();i++){
			if (c.add(v.get(i).getCible());
		}
		
		
	}

}
