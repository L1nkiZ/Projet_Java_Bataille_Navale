package tests.fr.iut.cpoa.player;

import fr.iut.cpoa.grid.Grille;
import static fr.iut.cpoa.tools.Utils.checkString;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
    @Test
    public void testCheckStringIsValid() {
        assertTrue(Utils.checkString("A1"));
    }
    public int testTirer(Joueur joueur, String coordonnees){
        return joueur.grille.tir(coordonnees);
    }
}

