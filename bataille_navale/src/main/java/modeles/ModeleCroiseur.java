package modeles;
import interfaces.ICroiseur;

public class ModeleCroiseur extends ModeleBateau implements ICroiseur{

	public ModeleCroiseur() {
		super();
		this.Longueur=4;
		this.caseTouchee=new boolean[this.Longueur];
		for(int i=0;i<this.Longueur;++i) {
			this.caseTouchee[i]=false;
		}
	}

}
