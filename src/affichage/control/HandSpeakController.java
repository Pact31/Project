package control;

import java.awt.Color;

import test_classification.Classifier;

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

			msg = kppvClassification();
			model.setCurrentMessage(msg);
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
	
	private String kppvClassification(){
		
		Classifier classifier = new Classifier();
		//if(classifier.contaisThum())
		    return classifier.getGestures();
		//else
		//	return classifier.getGestures() + "thum";
		
	}
	
	private String adaboostClassification(){
		
		return "HelloWorld adaboost";
		
	}
	
}
