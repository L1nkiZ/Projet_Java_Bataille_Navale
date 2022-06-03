package interfaces;

import modeles.ModeleGrille;

public interface IGrille {
    boolean placerBateau(int numBateau, int coordoneeHorizontale, int coordoneeVerticale, boolean horizontal);

    boolean tousCoules();

    boolean essuyerTir(int coordoneeHorizontale, int coordoneeVerticale);
}
