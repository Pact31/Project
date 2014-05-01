package affichage.control;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import leapmotion.LeapDataBase;
import classif.BanqueApprentissage;
import classif.Cible;
import classif.ClassificateurInterface;
import classif.Entree;
import classif.kppv.Kppv;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;

import LeapTS.FrameTS;
import affichage.model.DrawingAppModel;

public class HandSpeakController 
	implements HandSpeakControllerInterface
{
	
	private DrawingAppModel		model;
	
	public HandSpeakController(DrawingAppModel model){

		this.model	=	model;	
		
	}
	
	public DrawingAppModel	getDrawingAppModel(){
		
		return model;
		
	}
	
	
	@Override
	public void launchLeapMotion() throws Exception{
		
		Boolean 		handleClick =	model.getHandleClick();
		String 			msg			=	"NO detection!";
					
			
			// comment créer une classificateur?
			if(model.getCurrentClassifier() == "KPPV")
				//msg="NO detection!";
				msg = start(model.getKppv());				
			else
				msg = start(model.getAdaboost());
				//msg="NO detection!";
			//msg = kppvClassification();

			model.setCurrentMessage(msg);
			model.setCurrentSound(msg);
			//model.setCurrentGesture(kppvClassification());
			model.setCurrentGesture(msg);
			//model.setCurrentBottonMark("STOP");
			//model.setCurrentBottonColor(Color.RED);
		
		//}
		/*else{

			msg	= null;
			model.setCurrentMessage(msg);
			model.setCurrentGesture("NO detection!");
			//model.setCurrentBottonMark("START");
			//model.setCurrentBottonColor(Color.CYAN);
		
		}*/
		
		//model.setHandleClick(!handleClick);
		
	}
	

	private String start(ClassificateurInterface c) throws Exception {
		
		System.out.println("Debut de la sequence de traduction!");
		
		Controller controller = new Controller(); //ces quatre preimères lignes permettent d'acquérir une nouvelle Entree 
		Frame frame = controller.frame();
		FrameTS framets = new FrameTS(frame);
		Entree e = new Entree(framets);
		
		System.out.println("Une nouvelle entree a ete creee!");
		
		Cible cible = c.classifier(e);//on trouve la classe asociée à l'entrée
				
		System.out.println("La cible detectee est :"+cible);
		
		String s = "";
		String msg = "No detection!";
		
		
		
		if(cible==Cible.PDJ_G){//cette suite de if permet de transformer la cible en String
			s= "di";
			msg = "PDJ ";
		}
		else if(cible==Cible.KVZ_G){
			s= "zeu(renaitre)";
			msg = "KVZ ";
		}
		else if(cible==Cible.SR_G){
			s= "so(sol)";
			msg = "SR  ";
		}
		else if(cible==Cible.BNUI_G){
			s= "bi";
			msg = "BNUI";
		}
		else if(cible==Cible.MTF_G){
			s= "teu";
			msg = "MTF ";
		}
		else if(cible==Cible.ICHGNW_G){
			s= "cha(court)";
			msg = "ICHGNW";
		}
		else if(cible==Cible.G_G){
			s= "geu(renaitre)";
			msg = " G  ";
		}
		else if(cible==Cible.YNG_G){
			s= "ping";
			msg = "YNG ";
		}
		
		if(s==""){
			throw new Exception();
		}
		
		String fileName = "data/"+s+".wav";//sera le nom du fichier joué
		
		System.out.println("Le fichier son qui va etre joue est : "+fileName);
			// 
		File file = new File(fileName);//on vérifie si le fichier existe
        System.out.println(file.exists());
        model.setCurrentMessage(msg);
        return msg;
	}
	
	
	/*
	 * a completer par l'enregistement de la base 
	 * arguments: String vayelle, String Consonne definie sous la forme 
	 * 				private final String voyelleList[] = {"a o oe", "ain eu", "i on an", "ais ou o", "u un é"};
	 * 				private final String consonneList[] = {"PDJ", "KVZ", "SR", "BNUI", "MTF", "ICHG", "G", "YNG" };
	 * 
	 * */
	public void launchEnregister(String file, String c, String v){
		LeapDataBase base = model.getCurrentBank();
		base.write(file+".dat", c, v);	
	}
	/*------------------------------------------------------------*/
	
	/*
	 * a completer par la classification
	 * la classification doit revois un resultat "msg" sous forme String
	 */
	public void launchGame(){
		
		Cible res = null;
		
		/*
		 * a completer
		 */
		
		model.setCurrentCible(res);
		
		Controller controller = new Controller();
		Frame frame = controller.frame();
		FrameTS framets = new FrameTS(frame);
		Entree entree = new Entree(framets);
			
		
		if(model.getCurrentClassifier() == "KPPV")
				//msg="NO detection!";
				model.setCurrentCible(model.getKppv().classifier(entree));				
			else
				model.setCurrentCible(model.getAdaboost().classifier(entree));

	
	}
	
}
