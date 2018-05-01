package entities;

/**
 * Created by Hajar on 23/04/2018.
 */

public class LigneCommande {

    int idligne;
    int idcommande;
    int idplat;
    int quantity;

    public LigneCommande( int idcommande, int idplat, int quantity) {
        this.idcommande = idcommande;
        this.idplat = idplat;
        this.quantity = quantity;
    }

    public int getIdligne() {
        return idligne;
    }

    public void setIdligne(int idligne) {
        this.idligne = idligne;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    public int getIdplat() {
        return idplat;
    }

    public void setIdplat(int idplat) {
        this.idplat = idplat;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
