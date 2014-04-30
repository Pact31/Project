package integration;

public class Dictionnary {//il faut enlever tout les mot avec autre chose que deux syllabes ou sinon faire une méthode pour retourner le nbr de syllabes en fonction du mot
private String[][] dico;


public void init(){
	this.dico = new String[8][5];
	this.dico[0][0]="peu";
	this.dico[0][1]="pa";
	this.dico[0][2]="pi";
	this.dico[0][3]="pou";
	this.dico[0][4]="pu";
	this.dico[1][0]="keu";
	this.dico[1][1]="ka";
	this.dico[1][2]="ki";
	this.dico[1][3]="kou";
	this.dico[1][4]="ku";
	this.dico[2][0]="seu";
	this.dico[2][1]="sa";
	this.dico[2][2]="si";
	this.dico[2][3]="sou";
	this.dico[2][4]="su";
	this.dico[3][0]="beu";
	this.dico[3][1]="ba";
	this.dico[3][2]="bi";
	this.dico[3][3]="bou";
	this.dico[3][4]="bu";
	this.dico[4][0]="meu";
	this.dico[4][1]="ma";
	this.dico[4][2]="mi";
	this.dico[4][3]="mou";
	this.dico[4][4]="mu";
	this.dico[5][0]="leu";
	this.dico[5][1]="la";
	this.dico[5][2]="li";
	this.dico[5][3]="lou";
	this.dico[5][4]="lu";
	this.dico[6][0]="gueu";
	this.dico[6][1]="ga";
	this.dico[6][2]="gui";
	this.dico[6][3]="gou";
	this.dico[6][4]="gu";
	this.dico[7][0]="yeu";
	this.dico[7][1]="ya";
	this.dico[7][2]="yi";
	this.dico[7][3]="you";
	this.dico[7][4]="yu";
}
public String get(int i,int j){
	return (this.dico[i][j]);
}
public void changedico(String nom){//cette succession de if ne fonctionnera pas... il faut tout refaire
	if (nom=="papa"||nom=="salle"||nom=="papi"||nom=="mami"||nom=="gomme"||nom=="page"||nom=="cage"||nom=="bille"||nom=="mousse"||nom=="balle"||nom=="masque"||nom=="caillou"||nom=="mal"){}
	else if (nom=="chat"||nom=="canne"||nom=="chapeau"||nom=="souche"||nom=="chaud"||nom=="chameau"||nom=="chou"||nom=="chevaux"||nom=="cheveux"||nom=="bouche"||nom=="lache"||nom=="couhe"||nom=="mouche"){//enlever chat, chaud, chou
		this.dico[5][0]="cheu";
		this.dico[5][1]="cha";
		this.dico[5][2]="chon";
		this.dico[5][3]="chou";
		this.dico[5][4]="chu";	
		this.dico[3][0]="neu";	
	}
	else if(nom=="garage"||nom=="barre"||nom=="case"||nom=="base"||nom=="rhume"||nom=="gare"||nom=="riz"||nom=="mer"||nom=="rose"||nom=="rat"||nom=="rue"||nom=="peur"||nom=="carreaux"||nom=="riche"){//enlever riz, rat, rue, garage
		this.dico[2][0]="reu";
		this.dico[2][1]="ra";
		this.dico[2][2]="ri";
		this.dico[2][3]="ro";
		this.dico[1][0]="zeu";
		this.dico[2][4]="ru";
		this.dico[5][0]="cheu";
		
	}
    else if(nom=="deux"||nom=="dame"|nom=="dent"||nom=="vent"||nom=="devant"||nom=="vol"||nom=="dé"||nom=="douze"||nom=="zoo"||nom=="donner"||nom=="nouveau"||nom=="vase"){//il faut enlever deux, dent, vent, dé, zoo
    	this.dico[0][0]="deu";
    	this.dico[0][1]="da";
    	this.dico[0][2]="don";
    	this.dico[0][3]="dou";
    	this.dico[0][4]="dé";
    	this.dico[1][0]="veu";
    	this.dico[1][1]="va";
    	this.dico[1][2]="von";
    	this.dico[1][3]="vo";
    	this.dico[1][4]="vu";
    	this.dico[1][0]="zeu";
    	this.dico[1][1]="za";
    	this.dico[1][2]="zi";
    	this.dico[1][3]="zo";
    	this.dico[1][4]="zu";
    	this.dico[3][0]="neu";
    	this.dico[3][1]="na";
    	this.dico[3][2]="ni";
    	this.dico[3][3]="nou";
    	this.dico[3][4]="né";
}
	else if(nom=="télé"||nom=="tour"||nom=="route"||nom=="huit"||nom=="oui"){//il faut enlever 'oui'
		this.dico[5][0]="teu";
		this.dico[5][1]="ta";
		this.dico[5][2]="ti";
		this.dico[5][3]="tou";
		this.dico[5][4]="té";
		this.dico[2][0]="reu";
		this.dico[2][1]="ra";
		this.dico[2][2]="ri";
		this.dico[2][3]="rou";
		this.dico[2][4]="ru";
		this.dico[5][0]="weu";
		this.dico[5][1]="wa";
		this.dico[5][2]="wi";
		this.dico[5][3]="wou";
		this.dico[5][4]="wu";
	}

	else if(nom=="fille"||nom=="file"||nom=="fumée"||nom=="feuille"||nom=="feu"||nom=="facile"||nom=="faché"){//il faut enlever facile
		this.dico[4][0]="feu";
		this.dico[4][1]="fa";
		this.dico[4][2]="fi";
		this.dico[4][3]="fou";
		this.dico[4][4]="fé";
		this.dico[5][4]="ché";
	}else if(nom=="nid"||nom=="nager"||nom=="jus"||nom=="juge"||nom=="garage"||nom=="giraffe"){//il faut enlever giraffe et garage et nid, et garage apparait deux fois
		this.dico[3][0]="neu";
		this.dico[3][1]="na";
		this.dico[3][2]="ni";
		this.dico[3][3]="nou";
		this.dico[3][4]="né";
		this.dico[0][0]="jeu";
		this.dico[0][1]="ja";
		this.dico[0][2]="ji";
		this.dico[0][3]="jou";
		this.dico[0][4]="ju";
		this.dico[2][0]="reu";
		this.dico[2][1]="ra";
		this.dico[2][2]="ri";
		this.dico[2][3]="rou";
		this.dico[2][4]="ru";
		this.dico[4][0]="feu";
	}
	else if(nom=="vague"||nom=="valise"||nom=="cave"){//il faut enlever valise
		this.dico[1][0]="veu";
		this.dico[1][1]="va";
		this.dico[1][2]="vi";
		this.dico[1][3]="vou";
		this.dico[1][4]="vu";
	}
	else if(nom=="bébé"||nom=="couteau"||nom=="belle"||nom=="bếte"){
		this.dico[4][0]="teu";
		this.dico[4][3]="to";
		this.dico[3][4]="bé";
	}
	else if(nom=="main"||nom=="faim"){//enlever les deux
		this.dico[4][0]="min";
	}else if(nom=="non"){
			this.dico[3][0]="neu";
			this.dico[3][1]="na";
			this.dico[3][2]="non";
			this.dico[3][3]="nou";
			this.dico[3][4]="né";	
	}
	else if(nom=="faim"){//pourquoi "faim" apparait-il en double?
		this.dico[4][0]="fin";
		
	}
	else if(nom=="souris"||nom=="midi"){
		this.dico[2][2]="ri";
		this.dico[0][2]="di";
		
	}
	else if(nom=="vélo"){
		this.dico[2][4]="vé";
	}
	
}
}
