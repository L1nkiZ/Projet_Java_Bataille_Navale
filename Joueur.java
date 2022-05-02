package fr.iut.cpoa.player;

import fr.iut.cpoa.grid.Grille;

import java.util.Scanner;

import static fr.iut.cpoa.tools.Utils.checkString;

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


    public void initialiserVaisseaux(){

        int idVaisseau = 1;

        Scanner console = new Scanner(System.in);
        
        do{
            

            System.out.println(this.grille.toString());
            System.out.println("Joueur " + this.getIdJoueur() +
                    " : Entrez les coordonnees pour le " + this.grille.getNomVaisseau(idVaisseau) + " (ex : B6) : ");
            String coord = console.nextLine();
            if (!checkString(coord))
                System.out.println("Cette case n'est pas valide");
            else {
                System.out.println("Est-ce une position horizontale ou verticale ? (h/v)");
                String orientation = console.nextLine();
                if (orientation.equals("h") || orientation.equals("H"))
                    if (this.grille.ajouterVaisseau(idVaisseau, coord, 0))
                        idVaisseau++;
                    else
                        System.out.println("Coordonnees invalide");
                else if (orientation.equals("v") || orientation.equals("V"))
                    if (this.grille.ajouterVaisseau(idVaisseau, coord, 1))
                        idVaisseau++;
                    else
                        System.out.println("Coordonnees invalide");
                else
                    System.out.println("Cette orientation n'est pas valide");
            }
        }while (idVaisseau < 6);

        console.close();
        
    }
}
