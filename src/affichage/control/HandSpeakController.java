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
import affichage.test_classification.Classifier;
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
	public void launchceLeapMotion() throws Exception{
		
		Boolean 		handleClick =	model.getHandleClick();
		String 			msg			=	"NO detection!";
		
		if( !handleClick ){
			
			
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
			model.setCurrentBottonMark("STOP");
			model.setCurrentBottonColor(Color.RED);
		
		}
		else{

			msg	= null;
			model.setCurrentMessage(msg);
			model.setCurrentGesture("NO detection!");
			model.setCurrentBottonMark("START");
			model.setCurrentBottonColor(Color.CYAN);
		
		}
		
		model.setHandleClick(!handleClick);
		
	}
	
	public void launchGame() throws Exception{
		
		//Boolean 		handleClick =	model.getHandleClick();
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
		//model.setCurrentGesture(msg);
		//model.setCurrentBottonMark("STOP");
		//model.setCurrentBottonColor(Color.RED);

	}
	
	private Cible kppvClassification(){
		
		/*Classifier classifier = new Classifier();
		//if(classifier.contaisThum())
		    return classifier.getGestures();
		//else
		//	return classifier.getGestures() + "thum";
		*/
		LeapDataBase leapDataBase = new LeapDataBase();
		try {
			leapDataBase.read("LeapHnv22.dat");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BanqueApprentissage banque = new BanqueApprentissage(leapDataBase);
		
				
		Controller controller = new Controller();
		
		System.out.println("Appuer sur une touche pour valider");
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));//lecture de la touche tappee au clavier
		try {
			char inChar = (char) buf.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		Frame frame = controller.frame();
		FrameTS framets = new FrameTS(frame);
		Entree entree = new Entree(framets);
		
		Kppv classificateur = new Kppv(banque,3);
		System.out.println(classificateur.classifier(entree));
		return classificateur.classifier(entree);
	}
	
	private String adaboostClassification(){
		// TODO add the classifier adaboost
		Controller controller = new Controller();
		
		Frame frame = controller.frame();
		FrameTS framets = new FrameTS(frame);
		Entree entree = new Entree(framets);
		
		//Cible c = model.getAdaboost().predict(entree);
		//System.out.println(c);
		return "NO detection!";
		
	}

	private String start(ClassificateurInterface c) throws Exception {
		
		System.out.println("Début de la séquence de traduction!");
		
		Controller controller = new Controller(); //ces quatre preimères lignes permettent d'acquérir une nouvelle Entree 
		Frame frame = controller.frame();
		FrameTS framets = new FrameTS(frame);
		Entree e = new Entree(framets);
		
		System.out.println("Une nouvelle entrée a été crée!");
		
		Cible cible = c.classifier(e);//on trouve la classe asociée à l'entrée
				
		System.out.println("La cible détéctée est :"+cible);
		
		String s = "";
		String msg = "No detection!";
		
		if(cible==Cible.PDJ){//cette suite de if permet de transformer la cible en String
			s= "di";
			msg = "PDJ ";
		}
		else if(cible==Cible.KVZ){
			s= "zeu(renaitre)";
			msg = "KVZ ";
		}
		else if(cible==Cible.SR){
			s= "so(sol)";
			msg = "SR  ";
		}
		else if(cible==Cible.BNUI){
			s= "bi";
			msg = "BNUI";
		}
		else if(cible==Cible.MTF){
			s= "teu";
			msg = "MTF ";
		}
		else if(cible==Cible.ICHGNW){
			s= "cha(court)";
			msg = "ICHG";
		}
		else if(cible==Cible.G){
			s= "geu(renaitre)";
			msg = " G  ";
		}
		else if(cible==Cible.YNG){
			s= "ping";
			msg = "YNG ";
		}
		
		if(s==""){
			throw new Exception();
		}
		
		String fileName = "data/"+s+".wav";//sera le nom du fichier joué
		
		System.out.println("Le fichier son qui va être joué est : "+fileName);
		
		File file = new File(fileName);//on vérifie si le fichier existe
        System.out.println(file.exists());
        model.setCurrentMessage(msg);
        return msg;
	}
	
}
