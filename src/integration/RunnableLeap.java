package integration;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

import affichage.model.DrawingAppModel;

import classif.Entree;

import com.leapmotion.leap.Controller;


public class RunnableLeap extends Thread{

	private Controller control;//remplacer le controlleur par la classe qui implémente la méthode faisant la moyenne des position
	private int N;
	private LinkedBlockingQueue<Entree> chain;
	private LinkedBlockingQueue<String> writingQueue;
	private int meanTimeNum;
	private int waitTimeNum;
	private long meanTime;
	private long waitTime;
	private DrawingAppModel model;

	public RunnableLeap(Controller control, int n, LinkedBlockingQueue<Entree> chain, DrawingAppModel model) {
		super();
		this.control = control;
		N = n;
		this.chain = chain;
		this.model = model;
		this.setMeanTimeNum(1);
		this.setWaitTimeNum(1);
	}

	public void setN(int n) {
		N = n;
	}

	public void setMeanTimeNum(int meanTimeNum) {
		this.meanTimeNum = meanTimeNum;
		if(this.meanTimeNum == 1){
			this.meanTime = 1000;
		}
		else if(this.meanTimeNum == 2){
			this.meanTime = 2000;
		}
		else{
			this.meanTime = 3000;
		}
	}

	public void setWaitTimeNum(int waitTimeNum) {
		this.waitTimeNum = waitTimeNum;
		if(this.waitTimeNum == 1){
			this.waitTime = 1000;
		}
		else if(this.waitTimeNum == 2){
			this.waitTime = 2000;
		}
		else{
			this.waitTime = 3000;
		}
	}

	public void setChain(LinkedBlockingQueue<Entree> chain) {
		this.chain = chain;
	}
	
	public void setWriterchain(LinkedBlockingQueue<String> writingQueue){
		this.writingQueue = writingQueue;
	}

	public void run() {
		
		Date date = new Date();//ce type de bloc de code est utilisé pour imprimer quelque chose dans le fichier de log  
		String logMsg = date.toString() + "   Leap : Begining run sequence";
		try {
			this.writingQueue.put(logMsg);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		
		for(int i=0; i<this.N; i++){
			
			date = new Date();//idem, impression dans le fichier de log
			logMsg = date.toString() + "   Leap : Begining sleep";
			try {
				this.writingQueue.put(logMsg);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			
			
			try {
				sleep(this.waitTime);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			
			date = new Date();//idem, impression dans le fichier de log
			logMsg = date.toString() + "   Leap : Wake up and start capturing";
			try {
				this.writingQueue.put(logMsg);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			
			
			//rajouter ici commande sur model pour faire passer le voyant au vert
			Entree e = new Entree(this.control);//remplacer par le code pour faire la moyenne ou autre méthode d'aquisition
			//rajouter ici commande sur model pour faire passer le voyant au rouge
			
			
			date = new Date();//idem, impression dans le fichier de log 
			logMsg = date.toString() + "   Leap : New movement captured, will try to put it in queue";
			try {
				this.writingQueue.put(logMsg);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			
			
			try {
				this.chain.put(e);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			i++;
			
			
			date = new Date();//idem, impression dans le fichier de log 
			logMsg = date.toString() + "   Leap : Movement succesfully placed in queue, end of round : "+ (i+1);
			try {
				this.writingQueue.put(logMsg);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
		}
		
		
		date = new Date();//idem, impression dans le fichier de log 
		logMsg = date.toString() + "   Leap : Ending run sequence";
		try {
			this.writingQueue.put(logMsg);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		
		
	}


}
