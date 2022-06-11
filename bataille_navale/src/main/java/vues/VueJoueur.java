package vues;
import controleurs.ControleurJoueur;
import utils.Coordonnees;

import java.util.Scanner;

public class VueJoueur {

	private ControleurJoueur joueur;
	private Scanner clavier;

	
	public VueJoueur(ControleurJoueur joueur) {
		this.joueur=joueur;
		this.clavier = new Scanner(System.in);
	}

	

	public Coordonnees demanderCoordonnees(){
		System.out.print("coordonnees? (ex: A5) : ");
		String rep=this.clavier.nextLine();
		Coordonnees coordonnees=new Coordonnees(rep);
		if (coordonnees.valides()==false) {
			coordonnees.x=0;
			coordonnees.y=0;
		}
		return coordonnees;
	}

	public boolean EntreeClavierOrientation() {
		System.out.print("horizontal (H) ou vertical (V)?");
		String rep=this.clavier.nextLine();
		return (rep.charAt(0)=='H');
	}
	
	public boolean placerBateau(int numBateau) {
		System.out.println("placement du "+this.joueur.nomBateau(numBateau)+" de "+this.joueur.nomJoueur());
		Coordonnees coordonnees=demanderCoordonnees();
		boolean horizontal=this.EntreeClavierOrientation();
		return this.joueur.placerBateau(numBateau, coordonnees.x, coordonnees.y, horizontal);
	}

	public void annoncerTour(){
		System.out.println("c'est le tour de "+this.joueur.nomJoueur());
	}

	public void annoncerResultat(int touche, ControleurJoueur cible){
		if(touche==-1) {
			System.out.println("tir manque.");
		}
		else {
			if (cible.bateauPerdu(touche)) {
				System.out.println(this.joueur.nomBateau(touche)+" coule.");
			}else{
				System.out.println(this.joueur.nomBateau(touche)+" touche.");
			}
		}
	}

	public void annoncerVictoire(){
		System.out.println("bravo "+this.joueur.nomJoueur());
	}

}
