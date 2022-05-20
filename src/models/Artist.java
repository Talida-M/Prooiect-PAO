package models;

import models.Factory.OpereFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Artist {
    private static int idA;
    private String nume, prenume;
    private String telefon, email;
    protected List<Opera> opere = new ArrayList<>();

    public Artist(String nume, String prenume, int i) {
        this.nume = nume;
        this.prenume =prenume;
        this.idA = i;
    }

    public void addOpera(String titlu, String an, String stil){
        Opera opera = OpereFactory.addOpera( titlu, an, stil);
        opere.add(opera);
    }

    public void setOpere(List<Opera> opere) {
        this.opere = opere;
    }

    public Artist(int idA, String nume, String prenume, String telefon, String email, List<Opera> opere) {
        this.idA = idA;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.email = email;
    }

    public Artist(ResultSet in) throws SQLException{
        this.nume = in.getString("Nume");
        this.prenume = in.getString("Prenume");
        this.telefon = in.getString("Numar contact");
        this.email = in.getString("Email");
    }


    public String getNume() {
        return nume;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id = " + idA + '\'' +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static int getIdA() {
        return idA;
    }

    public void read(ResultSet in) throws SQLException {
        this.idA = in.getInt("Id");
        this.nume = in.getString("Nume");
        this.prenume = in.getString("Prenume");
        this.telefon = in.getString("Telefon");
        this.email = in.getString("Email");

    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
