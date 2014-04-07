package integration;

import java.util.concurrent.LinkedBlockingQueue;

import LeapTS.FrameTS;
import affichage.model.DrawingAppModel;

import classif.Entree;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;


public class RunnableLeap extends Thread{

	private Controller control;//remplacer le controlleur par la classe qui implémente la méthode faisant la moyenne des position
	private int N;
	private LinkedBlockingQueue<Entree> chain;
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

	public void run() {
		for(int i=0; i<this.N; i++){
			try {
				sleep(this.waitTime);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			//rajouter ici commande sur model pour faire passer le voyant au vert
			Entree e = new Entree(this.control);//remplacer par le code pour faire la moyenne ou autre méthode d'aquisition
			//rajouter ici commandesur model pour faire passer le voyant au rouge
			try {
				this.chain.put(e);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			i++;
		}
		
	}


}
