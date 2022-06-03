package modeles;

public class ModeleJoueur {

	private int idJoueur;
	public ModeleGrille grille;
	
	
	public ModeleJoueur(int idJoueur) {
		this.idJoueur=idJoueur;
		this.grille=new ModeleGrille();
	}

	public boolean perdu() {
		return this.grille.tousCoules();
	}
	
	public boolean essuyerTir(int coordoneeHorizontale, int coordoneeVerticale) {
		return this.grille.essuyerTir(coordoneeHorizontale, coordoneeVerticale);
	}
	
	public boolean placerBateau(int numBateau, int coordoneeHorizontale, int coordoneeVerticale, boolean horizontal) {
		return this.grille.placerBateau(numBateau, coordoneeHorizontale, coordoneeVerticale, horizontal);
	}
}
