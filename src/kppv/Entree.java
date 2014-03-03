package kppv;



public class Entree {

	
	private Vertex d1;
	private Vertex d2;
	private Vertex d3;
	private Vertex d4;
	private Vertex d5;
	private Point m;
	

	public Entree(Vertex d1, Vertex d2, Vertex d3, Vertex d4, Vertex d5, Point m){

		this.d1=d1;
		this.d2=d2;
		this.d3=d3;
		this.d4=d4;
		this.d5=d5;
		this.m=m;
		

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

	
	public Cible getCible(){
		
		/*Voisins v=this.getVoisins();
		TableauCibles t=this.banque.getAllCibles();
		for (int i=0;i<v.size();i++){
			
		}*/
				
		return null;
	}

}
