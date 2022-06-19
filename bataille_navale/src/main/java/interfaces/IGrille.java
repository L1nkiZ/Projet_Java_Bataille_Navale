package interfaces;


public interface IGrille {
    public boolean placerBateau(int numBateau, int coordoneeHorizontale, int coordoneeVerticale, boolean horizontal);

    public boolean tousCoules();

    public int essuyerTir(int coordoneeHorizontale, int coordoneeVerticale);

    public boolean bateauPerdu(int numBateau);

    public boolean estPlace(int numBateau);
}
