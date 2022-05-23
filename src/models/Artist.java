package models;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Artist extends Cont{
    private int idArt;
    private String descriere;


    public Artist(int idClient, String nume, String prenume, String ziNastere, String email, String telefon, String adresa, String parola, int  idArt, String descriere) {
        super(idClient, nume, prenume, ziNastere, email, telefon, adresa, parola);
        this.idArt = idArt;
        this.descriere = descriere;
    }
    public Artist(String nume, String prenume, String ziNastere, String email, String telefon, String adresa, String parola, int  idArt, String descriere) {
        super(nume, prenume, ziNastere, email, telefon, adresa, parola);
        this.idArt = idArt;
        this.descriere = descriere;
    }
    public Artist(String nume, String prenume, String ziNastere, String email, String telefon, String adresa, String parola,  String descriere) {
        super(nume, prenume, ziNastere, email, telefon, adresa, parola);
        this.descriere = descriere;
    }

    public Artist(String email, String parola) {
        super(email, parola);
    }

    public Artist(ResultSet in) throws SQLException{
        this.descriere = in.getString("Adauga Descriere:");

    }

    public Artist() {

    }


    public String getNume() {
        return nume;
    }

    @Override
    public String toString() {
        return "Artist{" +
                ", idClient=" + idClient +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", ziNastere='" + ziNastere + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
//                ", adresa=" + adresa +
                ", idArt=" + idArt +
                "descriere='" + descriere + '\'' +
                '}';
    }


    public void read(ResultSet in) throws SQLException {

        this.nume = in.getString("Nume");
        this.prenume = in.getString("Prenume");
        this.telefon = in.getString("Telefon");
        this.email = in.getString("Email");
        this.descriere = in.getString("Descriere");

    }

    public int getIdArt() {
        return idArt;
    }

    public void setIdArt(int idArt) {
        this.idArt = idArt;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}
