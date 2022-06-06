package interfaces;

import modeles.ModeleJoueur;

public interface IJoueur {
    boolean perdu();

    boolean essuyerTir(int coordoneeHorizontale, int coordoneeVerticale);
    boolean placerBateau(int numBateau, int coordoneeHorizontale, int coordoneeVerticale, boolean horizontal);
}
