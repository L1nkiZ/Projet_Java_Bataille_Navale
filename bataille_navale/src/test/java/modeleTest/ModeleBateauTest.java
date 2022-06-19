package modeleTest;

import modeles.*;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
//import org.junit.Before;
import org.junit.Test;

import interfaces.IBateau;


public final class ModeleBateauTest {
    
    private IBateau bateau;

    @Before public void SetUp(){
        this.bateau=new ModelePorteAvions();
        this.bateau.PlacerBateau(3, 2, true);
        this.bateau.estPlace(true);
    }

    @Test public void PlacerBateau(){
        this.bateau.PlacerBateau(4, 5, false);
        assertTrue(this.bateau.coordoneeHorizontale()==4&&this.bateau.coordoneeVerticale()==5&&this.bateau.horizontal()==false);
    }

    @Test public void estTouche(){
        boolean touche= this.bateau.estTouche(4, 2);
        assertTrue(touche && this.bateau.caseTouchee()[1] && !this.bateau.caseTouchee()[0]);
    }

    @Test public void estTouche2(){
        boolean touche= this.bateau.estTouche(4, 1);
        assertTrue(!touche && !this.bateau.caseTouchee()[1] && !this.bateau.caseTouchee()[0]);
    }

    @Test public void estTouche3(){
        boolean touche= this.bateau.estTouche(8, 2);
        assertTrue(!touche && !this.bateau.caseTouchee()[1] && !this.bateau.caseTouchee()[0]);
    }

    @Test public void estTouche4(){
        boolean touche= this.bateau.estTouche(2, 2);
        assertTrue(!touche && !this.bateau.caseTouchee()[1] && !this.bateau.caseTouchee()[0]);
    }


    @Test public void estCoule(){
        int x=3;
        int y=2;
        for (int i = 0; i < this.bateau.Longueur(); i++) {
            this.bateau.estTouche(x+i, y);
        }
        assertTrue(this.bateau.estCoule());
    }

    @Test public void estCoule2(){
        int x=3;
        int y=2;
        for (int i = 0; i < this.bateau.Longueur(); i++) {
            if (i!=2) {
                this.bateau.estTouche(x+i, y);
            }
        }
        assertTrue(!this.bateau.estCoule());
    }

    @Test public void estCoule3(){
        int x=3;
        int y=2;
        for (int i = 0; i < this.bateau.Longueur(); i++) {
            if (i!=0) {
                this.bateau.estTouche(x+i, y);
            }
            else{
                this.bateau.estTouche(x+1, y);
            }
        }
        assertTrue(!this.bateau.estCoule());
    }

    @Test public void estCoule4(){
        int x=3;
        int y=2;
        for (int i = 1; i < this.bateau.Longueur(); i++) {
            this.bateau.estTouche(x+i, y);
        }
        assertTrue(!this.bateau.estCoule());
    }

    @Test public void reparer(){
        for (int i = 0; i < this.bateau.Longueur(); i++) {
            this.bateau.estTouche(3+i, 2);
        }
        this.bateau.reparer();

        boolean touche=false;
        for (int i = 0; i < this.bateau.Longueur(); i++) {
            touche=touche||this.bateau.caseTouchee()[i];
        }
        assertTrue(!touche);

    }
}
