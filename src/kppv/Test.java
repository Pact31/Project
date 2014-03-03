package kppv;

import classification.Apprentissage;
import classification.BanqueApprentissage;
import classification.Cible;
import classification.Entree;
import classification.Point;
import classification.Vertex;

public class Test {

		public static void main(String[] args) {

		BanqueApprentissage banque = new BanqueApprentissage();
		
		Point  p0  = new Point  (0,0,0);
		
		Vertex d0  = new Vertex (0,0,0);
		Vertex d111 = new Vertex (10,10,10);
		Vertex d121 = new Vertex (9,10,11);
		Vertex d131 = new Vertex (10,11,10);
		Vertex d141 = new Vertex (11,9,10);
		Vertex d211 = new Vertex (8,10,11);
		Vertex d221 = new Vertex (9,10,10);
		Vertex d231 = new Vertex (10,10,10);
		Vertex d241 = new Vertex (11,10,9);
		Vertex d311 = new Vertex (11,10,10);
		Vertex d321 = new Vertex (10,10,10);
		Vertex d331 = new Vertex (11,9,10);
		Vertex d341 = new Vertex (10,10,11);
		Vertex d112 = new Vertex (20,20,20);
		Vertex d122 = new Vertex (21,22,19);
		Vertex d132 = new Vertex (20,19,21);
		Vertex d142 = new Vertex (21,21,21);
		Vertex d212 = new Vertex (19,19,19);
		Vertex d222 = new Vertex (20,20,20);
		Vertex d232 = new Vertex (19,20,19);
		Vertex d242 = new Vertex (19,20,21);
		Vertex d312 = new Vertex (19,19,21);
		Vertex d322 = new Vertex (19,20,21);
		Vertex d332 = new Vertex (21,21,19);
		Vertex d342 = new Vertex (19,21,21);
		Vertex d113 = new Vertex (30,31,30);
		Vertex d123 = new Vertex (30,30,30);
		Vertex d133 = new Vertex (30,30,31);
		Vertex d143 = new Vertex (30,31,31);
		Vertex d213 = new Vertex (32,31,30);
		Vertex d223 = new Vertex (29,29,29);
		Vertex d233 = new Vertex (30,30,30);
		Vertex d243 = new Vertex (31,31,31);
		Vertex d313 = new Vertex (30,32,29);
		Vertex d323 = new Vertex (29,29,29);
		Vertex d333 = new Vertex (30,30,30);
		Vertex d343 = new Vertex (29,30,30);
		
		/*Cible c1 = new Cible("la");
		Cible c2 = new Cible("mai");
		Cible c3 = new Cible("son");*/

		

		Apprentissage a11 =  new Apprentissage( d111,d211,d311,d0,d0,p0,Cible.values()[1]);
		Apprentissage a12 =  new Apprentissage( d121,d221,d321,d0,d0,p0,Cible.values()[1]);
		Apprentissage a13 =  new Apprentissage( d131,d231,d331,d0,d0,p0,Cible.values()[1]);
		Apprentissage a14 =  new Apprentissage( d141,d241,d341,d0,d0,p0,Cible.values()[1]);
		Apprentissage a21 =  new Apprentissage( d112,d212,d312,d0,d0,p0,Cible.values()[2]);
		Apprentissage a22 =  new Apprentissage( d122,d222,d322,d0,d0,p0,Cible.values()[2]);
		Apprentissage a23 =  new Apprentissage( d132,d232,d332,d0,d0,p0,Cible.values()[2]);
		Apprentissage a24 =  new Apprentissage( d142,d242,d342,d0,d0,p0,Cible.values()[2]);
		Apprentissage a31 =  new Apprentissage( d113,d213,d313,d0,d0,p0,Cible.values()[3]);
		Apprentissage a32 =  new Apprentissage( d123,d223,d323,d0,d0,p0,Cible.values()[3]);
		Apprentissage a33 =  new Apprentissage( d133,d233,d333,d0,d0,p0,Cible.values()[3]);
		Apprentissage a34 =  new Apprentissage( d143,d243,d343,d0,d0,p0,Cible.values()[3]);
		
		banque.addApprentissage(a11);
		banque.addApprentissage(a12);
		banque.addApprentissage(a13);
		banque.addApprentissage(a14);
		banque.addApprentissage(a21);
		banque.addApprentissage(a22);
		banque.addApprentissage(a23);
		banque.addApprentissage(a24);
		banque.addApprentissage(a31);
		banque.addApprentissage(a32);
		banque.addApprentissage(a33);
		banque.addApprentissage(a34);
		
		Entree entree = new Entree(d143,d243,d343,d0,d0,p0);
		
		Kppv classificateur = new Kppv(banque,3);
		System.out.println(classificateur.kppv(entree));
		

	}




}
