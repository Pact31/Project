package affichage.control;

import java.awt.Color;

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
	public void launchceLeapMotion(){
		
		Boolean 		handleClick =	model.getHandleClick();
		String 			msg			=	null;
		
		if( !handleClick ){

			msg = kppvClassification();
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
	
	private String kppvClassification(){
		// TODO add the classifier Kppv
		
		Classifier classifier = new Classifier();
		//if(classifier.contaisThum())
		    return classifier.getGestures();
		//else
		//	return classifier.getGestures() + "thum";
		
	}
	
	private String adaboostClassification(){
		// TODO add the classifier adaboost
		
		return "HelloWorld adaboost";
		
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		
	}
	
}
