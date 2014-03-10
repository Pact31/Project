package affichage.test_classification;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Pointable;
import com.leapmotion.leap.PointableList;


public class Classifier {
	private Controller leap = new Controller();
	
	public String getGestures(){
		
		PointableList  pointables = leap.frame().pointables();
		if(this.contaisThum()){
			switch(pointables.count()){
				case 5:
					return "MNT";
				case 2:
					return "ICHGNW";
				case 3:
					return "G";
				default:
					return "NO detection!";
					//return "YNG";
			}
		}
		
		else{
			switch(pointables.count()){
				case 3:
					return "SR";
				case 1:
					return "PDJ";
				case 2:
					return "KVZ";
				case 4:
					return "BNUI";
				default:
					return "NO detection!"; 
			}
		}
			
	}
	
	public boolean contaisThum(){
		
		PointableList pointableList = leap.frame().pointables();
		Pointable pointable = null;
		float min = 200;
		float max = 0;
		for(int i = 0;i < pointableList.count();i++){
			pointable = pointableList.get(i);
			float length = pointable.length(); // get length of a finger
			float width = pointable.width();
			
			System.out.print(length + " " + i + "\n");
			if(length < min)
				min = length;
			if(width > max)
				max = width;
		}
		
		if(min < 60 || max > 15)
			return true;
		else
			return false;
	}
}
