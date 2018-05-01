package entities;

/**
 * Created by Hajar on 23/04/2018.
 */

public class Plat {

    int idrestau;
    int idplat;
    String imagepath;
    String nomplat;
    int prixplat;

    public String getNomplat() {
        return nomplat;
    }

    public void setNomplat(String nomplat) {
        this.nomplat = nomplat;
    }

    public int getPrixplat() {
        return prixplat;
    }

    public void setPrixplat(int prixplat) {
        this.prixplat = prixplat;
    }

    public int getIdrestau() {
        return idrestau;
    }

    public void setIdrestau(int idrestau) {
        this.idrestau = idrestau;
    }

    public int getIdplat() {
        return idplat;
    }

    public void setIdplat(int idplat) {
        this.idplat = idplat;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
}
