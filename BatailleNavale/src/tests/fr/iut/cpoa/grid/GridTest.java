package tests.fr.iut.cpoa.grid

import fr.iut.cpoa.grid.Grille;
import static fr.iut.cpoa.player.Joueur.tir;
import static fr.iut.cpoa.player.Joueur.ajouterVaisseau;
import static fr.iut.cpoa.player.Joueur.verifierAjout;
import static fr.iut.cpoa.player.Joueur.estGagne;
import static fr.iut.cpoa.player.Joueur.estCoule;
import static fr.iut.cpoa.player.Joueur.traduireEnGrille;
import static fr.iut.cpoa.player.Joueur.toString;
import static fr.iut.cpoa.player.Joueur.afficheBrouillardDeGuerre;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class GridTest {

    private int[][] grid = new int[10][10];
    private Vaisseau PorteAvion = new Vaisseau(1);
    private Vaisseau Croiseur = new Vaisseau(2);
    private Vaisseau ContreTorpilleur = new Vaisseau(3);
    private Vaisseau SousMarin = new Vaisseau(4);
    private Vaisseau Torpilleur = new Vaisseau(5);

    @Before
    public void setUp() { // instancier un objet sur lequel on fait des tests
        System.out.println("setUp tests unitaires Grid");
        grid = [10][10];
        Vaisseau PorteAvion = 1;
        Vaisseau Croiseur = 2;
        Vaisseau ContreTorpilleur = 3;
        Vaisseau SousMarin = 4;
        Vaisseau Torpilleur = 5;

        grid grid1 = new grid(grid, Vaisseau PorteAvion, Vaisseau Croiseur, Vaisseau ContreTorpilleur, Vaisseau SousMarin, Vaisseau Torpilleur);
    }

    @Test
    public int testTirIsValid(){
        assertTrue(grid1.tir("B3"));
    }

    @Test
    public boolean testAjouterVaisseauIsValid {
        assertTrue(grid1.ajouterVaisseau("C4"));
    }

    @Test
    private boolean testVerifierAjoutIsValid {
        assertTrue(grid1.verifierAjout("A7"));
    }

    @Test
    public boolean testEstGagneIsValid {
        assertTrue(grid1.estGagne(True));
    }

    @Test
    private boolean testEstCouleIsValid {
        assertTrue(grid1.estCoule(True));
    }

    @Test
    public int[] testTraduireEnGrilleIsValid {
        assertTrue(grid1.traduireEnGrille("J9"));
    }

    @Test
    public String testToStringIsValid {
        assertTrue(grid1.toString("   "));
    }

    @Test
    public String testAfficheBrouillardDeGuerreIsValid {
        assertTrue(grid1.afficheBrouillardDeGuerre("    "));
    }


}