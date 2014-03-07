package classif;

import classif.classification.Cible;
import classif.classification.Entree;

public interface ClassifierInterface {
	Cible predict(Entree e) throws Exception;
}
