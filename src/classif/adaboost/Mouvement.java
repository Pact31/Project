package classif.adaboost;

import classif.classification.Entree;

public class Mouvement {
	
	private final double[] car;
	
	public Mouvement (Entree e){
		this.car = new double[23];
		double X1=(e.getD1().getX()-e.getM().getX());
		double Y1=(e.getD1().getY()-e.getM().getY());
		double Z1=(e.getD1().getZ()-e.getM().getZ());
		double X2=(e.getD2().getX()-e.getM().getX());
		double Y2=(e.getD2().getY()-e.getM().getY());
		double Z2=(e.getD2().getZ()-e.getM().getZ());
		double X3=(e.getD3().getX()-e.getM().getX());
		double Y3=(e.getD3().getY()-e.getM().getY());
		double Z3=(e.getD3().getZ()-e.getM().getZ());
		double X4=(e.getD4().getX()-e.getM().getX());
		double Y4=(e.getD4().getY()-e.getM().getY());
		double Z4=(e.getD4().getZ()-e.getM().getZ());
		double X5=(e.getD5().getX()-e.getM().getX());
		double Y5=(e.getD5().getY()-e.getM().getY());
		double Z5=(e.getD5().getZ()-e.getM().getZ());
		
		double length1 = Math.sqrt(Math.pow(X1, 2)+Math.pow(Y1, 2)+Math.pow(Z1, 2));
		double length2 = Math.sqrt(Math.pow(X2, 2)+Math.pow(Y2, 2)+Math.pow(Z2, 2));
		double length3 = Math.sqrt(Math.pow(X3, 2)+Math.pow(Y3, 2)+Math.pow(Z3, 2));
		double length4 = Math.sqrt(Math.pow(X4, 2)+Math.pow(Y4, 2)+Math.pow(Z4, 2));
		double length5 = Math.sqrt(Math.pow(X5, 2)+Math.pow(Y5, 2)+Math.pow(Z5, 2));
		
		
		this.car[0]=X1/length1;
		this.car[1]=Y1/length1;
		this.car[2]=Z1/length1;
		this.car[3]=X2/length2;
		this.car[4]=Y2/length2;
		this.car[5]=Z2/length2;
		this.car[6]=X3/length3;
		this.car[7]=Y3/length3;
		this.car[8]=Z3/length3;
		this.car[9]=X4/length4;
		this.car[10]=Y4/length4;
		this.car[11]=Z4/length4;
		this.car[12]=X5/length5;
		this.car[13]=Y5/length5;
		this.car[14]=Z5/length5;
		this.car[15]=e.getM().getX();
		this.car[16]=e.getM().getY();
		this.car[17]=e.getM().getZ();
		
		if((e.getD1().getX()!=0||e.getD1().getY()!=0||e.getD1().getZ()!=0)&&(e.getD2().getX()!=0||e.getD2().getY()!=0||e.getD2().getZ()!=0)){
			double product1 = X1*X2+Y1*Y2+Z1*Z2;
			double cos1 = Math.abs(product1/(length1*length2));
			this.car[18] = Math.acos(cos1);
		}
		else{
			this.car[18]=0;
		}
		
		if((e.getD2().getX()!=0||e.getD2().getY()!=0||e.getD2().getZ()!=0)&&(e.getD3().getX()!=0||e.getD3().getY()!=0||e.getD3().getZ()!=0)){
			double product2 = X3*X2+Y3*Y2+Z3*Z2;
			double cos2 = Math.abs(product2/(length3*length2));
			this.car[19] = Math.acos(cos2);
		}
		else{
			this.car[19]=0;
		}
		
		if((e.getD3().getX()!=0||e.getD3().getY()!=0||e.getD3().getZ()!=0)&&(e.getD4().getX()!=0||e.getD4().getY()!=0||e.getD4().getZ()!=0)){
			double product3 = X3*X4+Y3*Y4+Z3*Z4;
			double cos3 = Math.abs(product3/(length3*length4));
			this.car[20] = Math.acos(cos3);
		}
		else{
			this.car[20]=0;
		}
		
		if((e.getD4().getX()!=0||e.getD4().getY()!=0||e.getD4().getZ()!=0)&&(e.getD5().getX()!=0||e.getD5().getY()!=0||e.getD5().getZ()!=0)){
			double product4 = X4*X5+Y4*Y5+Z4*Z5;
			double cos4 = Math.abs(product4/(length4*length5));
			this.car[21] = Math.acos(cos4);
		}
		else{
			this.car[21]=0;
		}
		
		if(e.getD1().getX()!=0||e.getD1().getY()!=0||e.getD1().getZ()!=0){
			this.car[22]++;
		}
		if(e.getD2().getX()!=0||e.getD2().getY()!=0||e.getD2().getZ()!=0){
			this.car[22]++;
		}
		if(e.getD3().getX()!=0||e.getD3().getY()!=0||e.getD3().getZ()!=0){
			this.car[22]++;
		}
		if(e.getD4().getX()!=0||e.getD4().getY()!=0||e.getD4().getZ()!=0){
			this.car[22]++;
		}
		if(e.getD5().getX()!=0||e.getD5().getY()!=0||e.getD5().getZ()!=0){
			this.car[22]++;
		}
	}

	public double[] getCar() {
		return car;
	}
	
	
}
