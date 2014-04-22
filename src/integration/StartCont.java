package integration;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

import classif.Entree;


public class StartCont {

	
	public static void start (RunnableClassifier c, RunnableLeap leap, RunnableLogWriter writer){
		
		
		Date date = new Date();//ce type de bloc de code est utilisé pour imprimer quelque chose dans le fichier de log 
		String logMsg = date.toString() + "   Start : Begining of translation sequence, number of syllables to translate : "+ c.getN();
		try {
			writer.getWriter().write(logMsg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		LinkedBlockingQueue<Entree> chain = new LinkedBlockingQueue<Entree>(c.getN());
		leap.setN(c.getN());
		leap.setChain(chain);
		c.setChain(chain);
		c.setWriterchain(writer.getWritingQueue());
		leap.setWriterchain(writer.getWritingQueue());
		
		
		date = new Date();//idem, impression dans le fichier de log
		logMsg = date.toString() + "   Start : Init Complete, starting run sequence";
		try {
			writer.getWriter().write(logMsg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		writer.run();
		leap.run();
		c.run();
	}
	
}
