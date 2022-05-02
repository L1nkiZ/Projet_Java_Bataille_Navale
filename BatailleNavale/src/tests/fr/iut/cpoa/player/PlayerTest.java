package tests.fr.iut.cpoa.player

import fr.iut.cpoa.player.Joueur;
import static fr.iut.cpoa.player.Joueur.tirer;
import static fr.iut.cpoa.player.Joueur.setAGagne;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    private final int idJoueur;
    private boolean aGagne;

    @Before
    public void setUp() { // instancier un objet sur lequel on fait des tests
        System.out.println("setUp tests unitaires Player");
        idJoueur = 1;
        aGagne = false;

        Player PlayerJoyce = new Player(idJoueur, aGagne);
    }

    @Test
    public int testTirerIsValid(){
        assertTrue(PlayerJoyce.tirer("True"));
    }

    @Test
    public void testSetAGagneIsValid(){
        assertTrue(PlayerJoyce.setAGagne("True"));
    }
}

