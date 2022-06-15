package modeles;
import interfaces.IPorteAvions;

public class ModelePorteAvions extends ModeleBateau implements IPorteAvions {

	public ModelePorteAvions() {
		super();
		this.Longueur=5;
		this.caseTouchee=new boolean[this.Longueur];
		for(int i=0;i<this.Longueur;++i) {
			this.caseTouchee[i]=false;
		}
	}


}
