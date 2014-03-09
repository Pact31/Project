package classification;

/*******************************************************
 *                                                     *
 *  Implemente un couple de banque d'apprentissage     *
 *  de maniere a faire des test croises                *
 *                                                     *
 *******************************************************/

public class CoupleBanqueApprentissage {

	/****************Attributs*******************/
	
	private BanqueApprentissage banqueClassificateur;
	private BanqueApprentissage banqueTest;


	/******************Constructeur*****************/
	
	public CoupleBanqueApprentissage(BanqueApprentissage banqueApprentissage,	BanqueApprentissage banqueTest) {
		this.banqueClassificateur = banqueApprentissage;
		this.banqueTest = banqueTest;
	}


	/****************Getters & Setters*****************************/
	
	public BanqueApprentissage getBanqueClassificateur() {
		return banqueClassificateur;
	}


	public void setBanqueClassificateur(BanqueApprentissage banqueClassificateur) {
		this.banqueClassificateur = banqueClassificateur;
	}


	public BanqueApprentissage getBanqueTest() {
		return banqueTest;
	}


	public void setBanqueTest(BanqueApprentissage banqueTest) {
		this.banqueTest = banqueTest;
	}



}
