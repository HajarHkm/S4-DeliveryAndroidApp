package entities;

/**
 * Created by Hajar on 23/04/2018.
 */

public class Livreur {

    int idlivreur;
    String nomlivreur;
    String prenomlivreur;
    String loginlivreur;
    String mdplivreur;
    String emaillivreur;
    String adresselivreur;
    String tellivreurt;
    String imagelivreur;


    public Livreur(String nomlivreur, String prenomlivreur, String loginlivreur, String mdplivreur, String emaillivreur, String adresselivreur, String tellivreurt) {
        this.nomlivreur = nomlivreur;
        this.prenomlivreur = prenomlivreur;
        this.loginlivreur = loginlivreur;
        this.mdplivreur = mdplivreur;
        this.emaillivreur = emaillivreur;
        this.adresselivreur = adresselivreur;
        this.tellivreurt = tellivreurt;
    }

    public String getImagelivreur() {
        return imagelivreur;
    }

    public void setImagelivreur(String imagelivreur) {
        this.imagelivreur = imagelivreur;
    }

    public int getIdlivreur() {
        return idlivreur;
    }

    public void setIdlivreur(int idlivreur) {
        this.idlivreur = idlivreur;
    }

    public String getNomlivreur() {
        return nomlivreur;
    }

    public void setNomlivreur(String nomlivreur) {
        this.nomlivreur = nomlivreur;
    }

    public String getPrenomlivreur() {
        return prenomlivreur;
    }

    public void setPrenomlivreur(String prenomlivreur) {
        this.prenomlivreur = prenomlivreur;
    }

    public String getLoginlivreur() {
        return loginlivreur;
    }

    public void setLoginlivreur(String loginlivreur) {
        this.loginlivreur = loginlivreur;
    }

    public String getMdplivreur() {
        return mdplivreur;
    }

    public void setMdplivreur(String mdplivreur) {
        this.mdplivreur = mdplivreur;
    }

    public String getEmaillivreur() {
        return emaillivreur;
    }

    public void setEmaillivreur(String emaillivreur) {
        this.emaillivreur = emaillivreur;
    }

    public String getAdresselivreur() {
        return adresselivreur;
    }

    public void setAdresselivreur(String adresselivreur) {
        this.adresselivreur = adresselivreur;
    }

    public String getTellivreurt() {
        return tellivreurt;
    }

    public void setTellivreurt(String tellivreurt) {
        this.tellivreurt = tellivreurt;
    }
}
