package synthese;

import java.io.File;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//InterfacePlayer player = new InterfacePlayer("data/pain.wav");
        //player.setVisible(true);
        File file = new File("data/pa1.wav");
        System.out.println(file.exists());
        Thread song = new Sound("data/po(beau).wav");
        song.run();
	}

}
