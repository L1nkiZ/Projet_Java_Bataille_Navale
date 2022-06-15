package modeles;
import interfaces.IContreTorpilleur;

public class ModeleContreTorpilleur extends ModeleBateau implements IContreTorpilleur {

	public ModeleContreTorpilleur() {
		super();
		this.Longueur=3;
		this.caseTouchee=new boolean[this.Longueur];
		for(int i=0;i<this.Longueur;++i) {
			this.caseTouchee[i]=false;
		}
	}

}
