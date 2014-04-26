package integration;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

import classif.Entree;


public class StartCont {

	
	public static void start (RunnableClassifier classif, RunnableLeap leap, RunnableLogWriter writer, boolean useLog, int N){
		
		if(useLog){
			Date date = new Date();
			writer.setDate();
			//ce type de bloc de code est utilisé pour imprimer quelque chose dans le fichier de log 
			String logMsg = date.toString() + "   Start : Begining of translation sequence, number of syllables to translate : "+ classif.getN();
			try {
				writer.getWriter().write(logMsg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		classif.setLogUse(useLog);
		leap.setLogUse(useLog);
		classif.setN(N);
		LinkedBlockingQueue<Entree> chain = new LinkedBlockingQueue<Entree>(N);
		leap.setN(N);
		writer.setN(N);
		leap.setChain(chain);
		classif.setChain(chain);
		classif.setWriterchain(writer.getWritingQueue());
		leap.setWriterchain(writer.getWritingQueue());
		
		if(useLog){
			Date date1 = new Date();//idem, impression dans le fichier de log
			String logMsg1 = date1.toString() + "   Start : Init Complete, starting run sequence";
			try {
				writer.getWriter().write(logMsg1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(useLog){
			writer.run();
		}
		
		leap.run();
		classif.run();
	}
	
}
