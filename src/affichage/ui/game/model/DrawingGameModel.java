package affichage.ui.game.model;

import java.util.ArrayList;
import java.util.Hashtable;

import affichage.ui.OptionMenu.TextPanel;
import affichage.ui.game.GameCiblePanel;
import affichage.ui.game.GameImagePanel;
import affichage.ui.game.ScorePanel;
import affichage.ui.game.ThreadTimeCount;
import affichage.ui.game.WindowGame;

public class DrawingGameModel {
	
		/* Hand Speak Game   */
	private    Hashtable<Integer, String> 		gameImage 				= 	new Hashtable<Integer, String>();
	private    Hashtable<Integer, ArrayList<String>> 		gameText 	= 	new Hashtable<Integer, ArrayList<String>>();
	private    Hashtable<String,  String> 		lisaTalkText 			= 	new Hashtable<String,String>(); 
	private		ArrayList<ArrayList<String>>	gameWord				=   new ArrayList<ArrayList<String>>();
	
	private    ThreadTimeCount					currentThreadTimeCount 	= 	null;
	private		String      					currentWord  			= 	"Clic Start!";
	private    String 							gameLevel				=	"facile";
	private    String 							gameProcess				= 	"level";
	private    TextPanel  						textPanel           	= 	null;
	private    GameImagePanel 					gameImagePanel			=	null;
	private 	GameCiblePanel 					gameCiblePanel			= 	null;
	private 	ScorePanel						scorePanel				= 	null;
	private    boolean							gameThreadRunning		= 	false;
	private		boolean 					  	rightAnswer				=	false;
	private		boolean 						gameStart				=	false;
	private    int         					currentScore       		= 	0;
	private 	int 							currentLevel			=	1;
	private    	WindowGame                      windowGame              = 	null;
	private 	boolean 						gameDone				= false;

	public DrawingGameModel(){
		
		setGameImage();
		setGameWord();
		setGameText();
		setLisaTalkText();

	}
	
	private void setGameImage(){
		
		/*gameImage.put(1, "src/affichage/ui/game/images/consonnes_bn1.png");
		gameImage.put(2, "src/affichage/ui/game/images/consonnes_g1.png");
		gameImage.put(3, "src/affichage/ui/game/images/consonnes_ich1.png");
		gameImage.put(4, "src/affichage/ui/game/images/consonnes_j1.png");
		gameImage.put(5, "src/affichage/ui/game/images/consonnes_kvz1.png");
		gameImage.put(6, "src/affichage/ui/game/images/consonnes_mtf1.png");
		gameImage.put(7, "src/affichage/ui/game/images/consonnes_pd1.png");
		gameImage.put(0, "src/affichage/ui/game/images/consonnes_sr1.png");
		*/
		gameImage.put(0, "src/affichage/ui/game/images/car.png");
		gameImage.put(1, "src/affichage/ui/game/images/jouet.jpg");
		gameImage.put(2, "src/affichage/ui/game/images/maison.jpg");
		gameImage.put(3, "src/affichage/ui/game/images/lion.jpg");
		gameImage.put(4, "src/affichage/ui/game/images/oiseau.jpg");
		gameImage.put(5, "src/affichage/ui/game/images/gare.jpg");
		gameImage.put(6, "src/affichage/ui/game/images/chat.jpg");
	}
	
	private void setLisaTalkText(){
	
		lisaTalkText.put("level", "Choisissez un niveau de difficulté:");
		lisaTalkText.put("welcomeeasy", "Bravo, tu as choisi le niveau facil!");
		lisaTalkText.put("welcomemoyen", "Bravo, tu as choisi le niveau moyen!");
		lisaTalkText.put("welcomedifficult", "Bravo, tu as choisi le niveau difficil!");
		lisaTalkText.put("start", "Clic le boutton pour démmarer le jeu.");
		lisaTalkText.put("false", "Ce n'est pas le bon geste!");
		lisaTalkText.put("true", "Bravo, tu as fais le bon geste!");
		lisaTalkText.put("timeOut", "Tu dois faire le geste plus vite possible!");
		lisaTalkText.put("continue", "Fais le prochain geste!");
		lisaTalkText.put("lastWord", "C'est le dernier mot!");
		lisaTalkText.put("win", "Super! Tu peux essayer un niveau plus difficil!");
		lisaTalkText.put("fail", "Essais encore une fois ce niveau ou vas au niveau inférieur !");
	}
	
	public String getLisaTalkText(String s){
		return lisaTalkText.get(s);
	}
	
	public void setGameLevel(String s){
		this.gameLevel	= s;
	}
	
	public void setGameProcess(String s){
		this.gameProcess = s;
	}
	
	public String getGameProcess(){
		return gameProcess;
	}
	
	public String getGameLevel(){
		return gameLevel;
	}
		
	public String getGameImage(int i){
		return gameImage.get(i);
	}
	
	private void setGameWord(){
		
		ArrayList<String> maison = new ArrayList<String>();
		maison.add("mai -");
		maison.add(" son");
		
		ArrayList<String> voiture = new ArrayList<String>();
		voiture.add("voi -");
		voiture.add(" tu -");
		voiture.add(" re");
		
		ArrayList<String> jouet =  new ArrayList<String>();
		jouet.add("jou -");
		jouet.add(" et");
		
		ArrayList<String> lion =  new ArrayList<String>();
		lion.add("li -");
		lion.add(" on");
		
		ArrayList<String> oiseau =  new ArrayList<String>();
		oiseau.add("oi -");
		oiseau.add(" seau");
		
		ArrayList<String> gare =  new ArrayList<String>();
		gare.add("ga -");
		gare.add(" re");
		
		ArrayList<String> chat =  new ArrayList<String>();
		chat.add("chat");
		
		gameWord.add(voiture);
		gameWord.add(jouet);
		gameWord.add(maison);
		gameWord.add(lion);
		gameWord.add(oiseau);
		gameWord.add(gare);
		gameWord.add(chat);
	}
	
	private void setGameText(){
		
		//ArrayList<String>
		/*gameText.put(1, "BNUI");
		gameText.put(2, " G  ");
		gameText.put(3, "ICHG");
		gameText.put(4, "YNG ");
		gameText.put(5, "KVZ ");
		gameText.put(6, "MTF ");
		gameText.put(7, "PDJ ");
		gameText.put(0, "SR  ");*/
		gameText.put(0, gameWord.get(0));
		gameText.put(1, gameWord.get(1));
		gameText.put(2, gameWord.get(2));
		gameText.put(3, gameWord.get(3));
		gameText.put(4, gameWord.get(4));
		gameText.put(5, gameWord.get(5));
		gameText.put(6, gameWord.get(6));
		//gameText.put(6, gameWord.get(0));
		//gameText.put(7, gameWord.get(0));
		//gameText.put(0, gameWord.get(1));
		
	}
	
	public ArrayList<String> getGameText(int i){
		return gameText.get(i);
	}
	
	public void setRightAnswer(boolean i){
		this.rightAnswer = i;
	}
	
	public boolean getRightAnswer(){
		return rightAnswer;
	}
	
	public void setCurrentScore(int i){
		this.currentScore = i;
	}
	
	public int getCurrentScore(){
		return currentScore;
	}
	
	public void setCurrentLevel(int i){
		this.currentLevel = i;
	}
	
	public int getCurrentLevel(){
		return currentLevel;
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
	
	public void setScorePanel(ScorePanel s){
		this.scorePanel = s;
	}
	
	public ScorePanel getScorePanel(){
		return scorePanel;
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
	
	public void setGameStart(boolean i){
		this.gameStart	= i;
	}
	
	public boolean getGameStart(){
		return gameStart;
	}

	public void setGameCiblePanel(GameCiblePanel gameCiblePanel) {
		this.gameCiblePanel = gameCiblePanel;
	}
	
	public GameCiblePanel getGameCiblePanel(){
		return gameCiblePanel;
	}
	
	public void setWindowGame(WindowGame w){
		this.windowGame = w;
	}
	
	public WindowGame getWindowGame(){
		return this.windowGame;
	}
	
	public void setGameDone(boolean b){
		this.gameDone = b;
	}
	
	public boolean getGameDone(){
		return this.gameDone;
	}

}
