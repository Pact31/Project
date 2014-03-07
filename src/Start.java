import java.io.File;

import LeapTS.FrameTS;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;

import synthese.Sound;
import classif.ClassifierInterface;
import classif.classification.Cible;
import classif.classification.Entree;


public class Start {

	public static void start(ClassifierInterface c) throws Exception{
		System.out.println("Début de la séquence de traduction!");
		
		Controller controller = new Controller();
		Frame frame = controller.frame();
		FrameTS framets = new FrameTS(frame);
		Entree e = new Entree(framets);
		
		System.out.println("Une nouvelle entrée a été crée!");
		
		Cible cible = c.predict(e);
				
		System.out.println("La cible détéctée est :"+cible);
		
		String s = "";
		
		if(cible==Cible.PDJ){
			s= "di";
		}
		else if(cible==Cible.KVZ){
			s= "zeu(renaitre)";
		}
		else if(cible==Cible.SR){
			s= "so(sol)";
		}
		else if(cible==Cible.BNUI){
			s= "bi";
		}
		else if(cible==Cible.MTF){
			s= "teu";
		}
		else if(cible==Cible.ICHGNW){
			s= "cha(court)";
		}
		else if(cible==Cible.G){
			s= "geu(renaitre)";
		}
		else if(cible==Cible.YNG){
			s= "ping";
		}
		
		if(s==""){
			throw new Exception();
		}
		
		String fileName = "/data"+s+".wav";
		
		System.out.println("Le fichier son qui va être joué est : "+fileName);
		
		File file = new File(fileName);
        System.out.println(file.exists());
        
        
        
        Thread song = new Sound(fileName);
        song.run();
        
        System.out.println("Fin de la séquence de détection!");
        
	}
	
}
