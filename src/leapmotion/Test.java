package leapmotion;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import LeapTS.FrameTS;
import classification.Cible;

import com.leapmotion.leap.*;
public class Test{


	public static void main(String[] args) throws IOException {

		Controller controller = new Controller();
		DataFK table = new DataFK() ;

		Frame a;
		char inChar;
		System.out.println("Press Enter to quit...");
		FileOutputStream fos = new FileOutputStream("test.ser");
		ObjectOutputStream oos= new ObjectOutputStream(fos);    
		try {
			while(true){

				BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
				inChar = (char) entree.read();


				System.out.println(inChar);

				if(inChar == 'q'){
					return;
				}
				
				a = controller.frame();
				System.out.println(a.fingers().count());
				System.out.println(a.fingers().frontmost().toString());

				FrameTS framets = new FrameTS(controller.frame());

				try{
					table.put(framets, 1);
				} catch (Exception e){}
				finally {
				}

       			oos.writeObject(framets); 
				oos.flush();
			}    

		}       		 
		catch (IOException e) {
			e.printStackTrace();
		} finally {}

	}
}
