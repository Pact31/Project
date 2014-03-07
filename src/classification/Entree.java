package classification;

import java.util.ArrayList;

import LeapTS.FingerTS;
import LeapTS.HandTS;
import LeapTS.VectorTS;



/***************************************************************************
 *                                                                         *
 *                                                                         *
 * Represente une main par la position de son centre et de ses cinq doigts *
 *                                                                         *
 *                                                                         *
 ***************************************************************************/


public class Entree {

	
	private VectorTS d1;
	private VectorTS d2;
	private VectorTS d3;
	private VectorTS d4;
	private VectorTS d5;
	private Point m;
	

	public Entree(VectorTS d1, VectorTS d2, VectorTS d3, VectorTS d4, VectorTS d5, Point m){

		this.d1=d1;
		this.d2=d2;
		this.d3=d3;
		this.d4=d4;
		this.d5=d5;
		this.m=m;
		

	}
	
	
	public Entree(ArrayList<FingerTS> fingerListTS, ArrayList<HandTS> handListTS){
		
		int fingerLength = fingerListTS.size();
		
		this.d1 = fingerListTS.get(0).getTipPosition();
		
	}


	public VectorTS getD1() {
		return d1;
	}

	public VectorTS getD2() {
		return d2;
	}
	public VectorTS getD3() {
		return d3;
	}
	public VectorTS getD4() {
		return d4;
	}
	public VectorTS getD5() {
		return d5;
	}
	public Point getM(){
		return m;
	}

	

}
