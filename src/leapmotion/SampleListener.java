package leapmotion;
import java.io.IOException;
import java.util.ArrayList;

import com.leapmotion.leap.*;






public class SampleListener extends Listener {
	
	float m_fingers = 0;
	float m_radius = 0;
	
	Vector m_thumb = new Vector();
	 Vector m_position1 =new Vector();
	Vector m_position2 =new Vector();
	Vector m_position3 =new Vector();
	Vector m_position4 =new Vector();
	Vector m_position5 =new Vector();
	ArrayList<Vector> Liste= new ArrayList<Vector>();
	public void onFrame(Controller controller){
		
		 long fid ;
		fid= controller.frame().id();
			
		for(int i = 0; i < 10; i++){
			//if (fid==100){
			Frame frame = controller.frame(i);
		
			m_fingers= m_fingers + frame.fingers().count();
			m_radius= m_radius + frame.hands().get(0).sphereRadius();
			m_position1 = m_position1.plus(frame.fingers().get(0).tipPosition().minus(frame.hand(0).palmPosition()));
			m_position2 = m_position2.plus(frame.fingers().get(1).tipPosition().minus(frame.hand(0).palmPosition()));
			m_position3 = m_position3.plus(frame.fingers().get(2).tipPosition().minus(frame.hand(0).palmPosition()));
			m_position4 = m_position4.plus(frame.fingers().get(3).tipPosition().minus(frame.hand(0).palmPosition()));
			m_position5 = m_position5.plus(frame.fingers().get(4).tipPosition().minus(frame.hand(0).palmPosition()));
			
			//}
			
		}
	}
		
		public ArrayList<Vector> VecteurDonnées(){
			
			Liste.add(m_position1.divide(10));
			Liste.add(m_position2.divide(10));
			Liste.add(m_position3.divide(10));
			Liste.add(m_position4.divide(10));
			Liste.add(m_position5.divide(10));
			return(Liste);
		}
		  public static void main (String [] args){
			  System.out.println(m_position1);
		      
	}
}
