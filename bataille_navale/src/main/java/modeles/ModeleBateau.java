package modeles;
import interfaces.IBateau;

public abstract class ModeleBateau implements IBateau{
	
//	protected int idBateau;
	protected int Longueur;
	protected int coordoneeHorizontale;
	protected int coordoneeVerticale;
	protected boolean horizontal;
	protected boolean[] caseTouchee;
	protected boolean estPlace;
	
	
	protected ModeleBateau() {
		this.estPlace=false;
	}
	

	public int Longueur(){
		return this.Longueur;
	};
	public int coordoneeHorizontale(){
		return this.coordoneeHorizontale;
	};
	public int coordoneeVerticale(){
		return this.coordoneeVerticale;
	};
	public boolean horizontal(){
		return this.horizontal;
	};
	public boolean[] caseTouchee(){
		return this.caseTouchee;
	};
	public boolean estPlace(){
		return this.estPlace;
	};
	public void estPlace(boolean valeur){
		this.estPlace=valeur;
	};



	public void PlacerBateau(int coordoneeHorizontale, int coordoneeVerticale, boolean horizontal){
		this.coordoneeHorizontale=coordoneeHorizontale;
		this.coordoneeVerticale=coordoneeVerticale;
		this.horizontal=horizontal;
	}
	
	public boolean estTouche(int coordoneeHorizontale, int coordoneeVerticale) {
		int x=coordoneeHorizontale;
		int y=coordoneeVerticale;
		for(int i=0;i<this.Longueur;++i) {
			if(x==this.coordoneeHorizontale && y==this.coordoneeVerticale) {
				this.caseTouchee[i]=true;
				return true;
			}
			if(this.horizontal) {
				x-=1;
			}
			else {
				y-=1;
			}
		}
		return false;
	}
	
	
	public boolean estCoule() {
		for(int i=0;i<this.Longueur;++i) {
			if (false==this.caseTouchee[i]) {
				return false;
			}
		}
		return true;
	}
	
	public void reparer() {
		for(int i=0; i<this.Longueur; ++i) {
			this.caseTouchee[i]=false;
		}
	}
}
