package tests.fr.iut.cpoa.ship;

import static fr.iut.cpoa.tools.Utils.checkString;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import fr.iut.cpoa.ship.Vaisseau;

public class VaisseauTest {+-

    private final int idBateau;
    private final String nomBateau;
    private final int tailleCases;

    private boolean estCoule;

    @Before
    public void setUp() {
        System.out.println("Set Up");
        idBateau = 1;
        nomBateau = "Croiseur";
        tailleCases = 2;
        estCoule = false;

        Vaisseau Vaisseau 1 = new.Vaisseau(idBateau, nomBateau, tailleCases, estCoule);
    }

    @Test
    public void testCheckStringIsValid() {assertTrue(Vaisseau.setNomBateauFromId("1"));}

    @Test
    public void testCheckStringIsNotValid() {assertFalse(Vaisseau.setNomBateauFromId("123"));}

    @Test
    public void testCheckIntIsValid() {assertTrue(Vaisseau.setTailleCaseFromId("2"));}

    @Test
    public void testCheckIntIsNotValid() {assertFalse(Vaisseau.setTailleCaseFromId("123"));}

    @Test
    public void testSetEstCoule()
}