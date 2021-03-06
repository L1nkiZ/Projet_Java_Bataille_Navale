package modeleTest;


import modeles.*;
//import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;

import interfaces.IGrille;


public final class ModeleGrilleTests{
    private IGrille grille;
    
    @Before public void SetUp(){
        this.grille=new ModeleGrille();
        this.grille.placerBateau(0, 1, 12, true);
        this.grille.placerBateau(1, 3, 2, true);
        this.grille.placerBateau(2, 1, 3, true);
        this.grille.placerBateau(3, 1, 4, true);
        // dernier bateau non place!
    }

    @Test public void placerBateau(){
        this.grille.placerBateau(4, 1, 13, true);
        assertTrue(this.grille.estPlace(4) && this.grille.essuyerTir(1, 13)==4 && this.grille.essuyerTir(2 , 13)==4);
    }

    @Test public void placerBateau2(){ //ce cas ne devrait pas se présenter
        this.grille.placerBateau(4, 0, 13, true);
        assertTrue(!this.grille.estPlace(4));
    }

    @Test public void placerBateau3(){
        this.grille.placerBateau(4, 26, 13, true);
        assertTrue(!this.grille.estPlace(4));
    }

    @Test public void placerBateau4(){
        this.grille.placerBateau(4, 2, 2, true);
        assertTrue(!this.grille.estPlace(4));
    }

    @Test public void placerBateau5(){
        this.grille.placerBateau(4, 1, 2, false);
        assertTrue(!this.grille.estPlace(4));
    }

    @Test public void placerBateau6(){
        this.grille.placerBateau(4, 13, 13, false);
        assertTrue(this.grille.estPlace(4) && this.grille.essuyerTir(13, 13)==4 && this.grille.essuyerTir(13, 14)==4);
    }

    @Test public void tousCoules(){
        this.grille.placerBateau(4, 1, 13, true);
        for (int i = 1; i < 27; i++) {
            this.grille.essuyerTir(i, 2);
        }
        for (int i = 1; i < 27; i++) {
            this.grille.essuyerTir(i, 3);
        }
        for (int i = 1; i < 27; i++) {
            this.grille.essuyerTir(i, 4);
        }
        for (int i = 1; i < 27; i++) {
            this.grille.essuyerTir(i, 12);
        }
        for (int i = 1; i < 27; i++) {
            this.grille.essuyerTir(i, 13);
        }
        assertTrue(this.grille.tousCoules());
    }

    @Test public void tousCoules2(){
        this.grille.placerBateau(4, 1, 13, true);
        for (int i = 1; i < 27; i++) {
            if (i!=4) {
                this.grille.essuyerTir(i, 2);
            }
        }
        for (int i = 1; i < 27; i++) {
            this.grille.essuyerTir(i, 3);
        }
        for (int i = 1; i < 27; i++) {
            this.grille.essuyerTir(i, 4);
        }
        for (int i = 1; i < 27; i++) {
            this.grille.essuyerTir(i, 12);
        }
        for (int i = 1; i < 27; i++) {
            this.grille.essuyerTir(i, 13);
        }
        assertTrue(!this.grille.tousCoules());
    }

    @Test public void essuyerTir(){
        this.grille.placerBateau(4, 1, 13, true);
        int rep=this.grille.essuyerTir(2, 13);
        assertTrue(rep==4);
    }

    @Test public void essuyerTir2(){
        this.grille.placerBateau(4, 1, 13, true);
        int rep=this.grille.essuyerTir(13, 13);
        assertTrue(rep==-1);
    }
    
    @Test public void bateauPerdu(){
        this.grille.placerBateau(4, 1, 13, true);
        for (int i = 1; i < 27; i++) {
            this.grille.essuyerTir(i, 2);
        }
        assertTrue(this.grille.bateauPerdu(1));
    }

    @Test public void bateauPerdu2(){
        this.grille.placerBateau(4, 1, 13, true);
        for (int i = 1; i < 27; i++) {
            this.grille.essuyerTir(i, 2);
        }
        this.grille.essuyerTir(1, 13);
        assertTrue(!this.grille.bateauPerdu(4));
    }

    @Test public void estPlace(){
        assertTrue(this.grille.estPlace(0));
    }

    @Test public void estPlace2(){
        assertTrue(!this.grille.estPlace(4));
    }

}