package integration;

import java.util.ArrayList;

import classif.Cible;

public class Mot {
	private String mot;
	private ArrayList<String> syllSynVoc;
	private ArrayList<String> syllIntGraph;
	private ArrayList<Cible> cibles;
	
	public Mot(String mot, ArrayList<String> syllSynVoc,
			ArrayList<String> syllIntGraph, ArrayList<Cible> cibles) {
		super();
		this.mot = mot;
		this.syllSynVoc = syllSynVoc;
		this.syllIntGraph = syllIntGraph;
		this.cibles = cibles;
	}

	public String getMot() {
		return mot;
	}

	public ArrayList<String> getSyllSynVoc() {
		return syllSynVoc;
	}

	public ArrayList<String> getSyllIntGraph() {
		return syllIntGraph;
	}

	public ArrayList<Cible> getCibles() {
		return cibles;
	}
	
	

}
