package affichage.test_classification;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Pointable;
import com.leapmotion.leap.PointableList;


public class Classifier {
	private Controller leap = new Controller();
	
	public String getGestures(){
		
		PointableList  pointables = leap.frame().pointables();
		switch(pointables.count()){
			case 1:
				return "M";
			case 2:
				return "R";
			case 3:
				return "P";
			case 4:
				return "B";
			case 5:
				return "G";
			default:
				return "NO detection!";
				
		}

	}
	
	public boolean contaisThum(){
		
		PointableList pointableList = leap.frame().pointables();
		Pointable pointable = null;
		float min = 200;
		
		for(int i = 0;i < pointableList.count();i++){
			pointable = pointableList.get(i);
			float length = pointable.length(); // get length of a finger
			System.out.print(length + " " + i + "\n");
			if(length < min)
				min = length;
		}
		
		if(min < 100)
			return true;
		else
			return false;
	}
}
