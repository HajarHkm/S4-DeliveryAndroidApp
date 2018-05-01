package entities;

/**
 * Created by Hajar on 23/04/2018.
 */

public class Client {

    int idclient;
    String nomclient;
    String prenomclient;
    String loginclient;
    String mdpclient;
    String emailclient;
    String adresseclient;
    String telclient;

    public Client(String nomclient, String prenomclient, String loginclient, String mdpclient, String emailclient, String adresseclient, String telclient) {
        this.nomclient = nomclient;
        this.prenomclient = prenomclient;
        this.loginclient = loginclient;
        this.mdpclient = mdpclient;
        this.emailclient = emailclient;
        this.adresseclient = adresseclient;
        this.telclient = telclient;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getNomclient() {
        return nomclient;
    }

    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }

    public String getPrenomclient() {
        return prenomclient;
    }

    public void setPrenomclient(String prenomclient) {
        this.prenomclient = prenomclient;
    }

    public String getLoginclient() {
        return loginclient;
    }

    public void setLoginclient(String loginclient) {
        this.loginclient = loginclient;
    }

    public String getMdpclient() {
        return mdpclient;
    }

    public void setMdpclient(String mdpclient) {
        this.mdpclient = mdpclient;
    }

    public String getEmailclient() {
        return emailclient;
    }

    public void setEmailclient(String emailclient) {
        this.emailclient = emailclient;
    }

    public String getAdresseclient() {
        return adresseclient;
    }

    public void setAdresseclient(String adresseclient) {
        this.adresseclient = adresseclient;
    }

    public String getTelclient() {
        return telclient;
    }

    public void setTelclient(String telclient) {
        this.telclient = telclient;
    }
}
