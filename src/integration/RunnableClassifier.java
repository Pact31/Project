package integration;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

import com.leapmotion.leap.Frame;

import LeapTS.FrameTS;
import affichage.model.DrawingAppModel;

import classif.Cible;
import classif.Classificateur;
import classif.Entree;


public class RunnableClassifier extends Thread{
	
	private int N;
	private Classificateur classif;
	private LinkedBlockingQueue <Entree> chain;
	private DrawingAppModel model;
	private ArrayList<String> syllabes;
	//private String[][] correspondances;
	private Dictionnary dico;
	private LinkedBlockingQueue<String> writingQueue;
	private boolean usingLog;
	private Date date;
	private String logMsg;

	public RunnableClassifier(int n, Classificateur c, LinkedBlockingQueue<Entree> chain, DrawingAppModel model) {
		super();
		this.date = new Date();
		this.logMsg = "";
		this.usingLog = true;
		this.N = n;
		this.classif = c;
		this.chain = chain;
		this.model = model;
		this.syllabes = new ArrayList<String>();
		/*this.correspondances = new String[8][5];
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
		this.correspondances[7][4]="yu";*/
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {//il faut modifier ce param en fonction du mot qu'on veut déchiffrer!! (correspond au nombre de syllabes)
		N = n;
	}
	
	public void setDico(Dictionnary dico){//il faut refaire setDico à chaque fois qu'on choisit un nouveau mot
		this.dico = dico;
	}
	
	public void setLogUse(boolean b){//vaut true si on utilise le système de log, init à true par défaut (voir constructeur)
		this.usingLog = b;
	}

	public Classificateur getClassif() {
		return classif;
	}

	public void setClassif(Classificateur c) {//utilisée pour changer le classificateur (choisir entre kppv et adaboost)
		this.classif = c;
	}

	public void setChain(LinkedBlockingQueue<Entree> chain) {//côté "consammateur" de la file
		this.chain = chain;
	}
	
	public void setWriterchain(LinkedBlockingQueue<String> writingQueue){//pour le fichier de log
		this.writingQueue = writingQueue;
	}
	
	private String getSyllabe (Cible c){//trouve la syllabe dans le dico qui correspond à la cible
		int temp = c.ordinal();
		int forme = temp/5;
		int main = 5-(temp%5);
		//return this.correspondances[forme][main];
		return this.dico.get(forme, main);
	}
	
	public void run() {
		
		if(this.usingLog){
			this.date = new Date();//ce type de bloc de code est utilisé pour imprimer quelque chose dans le fichier de log 
			this.logMsg = this.date.toString() + "   Classifier : Begining run sequence";
			try {
				this.writingQueue.put(this.logMsg);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
		}
		
		this.syllabes = new ArrayList<String>();
		String mot = "";
		for(int i = 0; i<N; i++){
			
			if(this.usingLog){
				this.date = new Date();//idem, impression dans le fichier de log
				this.logMsg = this.date.toString() + "   Classifier : Begining translation sequence, trying to get a movement from the queue";
				try {
					this.writingQueue.put(this.logMsg);
				} catch (InterruptedException e2) {
					e2.printStackTrace();
				}
			}
			
			Entree e = new Entree(new FrameTS(new Frame()));
			try {
				e = this.chain.take();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			if(this.usingLog){
				this.date = new Date();//idem, impression dans le fichier de log 
				this.logMsg = this.date.toString() + "   Classifier : Movement acquired, trying to classify";
				try {
					this.writingQueue.put(this.logMsg);
				} catch (InterruptedException e2) {
					e2.printStackTrace();
				}
			}
			
			Cible c = this.classif.classifier(e);
			String s = getSyllabe(c);
			this.syllabes.add(s);
			mot = mot + s;
			
			if(this.usingLog){
				this.date = new Date();//idem, impression dans le fichier de log 
				this.logMsg = this.date.toString() + "   Classifier : Classification done, the syllable was : "+s+". End of round : "+(i+1);
				try {
					this.writingQueue.put(this.logMsg);
				} catch (InterruptedException e2) {
					e2.printStackTrace();
				}
			}
		}
		
		if(this.usingLog){
			this.date = new Date();//idem, impression dans le fichier de log 
			this.logMsg = this.date.toString() + "   Classifier : Translation sequence completed, showing word on the screen : "+ mot;
			try {
				this.writingQueue.put(this.logMsg);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
		}

		this.model.setCurrentMessage(mot);
		
		if(this.usingLog){
			this.date = new Date();//idem, impression dans le fichier de log 
			this.logMsg = this.date.toString() + "   Classifier : Word is on screen, about to play the sound";
			try {
				this.writingQueue.put(this.logMsg);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
		}

		//ajouter methode pour jouer le son associé au ArrayList 
		
		if(this.usingLog){
			this.date = new Date();//idem, impression dans le fichier de log 
			this.logMsg = this.date.toString() + "   Classifier : Sound played, ending run sequence";
			try {
				this.writingQueue.put(this.logMsg);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
		}
	}
}
