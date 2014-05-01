package affichage.gestures;


public class Hand 
{
	
	private int width	= 100;
	private int height  = 100;
	private int x	=	0;
	private int y	=	0;
	
	public Hand(int x, int y){
		this.x	=	x;
		this.y	=	y;
	}

	public Hand(int x, int y, int w, int h){
		this.x	=	x;
		this.y	=	y;
		this.width	=	w;
		this.height	=	h;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
}
