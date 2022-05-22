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
    private Adresa locatie;
    private List<Opera> opere = new ArrayList<>();

    public Galerie(Scanner in) throws ParseException {
        this.read(in);
    }


    public Galerie(String nume,  int idGal) {
        this.nume = nume;
        this.idGal = idGal;
    }


    public Galerie(final int idGal, String nume, Adresa locatie, ArrayList<Opera> opere) {
        this.idGal = idGal;
        this.nume = nume;
        this.locatie = locatie;
        this.opere = opere;
    }
    public Galerie(int id, ResultSet in) throws SQLException {
        this.idGal = id;
        this.nume = in.getString("Nume");
        this.locatie = new Adresa(in);
        this.opere = (List<Opera>) in.getObject("Opere");

    }
    public Galerie(ResultSet in) throws SQLException {
        this.nume = in.getString("Nume");
        this.locatie = new Adresa(in);
        this.opere = (List<Opera>) in.getObject("Opere");
    }

    public Galerie() {

    }

    public void read(ResultSet in) throws SQLException {
        this.idGal = in.getInt("Id");
        this.nume = in.getString("Nume");
        this.locatie = new Adresa(in);
        this.opere =  (List<Opera>) in.getObject("Opere");
    }
    public void read(Scanner in) throws ParseException {
        System.out.println("Nume: ");
        this.nume = in.nextLine();
        System.out.println("Adresa: ");
        this.locatie = new Adresa(in);

    }
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Adresa getLocatie() {
        return locatie;
    }

    public void setLocatie(Adresa locatie) {
        this.locatie = locatie;
    }

    public List<Opera> getOpere() {
        return opere;
    }

    public void setOpere(ArrayList<Opera> opere) {
        this.opere = opere;
    }

    public int getIdGal() {
        return idGal;
    }

    public void setIdGal(int idGal) {
        this.idGal = idGal;
    }

    public void setOpere(List<Opera> opere) {
        this.opere = opere;
    }

    @Override
    public String toString() {
        return "Galerie{" +
                "nume='" + nume + '\'' +
                ", locatie=" + locatie +
                ", opere=" + opere +
                '}';
    }
}
