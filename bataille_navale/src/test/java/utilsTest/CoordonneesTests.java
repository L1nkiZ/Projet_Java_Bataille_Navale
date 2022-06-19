package utilsTest;

import utils.Coordonnees;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

//import org.junit.Before;
import org.junit.Test;

public final class CoordonneesTests {

    @Test public void constructeurTexteMin(){
        Coordonnees coordonnees=new Coordonnees("a13");
        assertTrue(coordonnees.x==1 && coordonnees.y==13);
    }

    @Test public void constructeurTexteMaj(){
        Coordonnees coordonnees=new Coordonnees("C26");
        assertTrue(coordonnees.x==3 && coordonnees.y==26);
    }

    @Test public void constructeurCopie(){
        Coordonnees coordonnees=new Coordonnees("a13");
        Coordonnees copie=new Coordonnees(coordonnees);
        assertTrue(coordonnees.equals(copie));
    }

    @Test public void constructeurValeurs(){
        Coordonnees coordonnees=new Coordonnees(13,19);
        assertTrue(coordonnees.x==13 && coordonnees.y==19);
    }

    @Test public void valides(){
        Coordonnees coordonnees=new Coordonnees("C26");
        assertTrue(coordonnees.valides());
    }

    @Test public void valides2(){
        Coordonnees coordonnees=new Coordonnees("C27");
        assertTrue(!coordonnees.valides());
    }

    @Test public void valides3(){
        Coordonnees coordonnees=new Coordonnees("C0");
        assertTrue(!coordonnees.valides());
    }

    @Test public void valides4(){
        Coordonnees coordonnees=new Coordonnees("ù26");
        assertTrue(!coordonnees.valides());
    }

    @Test public void valides5(){
        Coordonnees coordonnees=new Coordonnees("026");
        assertTrue(!coordonnees.valides());
    }

    @Test public void valides6(){
        Coordonnees coordonnees=new Coordonnees("C++");
        assertTrue(!coordonnees.valides());
    }
}