package integration;

import java.io.File;

import LeapTS.FrameTS;
<<<<<<< HEAD:src/Start.java
=======

import classif.adaboost.Adaboost;
>>>>>>> pactHub/Adaboost2:src/integration/Start.java
import affichage.model.DrawingAppModel;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;

import synthese.Sound;
import classif.Cible;
<<<<<<< HEAD:src/Start.java
import classif.ClassificateurInterface;
=======
>>>>>>> pactHub/Adaboost2:src/integration/Start.java
import classif.Entree;


public class Start {

<<<<<<< HEAD:src/Start.java
	public static void start(ClassificateurInterface c, DrawingAppModel model) throws Exception{//fonction à exécuter par l'interface graphique à chaque pression sur le boutton Start
<<<<<<< HEAD:src/integration/Start.java
=======
	public static void start(Adaboost a, DrawingAppModel model) throws Exception{//fonction à exécuter par l'interface graphique à chaque pression sur le boutton Start
		
>>>>>>> pactHub/Adaboost2:src/integration/Start.java
		System.out.println("Début de la séquence de traduction!");
=======
		System.out.println("Debut de la sequence de traduction!");
>>>>>>> pactHub/hassen:src/Start.java
		
		Controller controller = new Controller(); //ces quatre preimères lignes permettent d'acquérir une nouvelle Entree 
		Frame frame = controller.frame();
		FrameTS framets = new FrameTS(frame);
		Entree e = new Entree(framets);
		
		System.out.println("Une nouvelle entree a ete creee!");
		
<<<<<<< HEAD:src/Start.java
		Cible cible = c.classifier(e);//on trouve la classe asociée à l'entrée
=======
		Cible cible = a.classifier(e);//on trouve la classe asociée à l'entrée
>>>>>>> pactHub/Adaboost2:src/integration/Start.java
				
		System.out.println("La cible detectee est :"+cible);
		
		String s = "";
		
		if(cible==Cible.PDJ_G){//cette suite de if permet de transformer la cible en String
			s= "di";
		}
<<<<<<< HEAD:src/integration/Start.java
		else if(cible==Cible.KVZ){
			s= "zeu(bleu)";
		}
		else if(cible==Cible.SR){
			s= "so(seau)";
=======
		else if(cible==Cible.KVZ_G){
			s= "zeu(renaitre)";
		}
		else if(cible==Cible.SR_G){
			s= "so(sol)";
>>>>>>> pactHub/hassen:src/Start.java
		}
		else if(cible==Cible.BNUI_G){
			s= "bi";
		}
		else if(cible==Cible.MTF_G){
			s= "teu";
		}
		else if(cible==Cible.ICHGNW_G){
			s= "cha(court)";
		}
<<<<<<< HEAD:src/integration/Start.java
		else if(cible==Cible.G){
			s= "geu(bleu)";
=======
		else if(cible==Cible.G_G){
			s= "geu(renaitre)";
>>>>>>> pactHub/hassen:src/Start.java
		}
		else if(cible==Cible.YNG_G){
			s= "ping";
		}
		
		if(s==""){
			throw new Exception();
		}
		
		String fileName = "data/"+s+".wav";//sera le nom du fichier joue
		
		System.out.println("Le fichier son qui va etre joue est : "+fileName);
		
		File file = new File(fileName);//on verifie si le fichier existe
        System.out.println(file.exists());
        
        model.setCurrentMessage("La syllabe reconnue est : "+s);//le message est affiche sur l'interface graphique
        
        Thread song = new Sound(fileName);
        
        song.run();//le son est joue
        
        System.out.println("Fin de la sequence de detection!");
        
	}
	
}
