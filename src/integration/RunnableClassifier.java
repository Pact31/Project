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
		this.correspondances[0][0]="deu";
		this.correspondances[0][1]="da";
		this.correspondances[0][2]="di";
		this.correspondances[0][3]="do";
		this.correspondances[0][4]="du";
		this.correspondances[1][0]="zeu";
		this.correspondances[1][1]="za";
		this.correspondances[1][2]="zi";
		this.correspondances[1][3]="zo";
		this.correspondances[1][4]="zu";
		this.correspondances[2][0]="seu";
		this.correspondances[2][1]="sa";
		this.correspondances[2][2]="si";
		this.correspondances[2][3]="so";
		this.correspondances[2][4]="su";
		this.correspondances[3][0]="beu";
		this.correspondances[3][1]="ba";
		this.correspondances[3][2]="bi";
		this.correspondances[3][3]="bo";
		this.correspondances[3][4]="bu";
		this.correspondances[4][0]="teu";
		this.correspondances[4][1]="ta";
		this.correspondances[4][2]="ti";
		this.correspondances[4][3]="to";
		this.correspondances[4][4]="tu";
		this.correspondances[5][0]="cheu";
		this.correspondances[5][1]="cha";
		this.correspondances[5][2]="chi";
		this.correspondances[5][3]="cho";
		this.correspondances[5][4]="chu";
		this.correspondances[6][0]="gueu";
		this.correspondances[6][1]="ga";
		this.correspondances[6][2]="gui";
		this.correspondances[6][3]="go";
		this.correspondances[6][4]="gu";
		this.correspondances[7][0]="yeu";
		this.correspondances[7][1]="ya";
		this.correspondances[7][2]="yi";
		this.correspondances[7][3]="yo";
		this.correspondances[7][4]="yu";
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
			mot = mot + s;
			
		}
		this.model.setCurrentMessage(mot);
		//ajouter methode pour jouer le son associé au ArrayList 
	}

}
