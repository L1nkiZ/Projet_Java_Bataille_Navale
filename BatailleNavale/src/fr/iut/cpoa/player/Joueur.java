package fr.iut.cpoa.player;

import fr.iut.cpoa.grid.Grille;

public class Joueur {
    private final int idJoueur;
    private boolean aGagne;

    public Grille grille = new Grille();

    // Constructeur
    public Joueur(int idJoueur){
        this.idJoueur = idJoueur;
        this.aGagne = false;
    }

    // Tire sur la grille du joueur adverse
    public int tirer(Joueur joueur, String coordonnees){
        return joueur.grille.tir(coordonnees);
    }

    // Récupère l'id du joueur
    public int getIdJoueur(){
        return this.idJoueur;
    }

    // Récupère si le joueur a gagné
    public boolean getAGagne(){
        return this.aGagne;
    }

    // Met le joueur en mode victoire
    public void setAGagne(boolean aGagne){
        this.aGagne = aGagne;
    }
}
