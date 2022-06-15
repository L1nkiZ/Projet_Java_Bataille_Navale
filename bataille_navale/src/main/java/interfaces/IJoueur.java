package interfaces;


public interface IJoueur {
    public boolean perdu();
    public int essuyerTir(int coordoneeHorizontale, int coordoneeVerticale);
    public boolean placerBateau(int numBateau, int coordoneeHorizontale, int coordoneeVerticale, boolean horizontal);
    public String nomJoueur();
    public boolean bateauPerdu(int numBateau);
}
