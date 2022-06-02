package modeles;

public class ModeleTorpilleur extends ModeleBateau {

	public ModeleTorpilleur() {
		super();
		this.Longueur=2;
		this.caseTouchee=new boolean[this.Longueur];
		for(int i=0;i<this.Longueur;++i) {
			this.caseTouchee[i]=false;
		}
	}

}
