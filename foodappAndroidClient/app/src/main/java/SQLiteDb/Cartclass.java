package SQLiteDb;

/**
 * Created by Hajar on 29/04/2018.
 */

public class Cartclass {

    public String plat_nom;
    public  String plat_image;
    public  int plat_prix;
    public  int plat_quantity;
    public int plat_id;

    public Cartclass(String plat_nom, String plat_image, int plat_prix, int plat_quantity, int plat_id) {
        this.plat_nom = plat_nom;
        this.plat_image = plat_image;
        this.plat_prix = plat_prix;
        this.plat_quantity = plat_quantity;
        this.plat_id = plat_id;
    }

    public String getPlat_nom() {
        return plat_nom;
    }

    public void setPlat_nom(String plat_nom) {
        this.plat_nom = plat_nom;
    }

    public String getPlat_image() {
        return plat_image;
    }

    public void setPlat_image(String plat_image) {
        this.plat_image = plat_image;
    }

    public int getPlat_prix() {
        return plat_prix;
    }

    public void setPlat_prix(int plat_prix) {
        this.plat_prix = plat_prix;
    }

    public int getPlat_quantity() {
        return plat_quantity;
    }

    public void setPlat_quantity(int plat_quantity) {
        this.plat_quantity = plat_quantity;
    }

    public int getPlat_id() {
        return plat_id;
    }

    public void setPlat_id(int plat_id) {
        this.plat_id = plat_id;
    }
}
