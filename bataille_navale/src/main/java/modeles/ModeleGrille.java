package modeles;
import interfaces.IGrille;
import utils.Coordonnees;
import interfaces.IBateau;

public class ModeleGrille implements IGrille {
	
	private IBateau[] bateaux;

	public ModeleGrille() {
		this.bateaux=new IBateau[5];
		this.bateaux[0]=new ModelePorteAvions();
		this.bateaux[1]=new ModeleCroiseur();
		this.bateaux[2]=new ModeleContreTorpilleur();
		this.bateaux[3]=new ModeleSousMarin();
		this.bateaux[4]=new ModeleTorpilleur();
	}

	
	// verifie que le bateau n'entre pas en collision avec un bateau deja place
	// si le bateau n'est pas place il sera touche sur la case problematique
	public boolean placerBateau(int numBateau, int coordoneeHorizontale, int coordoneeVerticale, boolean horizontal) {
		this.bateaux[numBateau].PlacerBateau(coordoneeHorizontale, coordoneeVerticale, horizontal);
		this.bateaux[numBateau].estPlace(false); // normalement deja a false
		
		Coordonnees coordonnees;
		if (horizontal) {
			coordonnees=new Coordonnees(coordoneeHorizontale+this.bateaux[numBateau].Longueur(), coordoneeVerticale);
		}else{
			coordonnees=new Coordonnees(coordoneeHorizontale, coordoneeVerticale+this.bateaux[numBateau].Longueur());
		}
		if (false==coordonnees.valides()) { //Si le bateau sort de la grille
			return false;
		}


		for(int i=0; i<5; ++i) {
			if (this.bateaux[i].estPlace()) {
				int x=this.bateaux[i].coordoneeHorizontale();
				int y=this.bateaux[i].coordoneeVerticale();
				for(int j=0; j<this.bateaux[i].Longueur(); ++j) {
					if(this.bateaux[numBateau].estTouche(x, y)) {
						return false;
					}
					else {
						if (this.bateaux[i].horizontal()) {
							x+=1;
						}
						else {
							y+=1;
						}
					}
				}
			}
		}
		this.bateaux[numBateau].estPlace(true);
		this.bateaux[numBateau].reparer(); // normalement inutile si bien place du premier coup
		return true;
	}
	
	public boolean tousCoules() {
		for(int i=0; i<5; ++i) {
			if(this.bateaux[i].estCoule()==false) {
				return false;
			}
		}
		return true;
	}
	
	public int essuyerTir(int coordoneeHorizontale, int coordoneeVerticale) {
		for(int i=0; i<5; ++i) {
			if(this.bateaux[i].estTouche(coordoneeHorizontale, coordoneeVerticale)) {
				return i;
			}
		}
		return -1;
	}

	public boolean bateauPerdu(int numBateau){
		return this.bateaux[numBateau].estCoule();
	}
}
