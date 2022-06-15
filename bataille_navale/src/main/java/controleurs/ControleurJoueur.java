package controleurs;
import modeles.ModeleJoueur;
import vues.VueJoueur;
import interfaces.IJoueur;
import utils.Coordonnees;

public class ControleurJoueur {

	private IJoueur mjoueur;
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
			while(false==this.vjoueur.placerBateau(i)){}
		}
	}
	
	public int essuyerTir(int coordoneeHorizontale, int coordoneeVerticale) {
		return this.mjoueur.essuyerTir(coordoneeHorizontale, coordoneeVerticale);
	}
	
	public int tirerSur(ControleurJoueur adversaire) {
		this.vjoueur.annoncerTour();
		Coordonnees coordonnees=this.vjoueur.demanderCoordonnees();
		return adversaire.essuyerTir(coordonnees.x, coordonnees.y);
	}
	
	public boolean perdu() {
		return this.mjoueur.perdu();
	}
	
	public String nomBateau(int i){
		if(i==0)return "Porte-Avions";
		if(i==1)return "Croiseur";
		if(i==2)return "Contre-Torpilleur";
		if(i==3)return "Sous-Marin";
		if(i==4)return "Torpilleur";
		return  "vaisseau fantome";
	}

	public String nomJoueur(){
		return this.mjoueur.nomJoueur();
	}

	public void annoncerResultat(int touche, ControleurJoueur cible){
		this.vjoueur.annoncerResultat(touche, cible);
	}

	public void annoncerVictoire(){
		this.vjoueur.annoncerVictoire();
	}

	public boolean bateauPerdu(int numBateau){
		return this.mjoueur.bateauPerdu(numBateau);
	}
}
