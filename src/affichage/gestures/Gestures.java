package affichage.gestures;


public class Gestures 
implements GesturesInterface
{
	
	private int width	= 100;
	private int height  = 100;
	private int x	=	0;
	private int y	=	0;
	
	public Gestures(int x, int y){
		this.x	=	x;
		this.y	=	y;
	}

	public Gestures(int x, int y, int w, int h){
		this.x	=	x;
		this.y	=	y;
		this.width	=	w;
		this.height	=	h;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}
	
	@Override
	public int getWidth(){
		return width;
	}
	
	@Override
	public int getHeight(){
		return height;
	}
	
}
