package controleurs;


public class ControleurPartie {

	private ControleurJoueur joueur1=new ControleurJoueur(1);
	private ControleurJoueur joueur0=new ControleurJoueur(0);
	
	public ControleurPartie() {
		joueur1.placerTousLesBateaux();
		joueur0.placerTousLesBateaux();
		}
		
	
	public void jouer() {
		boolean termine=false;
		int tour=0;
		while(termine==false) {
			if(tour%2==0) {
				System.out.println("c'est le tour du joueur0");
				if(joueur0.tirerSur(joueur1)) {
					System.out.println("touche");
				}
				else {
					System.out.println("manque");
				}
				if(joueur1.perdu()) {
					System.out.println("bravo joueur0");
					termine=true;
				}
				else {
					tour=(tour+1)%2;
				}
			}
			else {
				System.out.println("c'est le tour du joueur1");
				if(joueur1.tirerSur(joueur0)) {
					System.out.println("touche");
				}
				else {
					System.out.println("manque");
				}
				if(joueur0.perdu()) {
					System.out.println("bravo joueur1");
					termine=true;
				}
				else {
					tour=(tour+1)%2;
				}
				
			}
		}
	}

}
