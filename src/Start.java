import java.io.File;

import LeapTS.FrameTS;
import affichage.model.DrawingAppModel;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;

import synthese.Sound;
import classif.Cible;
import classif.ClassificateurInterface;
import classif.Entree;


public class Start {

	public static void start(ClassificateurInterface c, DrawingAppModel model) throws Exception{//fonction à exécuter par l'interface graphique à chaque pression sur le boutton Start
		System.out.println("Debut de la sequence de traduction!");
		
		Controller controller = new Controller(); //ces quatre preimères lignes permettent d'acquérir une nouvelle Entree 
		Frame frame = controller.frame();
		FrameTS framets = new FrameTS(frame);
		Entree e = new Entree(framets);
		
		System.out.println("Une nouvelle entree a ete creee!");
		
		Cible cible = c.classifier(e);//on trouve la classe asociée à l'entrée
				
		System.out.println("La cible detectee est :"+cible);
		
		String s = "";
		
		if(cible==Cible.PDJ){//cette suite de if permet de transformer la cible en String
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
