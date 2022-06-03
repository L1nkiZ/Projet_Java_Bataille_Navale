package modeles;

public class ModelePorteAvions extends ModeleBateau {

	public ModelePorteAvions() {
		super();
		this.Longueur=5;
		this.caseTouchee=new boolean[this.Longueur];
		for(int i=0;i<this.Longueur;++i) {
			this.caseTouchee[i]=false;
		}
	}


}
