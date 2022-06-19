package modeles;
import interfaces.IJoueur;
import interfaces.IGrille;

public class ModeleJoueur implements IJoueur {



	private int idJoueur;
	public IGrille grille;
	
	
	public ModeleJoueur(int idJoueur) {
		this.idJoueur=idJoueur;
		this.grille=new ModeleGrille();
	}

	public String nomJoueur(){
		return "Joueur "+Integer.toString(this.idJoueur);
	}

	public boolean perdu() {
		return this.grille.tousCoules();
	}
	
	public int essuyerTir(int coordoneeHorizontale, int coordoneeVerticale) {
		return this.grille.essuyerTir(coordoneeHorizontale, coordoneeVerticale);
	}
	
	public boolean placerBateau(int numBateau, int coordoneeHorizontale, int coordoneeVerticale, boolean horizontal) {
		return this.grille.placerBateau(numBateau, coordoneeHorizontale, coordoneeVerticale, horizontal);
	}

	public boolean bateauPerdu(int numBateau){
		return this.grille.bateauPerdu(numBateau);
	}

	public void ecraserGrille(IGrille nouvelleGrille){
		this.grille=nouvelleGrille;
	}
}
