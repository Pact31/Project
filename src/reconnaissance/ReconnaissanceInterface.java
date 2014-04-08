package reconnaissance;

import classif.ClassificateurInterface;

public interface ReconnaissanceInterface {
	
	public void setClassificateur(ClassificateurInterface classificateur);
	
	public void setTiming(float timing);

	public ClassificateurInterface getCleassificateur();

	public float getTiming();

}
