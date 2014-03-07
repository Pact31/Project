package LeapTS;
import java.io.Serializable;
import java.util.ArrayList;

import com.leapmotion.leap.*;

/**************************************************************
 *                                                            *
 * FrameToSave contient la liste des doits, mains et gestes.  *
 * FrameToSave est serializable alors que Frame ne l'est pas! *
 *                                                            *
 *                                                            *
 **************************************************************/



public class FrameTS implements Serializable{
	
	
	/**************Attributs**************************/

	private static final long serialVersionUID = 1L;
	private ArrayList<FingerTS> fingerList;
	private ArrayList<HandTS> handList;
	

	
	
	/**********************Consctructeur******************/

	public FrameTS(Frame frame){
		
		fingerList = new ArrayList<FingerTS>();
		handList = new ArrayList<HandTS>();
		
		for (Finger finger : frame.fingers()){
			fingerList.add(new FingerTS(finger));
		}
		
		for (Hand hand : frame.hands()){
			handList.add(new HandTS(hand));
		}

	}

	
	/********************************Getters*********************************/
	
	public ArrayList<FingerTS> getFingerList() {
		return fingerList;
	}

	public ArrayList<HandTS> getHandList() {
		return handList;
	}
	
	
	
}
