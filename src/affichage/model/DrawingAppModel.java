package affichage.model;

import java.util.Hashtable;
import java.util.Observable;
import java.awt.Color;
import java.io.File;

import affichage.ui.OptionMenu.TextPanel;
import affichage.ui.game.GameImagePanel;
import affichage.ui.game.ThreadTimeCount;
import leapmotion.LeapDataBase;
import classif.BanqueApprentissage;
import classif.adaboost.Adaboost;
import classif.kppv.Kppv;
import synthese.Sound;

public class DrawingAppModel extends Observable{

			/* Graphic User Interface */
	private 	String		msg					= 	"NO detection!";
	private 	String		currentButtonMark	=	"START";
	private		String		currentGesture		=	"NO detection!";
	private    String      currentClassifier    =    "KPPV";
	private 	Boolean 	handleClick 		= 	false;
	private 	Color		currentButtonColor	=	Color.CYAN;
	private		boolean    currentCibleOption  =   true;
	
			/* Classification */
	private    Hashtable<String, String> soundSource = new Hashtable<String, String>();
	private    Adaboost    adaboost;
	private    Kppv        kppv;
	private    LeapDataBase currentleapDataBase = new LeapDataBase();
	
			/* Hand Speak Game   */
	private    Hashtable<Integer, String> gameImage = new Hashtable<Integer, String>();
	private    ThreadTimeCount		currentThreadTimeCount = null;
	private    Boolean		gameThreadRunning	= 	false;
	private		String      currentWord  		= 	"Clic Start!";
	private    TextPanel  textPanel           	= 	null;
	private    GameImagePanel gameImagePanel	=	null;
	
	public DrawingAppModel() throws Exception{
		
		System.out.println("Set sound source");
		setSoundSource();
		setGameImage();
		
		int T = 5;
		int k = 3;
		LeapDataBase leapDataBase = new LeapDataBase();//initialisation de la base de donnée
		
		leapDataBase.read("baseLeap3.dat");
		
		System.out.println("Base de test initialisée");
		
		BanqueApprentissage banque = new BanqueApprentissage(leapDataBase);
		
		System.out.println("Banque d'apprentissage initialisée");
		
		//Adaboost adaboost =new Adaboost(banque, T);
		//adaboost = new Adaboost(banque, T);
		System.out.print("AdaBoost initialisé" + " ");
			
		//Kppv kppv = new Kppv(banque, k);
		//kppv = new Kppv(banque, k);
		System.out.print("Kppv initialisé");

	}
	
	public Adaboost getAdaboost(){
		
		return adaboost;
	
	}
	
	public Kppv getKppv(){
		
		return kppv;
	
	}
	
	
	private void setSoundSource(){
		
		soundSource.put("SR  ", "data/so(seau).wav");
		soundSource.put("PDJ ", "data/di.wav");
		soundSource.put("BNUI", "data/bi.wav");
		soundSource.put(" G  ", "data/geu(bleu).wav");
		soundSource.put("KVZ ", "data/zeu(bleu).wav");
		soundSource.put("YNG ", "data/ping.wav");
		soundSource.put("ICHG", "data/cha(court).wav");
		soundSource.put("MTF ", "data/teu.wav");
		
	}
	
	private void setGameImage(){
		gameImage.put(1, "src/affichage/ui/game/images/consonnes_bn1.png");
		gameImage.put(2, "src/affichage/ui/game/images/consonnes_g1.png");
		gameImage.put(3, "src/affichage/ui/game/images/consonnes_ich1.png");
		gameImage.put(4, "src/affichage/ui/game/images/consonnes_j1.png");
		gameImage.put(5, "src/affichage/ui/game/images/consonnes_kvz1.png");
		gameImage.put(6, "src/affichage/ui/game/images/consonnes_mtf1.png");
		gameImage.put(7, "src/affichage/ui/game/images/consonnes_pd1.png");
		gameImage.put(0, "src/affichage/ui/game/images/consonnes_sr1.png");
		
	}
	
	public String getGameImage(int i){
		return gameImage.get(i);
	}
	
	public String getCurrentClassifier(){
		
		return currentClassifier;
	
	}
	
	public void setCurrentClassifer(String c){
	
		currentClassifier = c;
	
	}
	
	public boolean getCurrentCibleOption(){
	
		return currentCibleOption;
	
	}
	
	public void setCurrentCibleOption(boolean i){
	
		currentCibleOption = i;
	
	}
	
	public String getCurrentMessage(){
		
		return msg;
		
	}
	
	public void setCurrentMessage(String msg){
		
		this.msg = msg;
		
	}
	
	public void setCurrentBottonColor(Color c){
		
		this.currentButtonColor	=	c;
		
	}
	
	public Color getCurrentBottonColor(){
		
		return currentButtonColor;
		
	}
	
	public void setHandleClick(Boolean c){
		
		this.handleClick	=	c;
		
	}
	
	public Boolean getHandleClick(){
		
		return handleClick;
		
	}	
	
	public void setCurrentBottonMark(String mark){
		
		this.currentButtonMark	=	mark;
		
	}
	
	public String getCurrentBottonMark(){
		
		return currentButtonMark;
		
	}
	
	public void setTextPanel(TextPanel t){
		this.textPanel = t;
	}
	
	public TextPanel getTextPanel(){
		return textPanel;
	}
	
	public void setGameImagePanel(GameImagePanel g){
		this.gameImagePanel = g;
	}
	
	public GameImagePanel getGameImagePanel(){
		return gameImagePanel;
	}
	
	public void setCurrentGesture(String file){
		
		this.currentGesture	=	file;
		
	}
	
	public String getCurrentGesture(){
		
		return currentGesture;
		
	}
	
	public void setCurrentThreadTimeCount(ThreadTimeCount c){
		this.currentThreadTimeCount = c;
	}
	
	public ThreadTimeCount getCurrentThreadTimeCount(){
		return currentThreadTimeCount;
	}
	
	public void setGameThreadRunning(boolean i){
		this.gameThreadRunning = i;
	}
	
	public boolean getGameThreadRunning(){
		return gameThreadRunning;
	}
	
	public void setCurrentWord(String w){
		this.currentWord = w;
	}
	
	public String getCurrentWord(){
		return currentWord;
	}
	
	public void setCurrentBank(File file) throws Exception{
		
		int T=5;
		int k=3;
		currentleapDataBase.read(file.getAbsolutePath());
		
		BanqueApprentissage banque = new BanqueApprentissage(currentleapDataBase);
		
		System.out.println("Banque d'apprentissage initialisée");
		
		//Adaboost adaboost =new Adaboost(banque, T);
		adaboost = new Adaboost(banque, T);
		System.out.print("AdaBoost initialisé");
			
		//Kppv kppv = new Kppv(banque, k);
		kppv = new Kppv(banque, k);
		System.out.print("Kppv initialisé");

	}
	
	public LeapDataBase getCurrentBank(){
		
		return currentleapDataBase;
		
	}
 
	public void setCurrentSound(String msg){
	
		//System.out.println(msg);
		if(soundSource.containsKey(msg)){
			System.out.println(msg);
			msg = soundSource.get(msg);
			Thread song = new Sound(msg);
        	song.run();
		}

	}
}