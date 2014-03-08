package affichage.test_classification;

import com.leapmotion.leap.Pointable;

public class MyFinger 
extends Pointable
{
	public MyFinger(){
		super();
	}
	
	public int carIsFinger(){
		
		if(this.isFinger())
			return 1;
		else
			return -1;
		
	}
	
	public int carLength(float val){
		if( Math.abs(this.length() - val) <= 10)
			return 1;
		else
			return -1;
	}  
	
	public int carWidth(float val){
		if( Math.abs(this.width() - val) <= 10)
			return 1;
		else
			return -1;
	}
	
	public int carIsValid(){
		if(this.isValid())
			return 1;
		else
			return -1;
	}
	
}
