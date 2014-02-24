package classification;
import com.leapmotion.leap.Controller;
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
		}
		
		return "NO";
	}
}
