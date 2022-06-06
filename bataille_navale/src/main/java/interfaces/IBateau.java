package interfaces;
import modeles.ModeleBateau;

public interface IBateau {
    void PlacerBateau(int coordonneeHorizontale, int coordonneeVerticale, boolean horizontal);

    boolean estTouche(int coordoneeHorizontale, int coordoneeVerticale);

    boolean estCoule();

    void reparer();
}
