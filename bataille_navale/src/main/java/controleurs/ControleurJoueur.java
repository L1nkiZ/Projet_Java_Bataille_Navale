package controleurs;
import modeles.ModeleJoueur;
import vues.VueJoueur;

public class ControleurJoueur {

	private ModeleJoueur mjoueur;
	private VueJoueur vjoueur;
	
	public ControleurJoueur(int idJoueur) {
		this.mjoueur=new ModeleJoueur(idJoueur);
		this.vjoueur=new VueJoueur(this);
	}

	public boolean placerBateau(int numBateau, int coordoneeHorizontale, int coordoneeVerticale, boolean horizontal) {
		return this.mjoueur.placerBateau(numBateau, coordoneeHorizontale, coordoneeVerticale, horizontal);
	}
	
	public void placerTousLesBateaux() {
		for(int i=0; i<5; ++i) {
			System.out.println("bateau numero"); // a faire passer par la vue
			System.out.print(i);				// idem
			while(false==this.vjoueur.placerBateau(i)){}
		}
	}
	
	public boolean essuyerTir(int coordoneeHorizontale, int coordoneeVerticale) {
		return this.mjoueur.essuyerTir(coordoneeHorizontale, coordoneeVerticale);
	}
	
	public boolean tirerSur(ControleurJoueur adversaire) {
		int coordoneeHorizontale=this.vjoueur.EntreeClavierInt("x?");
		int coordoneeVerticale=this.vjoueur.EntreeClavierInt("y?");
		return adversaire.essuyerTir(coordoneeHorizontale, coordoneeVerticale);
	}
	
	public boolean perdu() {
		return this.mjoueur.perdu();
	}
	
}
