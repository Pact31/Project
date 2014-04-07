package classif;

/******************************************************
 *                                                    *
 *        Correspond aux huits clefs de la LPC        *
 *                                                    *
 *                                                    *
 ******************************************************/



public enum Cible {
	/* 
	 * La premiere partir correspond aux consonnes codees par les clefs
	 * La deuxieme represente la position de la main : Gorge, Menton, Bouche, Cote, Pommette.
	 */
  	PDJ_G, PDJ_M, PDJ_B, PDJ_C, PDJ_P,
  	KVZ_G, KVZ_M, KVZ_B, KVZ_C, KVZ_P, 
  	SR_G, SR_M, SR_B, SR_C, SR_P, 
  	BNUI_G, BNUI_M, BNUI_B, BNUI_C, BNUI_P,
  	MTF_G, MTF_M, MTF_B, MTF_C, MTF_P,
  	ICHGNW_G, ICHGNW_M, ICHGNW_B, ICHGNW_C, ICHGNW_P,
  	G_G, G_M, G_B, G_C, G_P,
  	YNG_G, YNG_M, YNG_B, YNG_C, YNG_P; 
}
