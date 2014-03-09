import java.io.File;

import LeapTS.FrameTS;

import adaboost.Adaboost;
import affichage.model.DrawingAppModel;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;

import synthese.Sound;
import classification.Cible;
import classification.Entree;


public class Start {

	public static void start(Adaboost a, DrawingAppModel model) throws Exception{//fonction à exécuter par l'interface graphique à chaque pression sur le boutton Start
		
		System.out.println("Début de la séquence de traduction!");
		
		Controller controller = new Controller(); //ces quatre preimères lignes permettent d'acquérir une nouvelle Entree 
		Frame frame = controller.frame();
		FrameTS framets = new FrameTS(frame);
		Entree e = new Entree(framets);
		
		System.out.println("Une nouvelle entrée a été crée!");
		
		Cible cible = a.predict(e);//on trouve la classe asociée à l'entrée
				
		System.out.println("La cible détéctée est :"+cible);
		
		String s = "";
		
		if(cible==Cible.PDJ){//cette suite de if permet de transformer la cible en String
			s= "di";
		}
		else if(cible==Cible.KVZ){
			s= "zeu(bleu)";
		}
		else if(cible==Cible.SR){
			s= "so(seau)";
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
			s= "geu(bleu)";
		}
		else if(cible==Cible.YNG){
			s= "ping";
		}
		
		if(s==""){
			throw new Exception();
		}
		
		String fileName = "data/"+s+".wav";//sera le nom du fichier joué
		
		System.out.println("Le fichier son qui va être joué est : "+fileName);
		
		File file = new File(fileName);//on vérifie si le fichier existe
        System.out.println(file.exists());
        
        model.setCurrentMessage("La syllabe reconnue est : "+s);//le message est affiché sur l'interface graphique
        
        Thread song = new Sound(fileName);
        
        song.run();//le son est joué
        
        System.out.println("Fin de la séquence de détection!");
        
	}
	
}
