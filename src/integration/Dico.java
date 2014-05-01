package integration;

import java.util.ArrayList;

import classif.Cible;

public class Dico {
	private ArrayList<Mot> dictionnaire;

	public ArrayList<Mot> getDictionnaire() {
		return dictionnaire;
	}
	
	public Dico(){
		this.dictionnaire = new ArrayList<Mot>();
		//maison
				ArrayList<String> syllSynVoc = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph = new ArrayList<String>() ;
				ArrayList<Cible> cibles = new ArrayList<Cible>() ;

				syllSynVoc.add("mai"); syllSynVoc.add("zon");
				syllIntGraph.add("mai");syllIntGraph.add("son");
				cibles.add(Cible.MTF_M);cibles.add(Cible.KVZ_B);
				Mot maison = new Mot("maison",syllSynVoc,syllIntGraph,cibles) ;

				//oiseau
				ArrayList<String> syllSynVoc2 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph2 = new ArrayList<String>() ;
				ArrayList<Cible> cibles2 = new ArrayList<Cible>() ;

				syllSynVoc2.add("oi"); 
				syllSynVoc2.add("zo");
				syllIntGraph2.add("oi");
				syllIntGraph2.add("seau");
				cibles2.add(Cible.ICHGNW_C);
				cibles2.add(Cible.KVZ_C);
				Mot oiseau = new Mot("oiseau",syllSynVoc2,syllIntGraph2,cibles2) ;

				//chat
				ArrayList<String> syllSynVoc3 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph3 = new ArrayList<String>() ;
				ArrayList<Cible> cibles3 = new ArrayList<Cible>() ;

				syllSynVoc3.add("cha(court)"); 
				syllIntGraph3.add("chat");
				cibles3.add(Cible.ICHGNW_C);
				Mot chat = new Mot("chat",syllSynVoc3,syllIntGraph3,cibles3) ;

				//Mufasa
				ArrayList<String> syllSynVoc4 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph4 = new ArrayList<String>() ;
				ArrayList<Cible> cibles4 = new ArrayList<Cible>() ;

				syllSynVoc4.add("mou"); 
				syllSynVoc4.add("fa(court)");
				syllSynVoc4.add("sa(court)");
				syllIntGraph4.add("Mu");
				syllIntGraph4.add("fa");
				syllIntGraph4.add("sa");
				cibles4.add(Cible.MTF_M);
				cibles4.add(Cible.MTF_C);
				cibles4.add(Cible.SR_C);
				Mot Mufasa = new Mot("Mufasa",syllSynVoc4,syllIntGraph4,cibles4) ;

				//vélo
				ArrayList<String> syllSynVoc5 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph5 = new ArrayList<String>() ;
				ArrayList<Cible> cibles5 = new ArrayList<Cible>() ;

				syllSynVoc5.add("vé"); 
				syllSynVoc5.add("lo");
				syllIntGraph5.add("vé");
				syllIntGraph5.add("lo");
				cibles5.add(Cible.KVZ_C);
				cibles5.add(Cible.ICHGNW_C);
				Mot vélo = new Mot("vélo",syllSynVoc5,syllIntGraph5,cibles5) ;

				//valise
				ArrayList<String> syllSynVoc6 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph6 = new ArrayList<String>() ;
				ArrayList<Cible> cibles6 = new ArrayList<Cible>() ;

				syllSynVoc6.add("va"); 
				syllSynVoc6.add("li");
				syllSynVoc6.add("zeu(bleu)");
				syllIntGraph6.add("va");
				syllIntGraph6.add("li");
				syllIntGraph6.add("se");
				cibles6.add(Cible.KVZ_C);
				cibles6.add(Cible.ICHGNW_B);
				cibles6.add(Cible.KVZ_P);
				Mot valise = new Mot("valise",syllSynVoc6,syllIntGraph6,cibles6) ;

				//souris
				ArrayList<String> syllSynVoc7 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph7 = new ArrayList<String>() ;
				ArrayList<Cible> cibles7 = new ArrayList<Cible>() ;

				syllSynVoc7.add("sou"); 
				syllSynVoc7.add("ri");
				syllIntGraph7.add("sou");
				syllIntGraph7.add("ris");
				cibles7.add(Cible.SR_M);
				cibles7.add(Cible.SR_B);
				Mot souris = new Mot("souris",syllSynVoc7,syllIntGraph7,cibles7) ;

				//girafe
				ArrayList<String> syllSynVoc8 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph8 = new ArrayList<String>() ;
				ArrayList<Cible> cibles8 = new ArrayList<Cible>() ;

				syllSynVoc8.add("gi"); 
				syllSynVoc8.add("ra");
				syllSynVoc8.add("feu(bleu)");
				syllIntGraph8.add("gi");
				syllIntGraph8.add("ra");
				syllIntGraph8.add("fe");
				cibles8.add(Cible.PDJ_B);
				cibles8.add(Cible.SR_C);
				cibles8.add(Cible.MTF_P);
				Mot girafe = new Mot("girafe",syllSynVoc8,syllIntGraph8,cibles8) ;

				//chameau
				ArrayList<String> syllSynVoc9 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph9 = new ArrayList<String>() ;
				ArrayList<Cible> cibles9 = new ArrayList<Cible>() ;

				syllSynVoc9.add("cha(court)"); 
				syllSynVoc9.add("mo");
				syllIntGraph9.add("cha");
				syllIntGraph9.add("meau");
				cibles9.add(Cible.ICHGNW_C);
				cibles9.add(Cible.MTF_C);
				Mot chameau = new Mot("chameau",syllSynVoc9,syllIntGraph9,cibles9) ;

				//rhume
				ArrayList<String> syllSynVoc10 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph10 = new ArrayList<String>() ;
				ArrayList<Cible> cibles10 = new ArrayList<Cible>() ;

				syllSynVoc10.add("ru"); 
				syllSynVoc10.add("meu");
				syllIntGraph10.add("rhu");
				syllIntGraph10.add("me");
				cibles10.add(Cible.SR_G);
				cibles10.add(Cible.MTF_P);
				Mot  rhume  = new Mot("rhume",syllSynVoc10,syllIntGraph10,cibles10) ;

				//chapeau
				ArrayList<String> syllSynVoc11 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph11 = new ArrayList<String>() ;
				ArrayList<Cible> cibles11 = new ArrayList<Cible>() ;

				syllSynVoc11.add("cha(court)"); 
				syllSynVoc11.add("po(beau)");
				syllIntGraph11.add("cha");
				syllIntGraph11.add("peau");
				cibles11.add(Cible.ICHGNW_C);
				cibles11.add(Cible.PDJ_C);
				Mot chapeau = new Mot("chapeau",syllSynVoc11,syllIntGraph11,cibles11) ;

				//deux
				ArrayList<String> syllSynVoc12 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph12 = new ArrayList<String>() ;
				ArrayList<Cible> cibles12 = new ArrayList<Cible>() ;

				syllSynVoc12.add("deu(bleu)"); 
				syllIntGraph12.add("deux");
				cibles12.add(Cible.PDJ_P);
				Mot deux = new Mot("deux",syllSynVoc12,syllIntGraph12,cibles12) ;

				//rose
				ArrayList<String> syllSynVoc13 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph13 = new ArrayList<String>() ;
				ArrayList<Cible> cibles13 = new ArrayList<Cible>() ;

				syllSynVoc13.add("ro"); 
				syllSynVoc13.add("zeu(bleu)");
				syllIntGraph13.add("ro");
				syllIntGraph13.add("se");
				cibles13.add(Cible.SR_C);
				cibles13.add(Cible.KVZ_P);
				Mot rose = new Mot("rose",syllSynVoc13,syllIntGraph13,cibles13) ;

				//couteau
				ArrayList<String> syllSynVoc14 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph14 = new ArrayList<String>() ;
				ArrayList<Cible> cibles14 = new ArrayList<Cible>() ;

				syllSynVoc14.add("kou"); 
				syllSynVoc14.add("to(beau)");
				syllIntGraph14.add("cou");
				syllIntGraph14.add("teau");
				cibles14.add(Cible.KVZ_B);
				cibles14.add(Cible.MTF_C);
				Mot couteau = new Mot("couteau",syllSynVoc14,syllIntGraph14,cibles14) ;

				//main
				ArrayList<String> syllSynVoc15 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph15 = new ArrayList<String>() ;
				ArrayList<Cible> cibles15 = new ArrayList<Cible>() ;

				syllSynVoc15.add("main"); 
				syllIntGraph15.add("main");
				cibles15.add(Cible.MTF_P);
				Mot main  = new Mot("main",syllSynVoc15,syllIntGraph15,cibles15) ;

				//faché
				ArrayList<String> syllSynVoc16 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph16 = new ArrayList<String>() ;
				ArrayList<Cible> cibles16 = new ArrayList<Cible>() ;

				syllSynVoc16.add("fa(court)"); 
				syllSynVoc16.add("ché");
				syllIntGraph16.add("fa");
				syllIntGraph16.add("ché");
				cibles16.add(Cible.MTF_C);
				cibles16.add(Cible.ICHGNW_G);
				Mot faché = new Mot("faché",syllSynVoc16,syllIntGraph16,cibles16) ;

				//vague
				ArrayList<String> syllSynVoc17 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph17 = new ArrayList<String>() ;
				ArrayList<Cible> cibles17 = new ArrayList<Cible>() ;

				syllSynVoc17.add("va(court)"); 
				syllSynVoc17.add("geu(bleu)");
				syllIntGraph17.add("va");
				syllIntGraph17.add("gue");
				cibles17.add(Cible.KVZ_C);
				cibles17.add(Cible.G_P);
				Mot vague = new Mot("vague",syllSynVoc17,syllIntGraph17,cibles17) ;

				//bébé
				ArrayList<String> syllSynVoc18 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph18 = new ArrayList<String>() ;
				ArrayList<Cible> cibles18 = new ArrayList<Cible>() ;

				syllSynVoc18.add("bé"); 
				syllSynVoc18.add("bé");
				syllIntGraph18.add("bé");
				syllIntGraph18.add("bé");
				cibles18.add(Cible.BNUI_G);
				cibles18.add(Cible.BNUI_G);
				Mot bébé = new Mot("bébé",syllSynVoc18,syllIntGraph18,cibles18) ;

				//carreau
				ArrayList<String> syllSynVoc19 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph19 = new ArrayList<String>() ;
				ArrayList<Cible> cibles19 = new ArrayList<Cible>() ;

				syllSynVoc19.add("ka(court)"); 
				syllSynVoc19.add("ro");
				syllIntGraph19.add("ca");
				syllIntGraph19.add("rreau");
				cibles19.add(Cible.KVZ_C);
				cibles19.add(Cible.SR_M);
				Mot carreau = new Mot("carreau",syllSynVoc19,syllIntGraph19,cibles19) ;

				//dé
				ArrayList<String> syllSynVoc20 = new ArrayList<String>() ;
				ArrayList<String> syllIntGraph20 = new ArrayList<String>() ;
				ArrayList<Cible> cibles20 = new ArrayList<Cible>() ;

				syllSynVoc20.add("dé"); 
				syllIntGraph20.add("dé");
				cibles20.add(Cible.PDJ_G);
				Mot dé = new Mot("dé",syllSynVoc20,syllIntGraph20,cibles20) ;

				this.dictionnaire.add(maison);
				this.dictionnaire.add(oiseau);
				this.dictionnaire.add(chat);
				this.dictionnaire.add(Mufasa);
				this.dictionnaire.add(vélo);
				this.dictionnaire.add(valise);
				this.dictionnaire.add(souris);
				this.dictionnaire.add(girafe);
				this.dictionnaire.add(chameau);
				this.dictionnaire.add(rhume);
				this.dictionnaire.add(chapeau);
				this.dictionnaire.add(rose);
				this.dictionnaire.add(deux);
				this.dictionnaire.add(couteau);
				this.dictionnaire.add(main);
				this.dictionnaire.add(faché);
				this.dictionnaire.add(vague);
				this.dictionnaire.add(bébé);
				this.dictionnaire.add(carreau);
				this.dictionnaire.add(dé);

	}
}
