package leapmotion;
import java.io.IOException;
import com.leapmotion.leap.*;


package leapmotion;
import java.io.IOException;
import java.util.ArrayList;

import com.leapmotion.leap.*;


public class Leap{

float m_fingers = 0;
float m_radius = 0;

//private Vector m_thumb = new Vector();
private Vector m_position1 =new Vector();
private Vector m_position2 =new Vector();
private Vector m_position3 =new Vector();
private Vector m_position4 =new Vector();
private Vector m_position5 =new Vector();
ArrayList<Vector> Liste= new ArrayList<Vector>();



public ArrayList<Vector> VecteurDonnees(){

Liste.add(m_position1.divide(10));
Liste.add(m_position2.divide(10));
Liste.add(m_position3.divide(10));
Liste.add(m_position4.divide(10));
Liste.add(m_position5.divide(10));
return(Liste);
}
/* public static void main (String [] args){
SampleListener S=new SampleListener();
System.out.println(S.VecteurDonnees().get(0));

}*/

    public static void main(String[] args) {
        // Create a sample listener and controller
   // SampleListener listener = new SampleListener();
        Controller controller = new Controller();

        // Have the sample listener receive events from the controller
  // controller.addListener(listener);

        // Keep this process running until Enter is pressed
        
   /* for( int i = 0; i < 1000000; i++){
Frame frame = controller.frame();
int c = frame.fingers().count();
System.out.println(c);
}*/
     float m_fingers = 0;
     float m_radius = 0;
    
     //private Vector m_thumb = new Vector();
     Vector m_position1 =new Vector();
     Vector m_position2 =new Vector();
     Vector m_position3 =new Vector();
     Vector m_position4 =new Vector();
     Vector m_position5 =new Vector();
        
        
        int inChar;
        System.out.println("Press Enter to quit...");
        try {
            inChar = System.in.read();
            if(inChar == 13){ //13 = identifiant de la touche entree
        for(int i = 0; i < 10; i++){
Frame frame = controller.frame(i);

m_fingers= m_fingers + frame.fingers().count();
m_radius= m_radius + frame.hands().get(0).sphereRadius();
m_position1 = m_position1.plus(frame.fingers().get(0).tipPosition().minus(frame.hand(0).palmPosition()));
m_position2 = m_position2.plus(frame.fingers().get(1).tipPosition().minus(frame.hand(0).palmPosition()));
m_position3 = m_position3.plus(frame.fingers().get(2).tipPosition().minus(frame.hand(0).palmPosition()));
m_position4 = m_position4.plus(frame.fingers().get(3).tipPosition().minus(frame.hand(0).palmPosition()));
m_position5 = m_position5.plus(frame.fingers().get(4).tipPosition().minus(frame.hand(0).palmPosition()));


}
        System.out.println(m_position1 + "\n" + m_position2 + "\n" + m_position3);
            }
        } catch (IOException e) {
            e.printStackTrace();

      
        }

        // Remove the sample listener when done
      // controller.removeListener(listener);
    }

}

