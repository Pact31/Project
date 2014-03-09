package classif.classification;
import java.util.ArrayList;
import java.util.Iterator;

import classif.kppv.Distances;
import classif.kppv.Kppv;
import classif.kppv.Voisins;
import LeapTS.LeapData;
import leapmotion.LeapDataBase;

/*******************************************************************************************
 *   BanqueApprentissage est une ArrayList d'Apprentissages                                *
 *                                                                                         *
 *   Cette classe implemente l'interface Iterator pour parcourir tous ses elements         * 
 *                                                                                         *
 *    CONSTRUCTEUR : - Creation d'une nouvelle base vide                                   *
 *    				 - Importation d'une base a partir d'une base de dnnees LeapDataBase   *
 *                                                                                         *
 * *****************************************************************************************/


public class BanqueApprentissage implements Iterator<Apprentissage>{

	/*****************Attributs**************************/
	
	private ArrayList<Apprentissage> banque;
	private Iterator<Apprentissage> iterator;

	
	
	/*****************Constructeurs**********************/
	
	public BanqueApprentissage(){
		this.banque=new ArrayList<Apprentissage>();
	}
	
	public BanqueApprentissage(LeapDataBase leapDataBase){
		this.banque=new ArrayList<Apprentissage>();
		for(LeapData leapData : leapDataBase.table){
			Apprentissage apprentissage = new Apprentissage(leapData, leapData.getCible());
			this.banque.add(apprentissage);
		}
	}
	
	public BanqueApprentissage(String file) throws Exception{
		LeapDataBase leapDataBase = new LeapDataBase(file);
		this.banque=new ArrayList<Apprentissage>();
		for(LeapData leapData : leapDataBase.table){
			Apprentissage apprentissage = new Apprentissage(leapData, leapData.getCible());
			this.banque.add(apprentissage);
		}
	}
	
	public BanqueApprentissage(ArrayList<Apprentissage> listApprentissage){
		this.banque = new ArrayList<Apprentissage>();
		this.banque = listApprentissage;
	}
	
	public Iterator<Apprentissage> iterator(){
		this.iterator = banque.iterator();
		return this.iterator;
	}
	
	
	/******************Getters*****************************/
	
	public ArrayList<Apprentissage> getAllApprentissage(){
		return banque;
	}

	public Apprentissage getApprentissage(int i){
		return this.banque.get(i);
	}
	
	
	
	/*******************Methodes diverses*******************/
	
		//Ajouter un element a la base
	public void addApprentissage(Apprentissage apprentissage){
		this.banque.add(apprentissage);
	}
	
		//Concatene deux banques
	public void addBanqueApprentissage(BanqueApprentissage banqueApprentissage){
		this.banque.addAll(banqueApprentissage.getAllApprentissage());
	}
	
    public BanqueApprentissage subBanqueApprentissage(int fromIndex, int toIndex){
    	return (new BanqueApprentissage(banque.subList(fromIndex, toIndex)));
    }
		//Taille de la base
	public int size(){
		return this.banque.size();
	}

		//donne les k plus proches voisins d'une entree
	public Voisins getVoisins(int k, Entree entree){
	
		Voisins v=new Voisins();
		Distances d=new Distances();
		double dist = 1000;
		int indiceDist=0;
	
		for (int i=0; i<k; i++){
			v.add(getApprentissage(i));
			d.add(entree.getDistance(getApprentissage(i)));
		}
	
		for (int i=k; i<size(); i++){
			indiceDist=d.indiceLePlusLoin();
			dist=d.get(indiceDist);
			if(entree.getDistance(getApprentissage(i))<dist){
				v.set(indiceDist,getApprentissage(i));
				d.set(indiceDist,entree.getDistance(getApprentissage(i)));
			}
		}
		return v;
	}

	
		//Donne le nombre de representants de chaque cible parmis les k plus proches voisins
	public int[] countCible(int k, Entree entree){
		Apprentissage pivot;
		Voisins v=getVoisins(k, entree);
		int compteur[]={0,0,0,0,0,0,0,0};
		Cible c[]=Cible.values();
		for(int i =0; i<v.size();i=i+1){
			pivot=v.get(i);
			int p=0;
			while(pivot.getCible().equals(c[p])==false && p<8) p=p+1;
			compteur[p]=compteur[p]+1;
		}
		return compteur;
	}
	
	//Renvoit la liste des apprentissages correspondant a la cible donnee
	public BanqueApprentissage BanqueApprentissageCible(Cible cible){
		BanqueApprentissage BanqueApprentissageCible = new BanqueApprentissage();
		for(Apprentissage apprentissage : this.banque){
			if (apprentissage.getCible() == cible){
				BanqueApprentissageCible.addApprentissage(apprentissage);
			}
		}
		return BanqueApprentissageCible;
	}
	
	//Renvoit une lisste de CoupleBanqueApprentissage ou chaque base de Test a une longueur 0,6*taille base
	public ArrayList<CoupleBanqueApprentissage> divise(){
		
		int l = (int) 0.6 * this.size();
		
		ArrayList<CoupleBanqueApprentissage> banques = new ArrayList<CoupleBanqueApprentissage>();
				
		BanqueApprentissage banqueApprentissagePDJ = BanqueApprentissageCible(Cible.PDJ);
		BanqueApprentissage banqueApprentissageKVZ = BanqueApprentissageCible(Cible.KVZ);
		BanqueApprentissage banqueApprentissageSR = BanqueApprentissageCible(Cible.SR);
		BanqueApprentissage banqueApprentissageBNUI = BanqueApprentissageCible(Cible.BNUI);
		BanqueApprentissage banqueApprentissageMTF = BanqueApprentissageCible(Cible.MTF);
		BanqueApprentissage banqueApprentissageICHGNW = BanqueApprentissageCible(Cible.ICHGNW);
		BanqueApprentissage banqueApprentissageG = BanqueApprentissageCible(Cible.G);
		BanqueApprentissage banqueApprentissageYNG = BanqueApprentissageCible(Cible.YNG);
		
		int sizePDJ = banqueApprentissagePDJ.size();
		int sizeKVZ = banqueApprentissagePDJ.size();
		int sizeSR = banqueApprentissagePDJ.size();
		int sizeBNUI = banqueApprentissagePDJ.size();
		int sizeMTF = banqueApprentissagePDJ.size();
		int sizeICHGNW = banqueApprentissagePDJ.size();
		int sizeG = banqueApprentissagePDJ.size();
		int sizeYNG = banqueApprentissagePDJ.size();
		
		
		int iPDJ = 0;
		int iKVZ = 0;
		int iSR = 0;
		int iBNUI = 0;
		int iMTF = 0;
		int iICHGNW = 0;
		int iG = 0;
		int iYNG = 0;
		
		int jPDJ = l;
		int jKVZ = l;
		int jSR = l;
		int jBNUI = l;
		int jMTF = l;
		int jICHGNW = l;
		int jG = l;
		int jYNG = l;
		
		while((jPDJ < sizePDJ) ||
			  (jKVZ < sizePDJ) ||
			  (jSR < sizePDJ) ||
			  (jBNUI < sizePDJ) ||
			  (jMTF < sizePDJ) ||
			  (jICHGNW < sizePDJ) ||
			  (jG < sizePDJ) ||
			  (jYNG < sizePDJ)){

			BanqueApprentissage currentBanqueTest = new BanqueApprentissage();
			currentBanqueTest.addBanqueApprentissage(banqueApprentissagePDJ.subBanqueApprentissage(iPDJ, jPDJ));
			currentBanqueTest.addBanqueApprentissage(banqueApprentissageKVZ.subBanqueApprentissage(iKVZ, jKVZ));
			currentBanqueTest.addBanqueApprentissage(banqueApprentissageSR.subBanqueApprentissage(iSR, jSR));
			currentBanqueTest.addBanqueApprentissage(banqueApprentissageBNUI.subBanqueApprentissage(iBNUI, jBNUI));
			currentBanqueTest.addBanqueApprentissage(banqueApprentissageMTF.subBanqueApprentissage(iMTF, jMTF));
			currentBanqueTest.addBanqueApprentissage(banqueApprentissageICHGNW.subBanqueApprentissage(iICHGNW, jICHGNW));
			currentBanqueTest.addBanqueApprentissage(banqueApprentissageG.subBanqueApprentissage(iG, jG));
			currentBanqueTest.addBanqueApprentissage(banqueApprentissageYNG.subBanqueApprentissage(iYNG, jYNG));
			
			BanqueApprentissage currentBanqueApprentissage = new BanqueApprentissage();
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissagePDJ.subBanqueApprentissage(0,iPDJ));
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissageKVZ.subBanqueApprentissage(0,iKVZ));
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissageSR.subBanqueApprentissage(0,iSR));
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissageBNUI.subBanqueApprentissage(0,iBNUI));
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissageMTF.subBanqueApprentissage(0,iMTF));
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissageICHGNW.subBanqueApprentissage(0,iICHGNW));
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissageG.subBanqueApprentissage(0,iG));
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissageYNG.subBanqueApprentissage(0,iYNG));
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissagePDJ.subBanqueApprentissage(jPDJ,sizePDJ));
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissageKVZ.subBanqueApprentissage(jKVZ,sizeKVZ));
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissageSR.subBanqueApprentissage(jSR,sizeSR));
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissageBNUI.subBanqueApprentissage(jBNUI,sizeBNUI));
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissageMTF.subBanqueApprentissage(jMTF,sizeMTF));
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissageICHGNW.subBanqueApprentissage(jICHGNW,sizeICHGNW));
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissageG.subBanqueApprentissage(jG,sizeG));
			currentBanqueApprentissage.addBanqueApprentissage(banqueApprentissageYNG.subBanqueApprentissage(jYNG,sizeYNG));
			
			banques.add(new CoupleBanqueApprentissage(currentBanqueTest, currentBanqueApprentissage));
			
			iPDJ++;
			iKVZ++;
			iSR++;
			iBNUI++;
			iMTF++;
			iICHGNW++;
			iG++;
			iYNG++;
			
			jPDJ = iPDJ + l;
			jKVZ = iKVZ + l;
			jSR = iSR + l;
			jBNUI = iBNUI + l;
			jMTF = iMTF + l;
			jICHGNW = iICHGNW + l;
			jG = iG + l;
			jYNG = iYNG + l;
			
		}
		
		return banques;

	}
	
	
	/****************Iterator*******************/
	public boolean hasNext(){
		return iterator.hasNext();
	}
	
	public Apprentissage next(){
		return iterator.next();
	}
	
	public void remove(){
		iterator.remove();
	}
}
