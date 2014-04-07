package integration;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import com.leapmotion.leap.Frame;

import LeapTS.FrameTS;
import affichage.model.DrawingAppModel;

import classif.Cible;
import classif.Classificateur;
import classif.Entree;


public class RunnableClassifier extends Thread{
	
	private int N;
	private Classificateur c;
	private LinkedBlockingQueue <Entree> chain;
	private DrawingAppModel model;
	private ArrayList<String> syllabes;
	private String[][] correspondances;

	public RunnableClassifier(int n, Classificateur c, LinkedBlockingQueue<Entree> chain, DrawingAppModel model) {
		super();
		N = n;
		this.c = c;
		this.chain = chain;
		this.model = model;
		this.syllabes = new ArrayList<String>();
		this.correspondances = new String[8][5];
		this.correspondances[0][0]="";
		this.correspondances[0][1]="";
		this.correspondances[0][2]="";
		this.correspondances[0][3]="";
		this.correspondances[0][4]="";
		this.correspondances[1][0]="";
		this.correspondances[1][1]="";
		this.correspondances[1][2]="";
		this.correspondances[1][3]="";
		this.correspondances[1][4]="";
		this.correspondances[2][0]="";
		this.correspondances[2][1]="";
		this.correspondances[2][2]="";
		this.correspondances[2][3]="";
		this.correspondances[2][4]="";
		this.correspondances[3][0]="";
		this.correspondances[3][1]="";
		this.correspondances[3][2]="";
		this.correspondances[3][3]="";
		this.correspondances[3][4]="";
		this.correspondances[4][0]="";
		this.correspondances[4][1]="";
		this.correspondances[4][2]="";
		this.correspondances[4][3]="";
		this.correspondances[4][4]="";
		this.correspondances[5][0]="";
		this.correspondances[5][1]="";
		this.correspondances[5][2]="";
		this.correspondances[5][3]="";
		this.correspondances[5][4]="";
		this.correspondances[6][0]="";
		this.correspondances[6][1]="";
		this.correspondances[6][2]="";
		this.correspondances[6][3]="";
		this.correspondances[6][4]="";
		this.correspondances[7][0]="";
		this.correspondances[7][1]="";
		this.correspondances[7][2]="";
		this.correspondances[7][3]="";
		this.correspondances[7][4]="";
		//ajouter les syllabes
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

	public Classificateur getC() {
		return c;
	}

	public void setC(Classificateur c) {
		this.c = c;
	}

	public void setChain(LinkedBlockingQueue<Entree> chain) {
		this.chain = chain;
	}
	
	private String getSyllabe (Cible c1, Cible c2){
		int forme = c1.ordinal();
		int main = c2.ordinal();
		return this.correspondances[forme][main];
	}
	
	public void run() {
		this.syllabes = new ArrayList<String>();
		String mot = "";
		for(int i = 0; i<N; i++){
			Entree e = new Entree(new FrameTS(new Frame()));
			try {
				e = this.chain.take();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			Cible c = this.c.classifier(e);//rajouter méthode pour la deuxième cible
			String s = getSyllabe(c, c);//remplacer la deuxième cible par celle pour la position de la main
			this.syllabes.add(s);
			if(i==0){
				mot = s;
			}
			else{
				mot = mot + "-" + s;
			}
		}
		this.model.setCurrentMessage(mot);
		//ajouter methode pour jouer le son associé au ArrayList 
	}

}
