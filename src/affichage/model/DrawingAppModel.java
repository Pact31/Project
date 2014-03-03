package affichage.model;

import java.util.Observable;
import java.awt.Color;

public class DrawingAppModel extends Observable{

	private 	String		msg					= 	null;
	private 	Boolean 	handleClick 		= 	false;
	private 	Color		currentButtonColor	=	Color.RED;
	private 	String		currentButtonMark	=	"Start";
	public DrawingAppModel(){

	}
	
	/*public void launchceLeapMotion(){
		
		if(!handleClick){
			msg = kppvClassification() + " " + adaboostClassification();
			CurrentButtonColor	=	Color.RED;
		}
		else{
			msg	= null;
			CurrentButtonColor	=	Color.CYAN;
		}
		
		handleClick = !handleClick;
	}*/


	//getters and setters
	
	
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
}