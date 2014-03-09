package classification;

/*****************************************************
 *                                                   *
 *  La classe Classificateur est la classe mere des  *
 *  classificateurs kppv et adaboost                 *
 *                                                   *
 *****************************************************/

public interface ClassificateurInterface {

	//Applique la classification a l'Entree entree.
	public Cible classifier(Entree entree);
	
	//Effecctue un test du classificateur sur une banqueApprentissage de test.
	//Renvoit le taux de reussite.
	public float test(BanqueApprentissage BanqueTest);
	
	//Effectue un test croisee avec la banque d'apprentissage du classificateur.
	//Renvoit un taux de reussite.
	public float crossTest(int n);
}
