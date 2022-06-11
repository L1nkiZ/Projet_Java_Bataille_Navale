package utils;



public class Coordonnees{
    public int x;
    public int y;

    public Coordonnees(String texte){
        char xtext=texte.toLowerCase().charAt(0);
        this.x=((int)xtext)-((int)'a')+1;
        String ytext=texte.substring(1);
        this.y=Integer.parseInt(ytext);
    }

    public Coordonnees(Coordonnees originales){
        this.x=originales.x;
        this.y=originales.y;
    }

    public Coordonnees(int x, int y){
        this.x=x;
        this.y=y;
    }


    public boolean valides(){
        if (this.x<1) {
            return false;
        }
        if (this.x>26) {
            return false;
        }
        if (this.y<1) {
            return false;
        }
        if (this.y>26) {
            return false;
        }
        return true;
    }
}