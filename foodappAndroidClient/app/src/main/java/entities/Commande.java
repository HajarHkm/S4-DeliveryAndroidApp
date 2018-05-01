package entities;

/**
 * Created by Hajar on 23/04/2018.
 */

public class Commande {
    int idcommande,idclient,idlivreur;
    String etat,nomlivraison, tellivraison,adresselivraison;

    public Commande(int idclient, int idlivreur, String etat, String nomlivraison, String tellivraison, String adresselivraison) {
        this.idclient = idclient;
        this.idlivreur = idlivreur;
        this.etat = etat;
        this.nomlivraison = nomlivraison;
        this.tellivraison = tellivraison;
        this.adresselivraison = adresselivraison;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getIdlivreur() {
        return idlivreur;
    }

    public void setIdlivreur(int idlivreur) {
        this.idlivreur = idlivreur;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getNomlivraison() {
        return nomlivraison;
    }

    public void setNomlivraison(String nomlivraison) {
        this.nomlivraison = nomlivraison;
    }

    public String getTellivraison() {
        return tellivraison;
    }

    public void setTellivraison(String tellivraison) {
        this.tellivraison = tellivraison;
    }

    public String getAdresselivraison() {
        return adresselivraison;
    }

    public void setAdresselivraison(String adresselivraison) {
        this.adresselivraison = adresselivraison;
    }
}
