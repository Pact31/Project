package affichage.model;

import java.util.Observable;
import java.awt.Color;
import java.io.File;

import affichage.gestures.*;

import syntheseparole.Sound;

public class DrawingAppModel extends Observable{

	private 	String		msg					= 	"NO detection!";
	private 	Boolean 	handleClick 		= 	false;
	private 	Color		currentButtonColor	=	Color.CYAN;
	private 	String		currentButtonMark	=	"START";
	private		String		currentGesture		=	"NO detection!";
	private		File		currentBank			=	null;
	
	public DrawingAppModel(){
		
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
	/*	switch(msg){
			case "SR":
				break;
			case "PDJ":
				break;
			case "BNUI":
				break;
			case "G":
				break;
			case "KVZ":
				break;
			case "YNG":
				break;
			case "ICHGNW":
				break;
			case "MDF":
				break;
			default: msg = null;
		}
		if(msg != null){
			Thread song = new Sound(msg);
        	song.run();
		}*/
	}
}