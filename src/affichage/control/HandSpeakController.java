package control;

import java.awt.Color;
import model.DrawingAppModel;

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
	public void Start() {
		
		
		
	}
	
	@Override
	public void launchceLeapMotion(){
		
		Boolean 		handleClick =	model.getHandleClick();
		String 			msg			=	null;
		
		if( !handleClick ){

			msg = kppvClassification() + " " + adaboostClassification();
			model.setCurrentMessage(msg);
			model.setCurrentBottonMark("STOP");
			model.setCurrentBottonColor(Color.RED);
		
		}
		else{

			msg	= null;
			model.setCurrentMessage(msg);
			model.setCurrentBottonMark("START");
			model.setCurrentBottonColor(Color.CYAN);
		
		}
		
		model.setHandleClick(!handleClick);
		
	}
	
	private String kppvClassification(){
		
		return "HelloWorld kppv";
		
	}
	
	private String adaboostClassification(){
		
		return "HelloWorld adaboost";
		
	}
	
}
