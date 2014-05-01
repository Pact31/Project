package syntheseParole;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class main {

	/**
	 * @param args
	 * @throws WavFileException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, WavFileException {
		// TODO Auto-generated method stub
		
		WavFile mywavfile = new WavFile();
		//WavFile mywavfile1 = new WavFile();
	    //mywavfile.cat("data/ping.wav","data/py.wav");
	   // mywavfile1.cat("data/pk.wav","data/pl.wav");
	    ArrayList<String> list = new ArrayList<String>();
	    list.add("po(beau)");
	    list.add("sé");
	    list.add("dé");
		mywavfile = mywavfile.wordsynthetise(list);
		Sound mysound = new Sound(mywavfile.getFile().getName());
		mysound.run();

}

}