package interfaces;


public interface IBateau {

    public int Longueur();
	public int coordoneeHorizontale();
	public int coordoneeVerticale();
	public boolean horizontal();
	public boolean[] caseTouchee();
	public boolean estPlace();
    public void estPlace(boolean valeur);

    void PlacerBateau(int coordonneeHorizontale, int coordonneeVerticale, boolean horizontal);

    boolean estTouche(int coordoneeHorizontale, int coordoneeVerticale);

    boolean estCoule();

    void reparer();
}
