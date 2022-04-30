package fr.iut.cpoa.ship;

public class Vaisseau {
    private final int idBateau;
    private final String nomBateau;
    private final int tailleCases;

    private boolean estCoule;

    // Constructeur
    public Vaisseau(int idBateau) {
        this.idBateau = idBateau;
        this.nomBateau = setNomBateauFromId(idBateau);
        this.tailleCases = setTailleCaseFromId(idBateau);
        this.estCoule = false;
    }

    // Méthode qui retourne le nom du bateau en fonction de son id
    private String setNomBateauFromId(int idBateau) {
        return switch (idBateau) {
            case 1 -> "Porte-avions";
            case 2 -> "Croiseur";
            case 3 -> "Contre-torpilleur";
            case 4 -> "Sous-marin";
            case 5 -> "Torpilleur";
            default -> "ErrNoShip";
        };
    }

    // Méthode qui retourne la taille d'une case en fonction de son id
    private Integer setTailleCaseFromId(int idBateau) {
        return switch (idBateau) {
            case 1 -> 5;
            case 2 -> 4;
            case 3, 4 -> 3;
            case 5 -> 2;
            default -> 10;
        };
    }

    // Getters
    public int getId() {
        return idBateau;
    }

    // Méthode qui retourne le nom du bateau
    public String getNomBateau() {
        return nomBateau;
    }


    // Méthode qui retourne la taille du bateau
    public int getTaille() {
        return tailleCases;
    }

    // Méthode qui retourne si le bateau est coulé ou non
    public boolean estCoule() {
        return estCoule;
    }

    // Méthode qui permet de couler le bateau
    public void setCoule() {
        this.estCoule = true;
    }
}