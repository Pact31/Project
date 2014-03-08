package affichage.model;

import java.util.Hashtable;
import java.util.Observable;
import java.awt.Color;
import java.io.File;

import affichage.gestures.*;

import synthese.Sound;

public class DrawingAppModel extends Observable{

	private 	String		msg					= 	"NO detection!";
	private 	Boolean 	handleClick 		= 	false;
	private 	Color		currentButtonColor	=	Color.CYAN;
	private 	String		currentButtonMark	=	"START";
	private		String		currentGesture		=	"NO detection!";
	private		File		currentBank			=	null;
	private		boolean    currentCibleOption  =   true;
	private    Hashtable<String, String> soundSource = new Hashtable<String, String>();
	private    String      currentClassifier    =    "KPPV";
	
	
	public DrawingAppModel(){
		setSoundSource();
	}
	
	private void setSoundSource(){
		
		soundSource.put("SR", "data/di.wav");
		soundSource.put("PDJ", "data/di.wav");
		soundSource.put("BNUI", "data/bi.wav");
		soundSource.put("G", "data/geu(bleu).wav");
		soundSource.put("KVZ", "data/zeu(bleu).wav");
		soundSource.put("YNG", "data/ping.wav");
		soundSource.put("ICHGNW", "data/cha(court).wav");
		soundSource.put("MDF", "data/teu.wav");
		
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