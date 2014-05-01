package affichage.gestures;


public class Gestures 
{
	
	private final String c;
	private final String v;
	
	public Gestures(String c, String v){
		this.v = v;
		this.c = c;
	}
	
	public String getVoyelle(){
		
		return "src/affichage/images/cible/" + v + ".png";
	}
	
	public String getConsone(){
		
		return "src/affichage/images/cible/" + c + ".png";
	}
	
	public String getV(){
		return v;
	}
	
	public String getC(){
		return c;
	}
	
}
