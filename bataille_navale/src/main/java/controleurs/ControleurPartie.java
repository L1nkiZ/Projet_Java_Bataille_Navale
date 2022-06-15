package controleurs;


public class ControleurPartie {

	private ControleurJoueur[] joueurs={new ControleurJoueur(0),new ControleurJoueur(1)};
	
	public ControleurPartie() {
		joueurs[1].placerTousLesBateaux();
		joueurs[0].placerTousLesBateaux();
		}
		
	
	public void jouer() {
		boolean termine=false;
		int tour=0;
		while(termine==false) {
			termine=this.jouerTour(tour);
			tour=(tour+1)%2;
		}
	}

	public boolean jouerTour(int tour){
		int touche=joueurs[tour].tirerSur(joueurs[(tour+1)%2]);
		this.joueurs[tour].annoncerResultat(touche, joueurs[(tour+1)%2]);
		if(joueurs[(tour+1)%2].perdu()) {
			this.joueurs[tour].annoncerVictoire();
			return true;
		}
		return false;
	}
}
