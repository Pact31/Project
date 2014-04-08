package reconnaissance;

import classif.Cible;
import classif.ClassificateurInterface;

public interface ReconnaissanceInterface {
	
	public void setTime(long time);

	public long getTime();
	
	public Cible reconnaitre(Cible cible);

}
