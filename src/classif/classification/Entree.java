package classif.classification;

import java.util.ArrayList;

import LeapTS.FingerTS;
import LeapTS.FrameTS;
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
	private VectorTS m;
	

	public Entree(VectorTS d1, VectorTS d2, VectorTS d3, VectorTS d4, VectorTS d5, VectorTS m){

		this.d1=d1;
		this.d2=d2;
		this.d3=d3;
		this.d4=d4;
		this.d5=d5;
		this.m=m;
		

	}
	
	
	public Entree(FrameTS frameTS){
		
		this.m = frameTS.getHandList().get(0).getPalmPosition();

		int fingerLength = frameTS.getFingerList().size();

		if(fingerLength >= 1){
			this.d1 = frameTS.getFingerList().get(0).getTipPosition().minus(this.m);
		} 
		else {
			this.d1 = new VectorTS(0,0,0);
		}

		if(fingerLength >= 2){
			this.d2 = frameTS.getFingerList().get(1).getTipPosition().minus(this.m);
		} 
		else {
			this.d2 = new VectorTS(0,0,0);
		}
		if(fingerLength >= 3){
			this.d3 = frameTS.getFingerList().get(2).getTipPosition().minus(this.m);
		} 
		else {
			this.d3 = new VectorTS(0,0,0);
		}
		if(fingerLength >= 4){
			this.d4 = frameTS.getFingerList().get(3).getTipPosition().minus(this.m);
		} 
		else {
			this.d4 = new VectorTS(0,0,0);
		}
		if(fingerLength >= 5){
			this.d5 = frameTS.getFingerList().get(4).getTipPosition().minus(this.m);
		} 
		else {
			this.d5 = new VectorTS(0,0,0);
		}
		
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
	public VectorTS getM(){
		return m;
	}

	

}
