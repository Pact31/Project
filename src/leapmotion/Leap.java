package leapmotion;
import java.io.IOException;
import com.leapmotion.leap.*;


public class Leap {

}




class SampleListener extends Listener {
	
	float m_fingers = 0;
	float m_radius = 0;
	Vector m_position = new Vector();
	Vector m_thumb = new Vector();
	
	public void onFrame(Controller controller){
		
		int mean = 10;
			
		for(int i = 0; i < mean; i++){
			Frame frame = controller.frame(i);
			m_fingers= m_fingers + frame.fingers().count();
			m_radius= m_radius + frame.hands().get(0).sphereRadius();
			m_position = m_position.plus(frame.fingers().rightmost().tipPosition().minus(frame.hand(0).palmPosition()));
			m_thumb= m_thumb.plus(frame.fingers().rightmost().tipPosition().minus(frame.hand(0).palmPosition()));
		}
		
		
//		System.out.println("Fingers : " + m/5);
		
		System.out.println(" Fingers : " + m_fingers/mean
						+  " Sphere radius : " + m_radius/mean
						+  " Postion : " + m_position.divide(mean)
						+  " Thumb : " + m_thumb.divide(mean)

				);
	}
		
	}