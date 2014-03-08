package classification;

public interface ClassificateurInterface {

	public Cible classifier(Entree entree);
	
	public float test(BanqueApprentissage BanqueApprentissage);
	public float crossTest(int n);
}
