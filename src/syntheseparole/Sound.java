package syntheseparole;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound extends Thread {
	
	private String nameOfSound;
	
	
public  Sound(String nameOfSound){
	
this.nameOfSound = nameOfSound;
	
}

public void run ()  {
	
	File soundFile = null;
	
	try {
		
		soundFile = new File(this.getNameOfSound());
	}
	
	catch (Exception e) { e.printStackTrace(); }
	
	AudioInputStream ais = null;
	
	try {
		
		ais = AudioSystem.getAudioInputStream(soundFile);
	}
	
	catch (UnsupportedAudioFileException e1) { e1.printStackTrace(); }
	
	catch(IOException e2) { e2.printStackTrace(); }
	
	AudioFormat format = ais.getFormat();
	SourceDataLine sdl = null;
	DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
	
	try {
		sdl = (SourceDataLine) AudioSystem.getLine(info);
		sdl.open(format);	
	}
	
	catch(LineUnavailableException e3) { e3.printStackTrace(); }
	
	catch(Exception e4) {e4.printStackTrace(); }
	
	sdl.start();
	
	int length = (int) (format.getFrameSize() * ais.getFrameLength());
	byte [] samples = new byte[length];
	int numberBytesRead = 0;
	
	try {
		
		while (numberBytesRead != -1) {
			
			numberBytesRead = ais.read(samples, 0,length);
			if (numberBytesRead != -1){
				sdl.write(samples, 0,numberBytesRead);
			}
		}
	}
	
	catch (IOException e) { e.printStackTrace(); }
	
	finally {
		sdl.drain();
		sdl.close();
	}	
}

	public Sound cat1(Sound snd) {
		// TODO Auto-generated method stub
		return null;
	}

	public Sound cat2(Sound snd) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNameOfSound() {
		return nameOfSound;
	}

	public void setNameOfSound(String nameOfSound) {
		this.nameOfSound = nameOfSound;
	}
	
	
	

}
