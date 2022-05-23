package models;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Galerie {
    private int idGal;
    private String nume;
    private String locatie;


    public Galerie(Scanner in) throws ParseException {
        this.read(in);
    }


    public Galerie(String nume,  int idGal) {
        this.nume = nume;
        this.idGal = idGal;
    }

    public Galerie( int idGal, String nume) {
        this.idGal = idGal;
        this.nume = nume;
    }
    public Galerie( int idGal, String nume, String locatie) {
        this.idGal = idGal;
        this.nume = nume;
        this.locatie = locatie;
    }
    public Galerie(int id, ResultSet in) throws SQLException {
        this.idGal = id;
        this.nume = in.getString("Nume");
        this.locatie = in.getString("Loc");

    }
    public Galerie(ResultSet in) throws SQLException {
        this.nume = in.getString("Nume");
        this.locatie = in.getString("Loc");
    }

    public Galerie() {

    }

    public void read(ResultSet in) throws SQLException {
        this.idGal = in.getInt("Id");
        this.nume = in.getString("Nume");
        this.locatie = in.getString("Loc");
    }
    public void read(Scanner in) throws ParseException {
        System.out.println("Nume: ");
        this.nume = in.nextLine();
        System.out.println("Adresa: ");
        this.locatie = in.nextLine();

    }
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }



    public int getIdGal() {
        return idGal;
    }

    public void setIdGal(int idGal) {
        this.idGal = idGal;
    }


    @Override
    public String toString() {
        return "Galerie{" +
                "nume='" + nume + '\'' +
                ", locatie=" + locatie +
                '}';
    }
}
