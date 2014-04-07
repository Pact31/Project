package integration;

import java.util.concurrent.LinkedBlockingQueue;

import classif.Entree;


public class StartCont {

	
	public static void start (RunnableClassifier c, RunnableLeap leap){
		LinkedBlockingQueue<Entree> chain = new LinkedBlockingQueue<Entree>(c.getN());
		leap.setN(c.getN());
		leap.setChain(chain);
		c.setChain(chain);
		leap.run();
		c.run();
	}
	
}
