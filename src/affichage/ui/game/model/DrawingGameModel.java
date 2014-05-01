package affichage.ui.game.model;

import integration.Dico;

import java.util.ArrayList;
import java.util.Hashtable;

import classif.Cible;

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
	private    Hashtable<Integer, ArrayList<Cible>> 		gameCible 	= 	new Hashtable<Integer, ArrayList<Cible>>();
	
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
	private 	Dico							dico;
	
	public DrawingGameModel(){
		
		setGameImage();
		setGameWord();
		setGameText();
		setLisaTalkText();
		setGameCible();
		dico = new Dico();
	
	}
	
	private void setGameImage(){
		
		gameImage.put(0, "src/affichage/ui/game/images/games/maison.png");
		gameImage.put(1, "src/affichage/ui/game/images/games/oiseau.png");
		gameImage.put(2, "src/affichage/ui/game/images/games/chat.png");
		gameImage.put(3, "src/affichage/ui/game/images/games/lion.png");
		gameImage.put(4, "src/affichage/ui/game/images/games/velo.png");
		gameImage.put(5, "src/affichage/ui/game/images/games/valise.png");
		gameImage.put(6, "src/affichage/ui/game/images/games/souris.png");
		gameImage.put(7, "src/affichage/ui/game/images/games/girafe.png");
		gameImage.put(8, "src/affichage/ui/game/images/games/chameau.png");
		gameImage.put(9, "src/affichage/ui/game/images/games/rhume.png");
		gameImage.put(10, "src/affichage/ui/game/images/games/chapeau.png");
		gameImage.put(11, "src/affichage/ui/game/images/games/rose.png");
		gameImage.put(12, "src/affichage/ui/game/images/games/deux.png");
		gameImage.put(13, "src/affichage/ui/game/images/games/couteau.png");
		gameImage.put(14, "src/affichage/ui/game/images/games/main.png");
		gameImage.put(15, "src/affichage/ui/game/images/games/faché.png");
		gameImage.put(16, "src/affichage/ui/game/images/games/vague.png");
		gameImage.put(17, "src/affichage/ui/game/images/games/bebe.png");
		gameImage.put(18, "src/affichage/ui/game/images/games/carreau.png");
		gameImage.put(19, "src/affichage/ui/game/images/games/de.png");
		
		
		
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
		
		/*
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
		lion.add("mou -");
		lion.add(" fa");
		lion.add("sa");
		
		ArrayList<String> oiseau =  new ArrayList<String>();
		oiseau.add("oi -");
		oiseau.add(" seau");
		
		ArrayList<String> gare =  new ArrayList<String>();
		gare.add("ga -");
		gare.add(" re");
		
		ArrayList<String> chat =  new ArrayList<String>();
		chat.add("chat");
		*/
		
		Dico dico = new Dico();
		
		for(int i = 0; i < 20; i++){
			gameWord.add(dico.getDictionnaire().get(i).getSyllIntGraph());

		}
		
		/*
		
		gameWord.add(maison);
		gameWord.add(oiseau);
		gameWord.add(dico.getDictionnaire().get(2).getSyllIntGraph());
		gameWord.add(lion);
		gameWord.add(voiture);
		gameWord.add(jouet);
		gameWord.add(gare);*/
	}
	
	private void setGameCible(){
		
		ArrayList<Cible> voiture = new ArrayList<Cible>();
		
		gameCible.put(0, voiture);
	}
	
	public Dico getDico(){
		return this.dico;
	}
	
	public ArrayList<Cible> getGameCible(int i){
		return gameCible.get(i);
	}
	
	private void setGameText(){
		
		gameText.put(0, gameWord.get(0));
		gameText.put(1, gameWord.get(1));
		gameText.put(2, gameWord.get(2));
		gameText.put(3, gameWord.get(3));
		gameText.put(4, gameWord.get(4));
		gameText.put(5, gameWord.get(5));
		gameText.put(6, gameWord.get(6));
		
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
