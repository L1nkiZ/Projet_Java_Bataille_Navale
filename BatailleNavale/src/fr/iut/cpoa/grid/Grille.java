package fr.iut.cpoa.grid;


import fr.iut.cpoa.ship.Vaisseau;

public class Grille{
    private int[][] grid = new int[10][10];
    private Vaisseau PorteAvion = new Vaisseau(1);
    private Vaisseau Croiseur = new Vaisseau(2);
    private Vaisseau ContreTorpilleur = new Vaisseau(3);
    private Vaisseau SousMarin = new Vaisseau(4);
    private Vaisseau Torpilleur = new Vaisseau(5);

    // Utilisé uniquement à des fin d'erreur sur l'ID de vaisseau envoyé (ne devrait pas arriver)
    private Vaisseau ErrNo = new Vaisseau(0);

    public Grille(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                grid[i][j] = -2;
            }
        }
    }

    //Retourne l'objet vaisseau correspondant à l'ID
    public Vaisseau getVaisseau(int id){
        switch(id){
            case 1:
                return PorteAvion;
            case 2:
                return Croiseur;
            case 3:
                return ContreTorpilleur;
            case 4:
                return SousMarin;
            case 5:
                return Torpilleur;
            default:
                return ErrNo;
        }
    }

    public String getNomVaisseau(int id){
        return getVaisseau(id).getNomBateau();
    }

    // Retourne l'objet vaisseau correspondant au string
    public Vaisseau getVaisseau(String nomVaisseau){
        switch(nomVaisseau){
            case "PorteAvion":
                return PorteAvion;
            case "Croiseur":
                return Croiseur;
            case "ContreTorpilleur":
                return ContreTorpilleur;
            case "SousMarin":
                return SousMarin;
            case "Torpilleur":
                return Torpilleur;
            default:
                return null;
        }
    }

    //Si le tir ne touche pas un vaisseau, on met la valeur -1, si le tir touche un vaisseau, on met la 0
    public int tir(String coordonnees){
        try{
            int[] coordonneesInt = traduireEnGrille(coordonnees);
            int x = coordonneesInt[0];
            int y = coordonneesInt[1];

            if(grid[x][y] == -2 || grid[x][y] == -1){
                grid[x][y] = -1;
                return 0;
            }else {
                grid[x][y] = 0;
                return 1;
            }
        } catch (IllegalArgumentException e){
            System.out.println("Erreur : " + e);
            return -1;
        }

    }

    //Ajoute un vaisseau à la grille. Orientation = 0 pour horizontal, 1 pour vertical
    public boolean ajouterVaisseau(Vaisseau v, String coordonnees, int orientation){
        if(verifierAjout(v, coordonnees, orientation)) {
                int[] coordonneesInt = traduireEnGrille(coordonnees);
                int x = coordonneesInt[0];
                int y = coordonneesInt[1];
                if (orientation == 1) {
                    for (int i = 0; i < v.getTaille(); i++) {
                        grid[x + i][y] = v.getId();
                    }
                } else {
                    for (int i = 0; i < v.getTaille(); i++) {
                        grid[x][y + i] = v.getId();
                    }
                }
                return true;
            }
        return false;
    }

    //Ajoute un vaisseau à la grille à l'aide de l'ID
    public boolean ajouterVaisseau(int id, String coordonnees, int orientation){
        return ajouterVaisseau(getVaisseau(id), coordonnees, orientation);
    }

    //Vérifie si le vaisseau à ajouter n'est pas en collision avec un autre vaisseau
    //et que les coordonnées sont valides en ne dépassant pas la taille de la grille
    private boolean verifierAjout(Vaisseau v, String coordonnees, int orientation){
        try {
            int[] coordonneesInt = traduireEnGrille(coordonnees);
            int x = coordonneesInt[0];
            int y = coordonneesInt[1];

            //Ne dépasse pas les limites de la grille
            if ((orientation == 0 && y + v.getTaille() > 9) || (orientation == 1 && x + v.getTaille() > 9))
                return false;

            //N'entre pas en collision avec un autre vaisseau sur la même colonne
            if(orientation == 0){
                for(int i = 0; i < v.getTaille(); i++){
                    if(grid[x+i][y] != -2){
                        return false;
                    }
                }

            }

            //N'entre pas en collision avec un autre vaisseau sur la même ligne
            else
            {
                for(int i = 0; i < v.getTaille(); i++){
                    if(grid[x][y+i] != -2){
                        return false;
                    }
                }
            }
            return true;

        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e);
            return false;
        }
    }

    //Vérifie si tous les vaisseaux sont coulés
    public boolean estGagne(){
        for(int i = 1; i < 6; i++){
            if (!getVaisseau(i).estCoule())
                return false;
            }
        return true;
    }

    //Vérifie si un vaisseau est coulé en utilisant son ID
    //Uniquement utilisé pour setCoule afin de vérifier si le vaisseau
    //N'est plus sur la grille
    private boolean estCoule(int id){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(grid[i][j] == id){
                    return false;
                }
            }
        }
        return true;
    }

    //Set le vaisseau en coulé s'il est détruit
    public boolean setCoule(){
        for (int i = 1; i < 6; i++) {
            if (estCoule(i) && !getVaisseau(i).estCoule()) {
                getVaisseau(i).setCoule();
                return true;
            }
        }
        return false;
    }

    //Traduit le string (Ex: "H7") en coordonnées de int (Ex: [7,8])
    //Retourne [x,y] avec x = colonne et y = ligne
    public int[] traduireEnGrille(String s) {
        if (s.length() == 2) {
            return switch (s.charAt(0)) {
                case 'A' -> new int[]{s.charAt(1) - '0' - 1, 0};
                case 'B' -> new int[]{s.charAt(1) - '0' - 1, 1};
                case 'C' -> new int[]{s.charAt(1) - '0' - 1, 2};
                case 'D' -> new int[]{s.charAt(1) - '0' - 1, 3};
                case 'E' -> new int[]{s.charAt(1) - '0' - 1, 4};
                case 'F' -> new int[]{s.charAt(1) - '0' - 1, 5};
                case 'G' -> new int[]{s.charAt(1) - '0' - 1, 6};
                case 'H' -> new int[]{s.charAt(1) - '0' - 1, 7};
                case 'I' -> new int[]{s.charAt(1) - '0' - 1, 8};
                case 'J' -> new int[]{s.charAt(1) - '0' - 1, 9};
                default -> throw new IllegalArgumentException("Numéro de ligne invalide : " + s.charAt(0));
            };
        } else {
            throw new IllegalArgumentException("Coordonnées invalides : " + s);
        }
    }

    //Return la vraie grille avec l'affichage des vaisseaux
    public String toString(){
        StringBuilder gridString = new StringBuilder();
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                if(grid[x][y] == -2){
                    gridString.append(" . ");
                }
                else if(grid[x][y] == -1){
                    gridString.append(" X ");
                }
                else{
                    gridString.append(" ").append(getVaisseau(grid[x][y]).getId()).append(" ");
                }
            }
            gridString.append("\n");
        }
        return gridString.toString();
    }

    //Return une grille en string pour l'affichage
    public String afficheBrouillardDeGuerre(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(grid[i][j] == -2){
                    s.append(" . ");
                }
                else if(grid[i][j] == -1){
                    s.append(" O ");
                } else if (grid[i][j] == 0){
                    s.append(" X ");
                } else{
                    s.append(" . ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}