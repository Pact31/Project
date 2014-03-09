package affichage.model;

import java.util.Hashtable;
import java.util.Observable;
import java.awt.Color;
import java.io.File;

import leapmotion.LeapDataBase;
import classif.adaboost.Adaboost;
import classif.classification.BanqueApprentissage;
import classif.kppv.Kppv;
import synthese.Sound;

public class DrawingAppModel extends Observable{

	private 	String		msg					= 	"NO detection!";
	private 	String		currentButtonMark	=	"START";
	private		String		currentGesture		=	"NO detection!";
	private    String      currentClassifier    =    "KPPV";
	private 	Boolean 	handleClick 		= 	false;
	private 	Color		currentButtonColor	=	Color.CYAN;
	private		File		currentBank			=	null;
	private		boolean    currentCibleOption  =   true;
	private    Hashtable<String, String> soundSource = new Hashtable<String, String>();
	private    Adaboost    adaboost;
	private    Kppv        kppv;
	
	public DrawingAppModel() throws Exception{
		
		setSoundSource();
		int T = 6;
		int k = 3;
		LeapDataBase leapDataBase = new LeapDataBase();//initialisation de la base de donnée
		
		//leapDataBase.read("data/baseLeap.dat");
		
		System.out.println("Base de test initialisée");
		
		//BanqueApprentissage banque = new BanqueApprentissage(leapDataBase);
		
		System.out.println("Banque d'apprentissage initialisée");
		
		//Adaboost adaboost =new Adaboost(banque, T);
		//adaboost = new Adaboost(banque, T);
		System.out.print("AdaBoost initialisé");
			
		//Kppv kppv = new Kppv(banque, k);
		//kppv = new Kppv(banque, k);
		System.out.print("Kppv initialisé");

	}
	
	public Adaboost getAdaboost(){
		return adaboost;
	}
	public Kppv getKppv(){
		return kppv;
	}
	
	private void setSoundSource(){
		
		soundSource.put("SR", "data/so(seau).wav");
		soundSource.put("PDJ", "data/di.wav");
		soundSource.put("BNUI", "data/bi.wav");
		soundSource.put("G", "data/geu(bleu).wav");
		soundSource.put("KVZ", "data/zeu(bleu).wav");
		soundSource.put("YNG", "data/ping.wav");
		soundSource.put("ICHGNW", "data/cha(court).wav");
		soundSource.put("MTF", "data/teu.wav");
		
	}
	
	public String getCurrentClassifier(){
		return currentClassifier;
	}
	
	public void setCurrentClassifer(String c){
		currentClassifier = c;
	}
	
	public boolean getCurrentCibleOption(){
		return currentCibleOption;
	}
	
	public void setCurrentCibleOption(boolean i){
		currentCibleOption = i;
	}
	
	public String getCurrentMessage(){
		
		return msg;
		
	}
	
	public void setCurrentMessage(String msg){
		
		this.msg = msg;
		
	}
	
	public void setCurrentBottonColor(Color c){
		
		this.currentButtonColor	=	c;
		
	}
	
	public Color getCurrentBottonColor(){
		
		return currentButtonColor;
		
	}
	
	public void setHandleClick(Boolean c){
		
		this.handleClick	=	c;
		
	}
	
	public Boolean getHandleClick(){
		
		return handleClick;
		
	}	
	
	public void setCurrentBottonMark(String mark){
		
		this.currentButtonMark	=	mark;
		
	}
	
	public String getCurrentBottonMark(){
		
		return currentButtonMark;
		
	}
	
	public void setCurrentGesture(String file){
		
		this.currentGesture	=	file;
		
	}
	
	public String getCurrentGesture(){
		
		return currentGesture;
		
	}
	
	public void setCurrentBank(File file){
		
		this.currentBank = file;
	
	}
	
	public File getCurrentBank(){
		
		return currentBank;
		
	}
 
	public void setCurrentSound(String msg){
	
		if(soundSource.containsKey(msg)){
			msg = soundSource.get(msg);
			Thread song = new Sound(msg);
        	song.run();
		}

	}
}