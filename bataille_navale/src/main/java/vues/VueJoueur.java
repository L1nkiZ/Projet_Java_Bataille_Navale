package vues;
import controleurs.ControleurJoueur;
import java.util.Scanner;

public class VueJoueur {

	private ControleurJoueur joueur;
	
	public VueJoueur(ControleurJoueur joueur) {
		this.joueur=joueur;
	}

	
	public int EntreeClavierInt(String message) {
		System.out.print(message);
		Scanner clavier = new Scanner(System.in);
		int rep=clavier.nextInt();
		return rep;
	}
	
	public boolean EntreeClavierOrientation() {
		System.out.print("horizontal (H) ou vertical (V)?");
		Scanner clavier = new Scanner(System.in);
		String rep=clavier.nextLine();
		return (rep.charAt(0)=='H');
	}
	
	public boolean placerBateau(int numBateau) {
		int coordoneeHorizontale=this.EntreeClavierInt("x?");
		int coordoneeVerticale=this.EntreeClavierInt("y?");
		boolean horizontal=this.EntreeClavierOrientation();
		return this.joueur.placerBateau(numBateau, coordoneeHorizontale, coordoneeVerticale, horizontal);
	}
}
