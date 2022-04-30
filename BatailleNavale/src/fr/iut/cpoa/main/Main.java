package fr.iut.cpoa.main;

import fr.iut.cpoa.player.Joueur;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        bataille();
    }

    public static void bataille() {

        Joueur joueur1 = new Joueur(1);
        Joueur joueur2 = new Joueur(2);

        /*
        if (!joueur1.grille.ajouterVaisseau(1, "A4", 1) ||
                !joueur1.grille.ajouterVaisseau(2, "B5", 1) ||
                !joueur1.grille.ajouterVaisseau(3, "C6", 1) ||
                !joueur1.grille.ajouterVaisseau(4, "D7", 1) ||
                !joueur1.grille.ajouterVaisseau(5, "E8", 1)) {
            System.out.println("Erreur ajout vaisseau");
        }

        System.out.println("ok");

        if (!joueur2.grille.ajouterVaisseau(1, "A4", 1) ||
                !joueur2.grille.ajouterVaisseau(2, "B5", 1) ||
                !joueur2.grille.ajouterVaisseau(3, "C6", 1) ||
                !joueur2.grille.ajouterVaisseau(4, "D7", 1) ||
                !joueur2.grille.ajouterVaisseau(5, "E8", 1)) {
            System.out.println("Erreur ajout vaisseau");
        }*/

        initialiserVaisseaux(joueur1);
        initialiserVaisseaux(joueur2);

        while (!joueur1.getAGagne() && !joueur2.getAGagne()) {
            tour(joueur1, joueur2);
            if (!joueur1.getAGagne())
                tour(joueur2, joueur1);
        }
        if (joueur1.getAGagne())
            System.out.println("Le joueur 1 a gagne");
        else
            System.out.println("Le joueur 2 a gagne");
    }

    public static void tour(Joueur joueur1, Joueur joueur2){

        System.out.println("Tour du joueur " + joueur1.getIdJoueur());
        Scanner console = new Scanner(System.in);

        int resultTir;

        System.out.println(joueur2.grille.afficheBrouillardDeGuerre());
        //System.out.println(joueur2.grille.toString());
        do {
            System.out.println("Joueur " + joueur1.getIdJoueur() + " : Entrez les coordonnees de votre tir : ");
            String coord = console.nextLine();
            if (!checkString(coord))
                resultTir = -1;
            else
                resultTir = joueur1.tirer(joueur2, coord);

            if (resultTir == -1) {
                System.out.println("Cette case n'est pas valide");
            }
        } while (resultTir == -1);

        System.out.println(joueur2.grille.afficheBrouillardDeGuerre());
        //System.out.println(joueur2.grille.toString());

        if (resultTir == 1){
            String resultat = "Touche";
            if (joueur2.grille.setCoule())
                    resultat += "-coule";
            resultat += " !";
            System.out.println(resultat);
        }
        else if (resultTir == 0)
            System.out.println("Rate.");
        else
            System.out.println("Erreur : coordonnees invalides (Ce message ne devrait jamais apparaitre)");

        if (joueur2.grille.estGagne())
            joueur1.setAGagne(true);
    }

    public static boolean checkString(String s) {
        if (s.length() != 2)
            return false;
        if (s.charAt(0) >= 'a' && s.charAt(0) <= 'j') {
            char tmpUppercase = Character.toUpperCase(s.charAt(0));
            s = tmpUppercase + s.substring(1);
        }
        if (s.charAt(0) < 'A' || s.charAt(0) > 'J')
            return false;
        if (s.charAt(1) < '1' || s.charAt(1) > '9')
            return false;
        return true;
    }

    public static void initialiserVaisseaux(Joueur joueur){

        int idVaisseau = 1;

        do{
            Scanner console = new Scanner(System.in);

            System.out.println(joueur.grille.toString());
            System.out.println("Joueur " + joueur.getIdJoueur() +
                    " : Entrez les coordonnees pour le " + joueur.grille.getNomVaisseau(idVaisseau) + " (ex : B6) : ");
            String coord = console.nextLine();
            if (!checkString(coord))
                System.out.println("Cette case n'est pas valide");
            else {
                System.out.println("Est-ce une position horizontale ou verticale ? (h/v)");
                String orientation = console.nextLine();
                if (orientation.equals("h") || orientation.equals("H"))
                    if (joueur.grille.ajouterVaisseau(idVaisseau, coord, 0))
                        idVaisseau++;
                    else
                        System.out.println("Coordonnees invalide");
                else if (orientation.equals("v") || orientation.equals("V"))
                    if (joueur.grille.ajouterVaisseau(idVaisseau, coord, 1))
                        idVaisseau++;
                    else
                        System.out.println("Coordonnees invalide");
                else
                    System.out.println("Cette orientation n'est pas valide");
            }
        }while (idVaisseau < 6);
    }
}
