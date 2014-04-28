package affichage.ui.game;

import java.util.Hashtable;

import affichage.ui.OptionMenu.TextPanel;

public class DrawingGameModel {
	
		/* Hand Speak Game   */
	private    Hashtable<Integer, String> 		gameImage 				= 	new Hashtable<Integer, String>();
	private    Hashtable<Integer, String> 		gameText 				= 	new Hashtable<Integer, String>();
	private    Hashtable<String,  String> 		lisaTalkText 			= 	new Hashtable<String,String>(); 
	private    ThreadTimeCount					currentThreadTimeCount 	= 	null;
	private		String      					currentWord  			= 	"Clic Start!";
	private    String 							gameLevel				=	"facile";
	private    String 							gameProcess				= 	"level";
	private    TextPanel  						textPanel           	= 	null;
	private    GameImagePanel 					gameImagePanel			=	null;
	private 	GameCiblePanel 					gameCiblePanel			= 	null;
	private 	ScorePanel						scorePanel				= 	null;
	private    boolean							gameThreadRunning		= 	false;
	private		boolean 						rightAnswer				=	true;
	private		boolean 						gameStart				=	false;
	private    int         					currentScore       		= 	0;
	private 	int 							currentLevel			=	1;


	public DrawingGameModel(){
		setGameImage();
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
		gameImage.put(1, "src/affichage/ui/game/images/car.png");
		gameImage.put(2, "src/affichage/ui/game/images/maison.jpg");
		gameImage.put(3, "src/affichage/ui/game/images/maison.jpg");
		gameImage.put(4, "src/affichage/ui/game/images/car.png");
		
	}
	
	private void setLisaTalkText(){
	
		lisaTalkText.put("level", "Choisissez un niveau de difficulité:");
		lisaTalkText.put("welcomeeasy", "Bravo, t'as choisi le niveau facile!");
		lisaTalkText.put("welcomemoyen", "Bravo, t'as choisi le niveau moyen!");
		lisaTalkText.put("welcomedifficult", "Bravo, t'as choisi le niveau dur!");
		lisaTalkText.put("start", "Clic le boutton pour démmarer Le jeux.");
		
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
	
	private void setGameText(){
		
		gameText.put(1, "BNUI");
		gameText.put(2, " G  ");
		gameText.put(3, "ICHG");
		gameText.put(4, "YNG ");
		gameText.put(5, "KVZ ");
		gameText.put(6, "MTF ");
		gameText.put(7, "PDJ ");
		gameText.put(0, "SR  ");
		
	}
	
	public String getGameText(int i){
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

}
