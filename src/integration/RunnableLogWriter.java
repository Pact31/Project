package integration;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

public class RunnableLogWriter extends Thread{
	
	private LinkedBlockingQueue<String> writingQueue;
	private BufferedWriter writer;
	private Date date;
	private int N;
	
	
	public RunnableLogWriter(){
		super();
		this.writingQueue = new LinkedBlockingQueue<String>();
		try {
			this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/log.txt"), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void setDate(){
		this.date = new Date();
		try {
			this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/log"+this.date.getTime()+".txt"), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public BufferedWriter getWriter(){
		return this.writer;
	}

	public LinkedBlockingQueue<String> getWritingQueue() {
		return writingQueue;
	}
	
	public void setN(int n){
		this.N = n;
	}
	
	public void run(){
		for(int i = 0; i<7*this.N+6; i++){
			String s = "";
			try {
				s = this.writingQueue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				this.writer.newLine();
				this.writer.write(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			this.writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
