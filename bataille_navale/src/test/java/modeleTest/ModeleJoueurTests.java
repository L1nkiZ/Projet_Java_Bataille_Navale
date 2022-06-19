package modeleTest;

import interfaces.IGrille;
import interfaces.IJoueur;
import modeles.ModeleJoueur;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;




public class ModeleJoueurTests {
    
    public class grilleStub implements IGrille{

        public boolean placerBateau(int numBateau, int coordoneeHorizontale, int coordoneeVerticale, boolean horizontal){
            return true;
        }

        public boolean tousCoules(){
            return true;
        }

        public int essuyerTir(int coordoneeHorizontale, int coordoneeVerticale){
            return 2;
        }

        public boolean bateauPerdu(int numBateau){
            return true;
        }

        public boolean estPlace(int numBateau){
            return true;
        }
    }

    private IJoueur joueur;

    @Before public void SetUp(){
        this.joueur=new ModeleJoueur(0);
        this.joueur.ecraserGrille(new grilleStub());
    }
    
    @Test public void nomJoueur(){
        assertNotNull(this.joueur.nomJoueur());
    }

    @Test public void perdu(){
        assertTrue(this.joueur.perdu());
    }

    @Test public void essuyerTir(){
        assertTrue(this.joueur.essuyerTir(13, 2)==2);
    }

    @Test public void placerBateau(){
        assertTrue(this.joueur.placerBateau(0, 2, 8, true));
    }

    @Test public void bateauPerdu(){
        assertTrue(this.joueur.bateauPerdu(0));
    }

}
