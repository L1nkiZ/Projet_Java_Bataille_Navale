package modeles;

public class ModeleSousMarin extends ModeleBateau {

	public ModeleSousMarin() {
		super();
		this.Longueur=3;
		this.caseTouchee=new boolean[this.Longueur];
		for(int i=0;i<this.Longueur;++i) {
			this.caseTouchee[i]=false;
		}
	}

}
