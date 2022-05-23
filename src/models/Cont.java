package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Scanner;


public class Cont {


    protected   int idClient;
    protected String nume, prenume;
    protected String ziNastere;
    protected String email, telefon;
    protected String adresa;


//    public Cont(int customerId, Scanner in) throws ParseException {
//        this.idClient = getIdClient();
//        this.read(in);
//    }

    public Cont(int customerId, ResultSet in) throws SQLException {
        this.idClient = customerId;
        this.read(in);
    }
    public Cont(Scanner in) throws ParseException {
        this.read(in);
    }
    public Cont( String email, String parola) {
        this.email = email;
        this.parola = parola;
    }

    public Cont( String nume, String prenume, String ziNastere, String email, String telefon, String adresa, String parola) {
        this.nume = nume;
        this.prenume = prenume;
        this.ziNastere = ziNastere;
        this.email = email;
        this.telefon = telefon;
        this.adresa = adresa;
        this.parola = parola;
    }
    public Cont(int idClient, String nume, String prenume, String ziNastere, String email, String telefon, String adresa,  String parola) {
        this.idClient = idClient;
        this.nume = nume;
        this.prenume = prenume;
        this.ziNastere = ziNastere;
        this.email = email;
        this.telefon = telefon;
        this.adresa = adresa;
        this.parola = parola;
    }

    public Cont() {

    }


    public int getIdClient() {
        return idClient;
    }


    public void read(ResultSet in) throws SQLException {
        this.nume = in.getString("Nume");
        this.prenume = in.getString("Prenume");
        this.ziNastere = in.getString("Zi de nastere");
        this.email = in.getString("email");
        this.telefon = in.getString("telefon");
//        this.adresa = new Adresa(in);
        this.parola = in.getString("Parola");
    }

    public void read(Scanner in) throws ParseException {
        System.out.println("Nume: ");
        this.nume = in.nextLine();
        System.out.println("Prenume: ");
        this.prenume = in.nextLine();
        System.out.println("Zi nastere (yyyy-MM-dd): ");
        this.ziNastere = in.nextLine();
        System.out.println("Email: ");
        this.email = in.nextLine();
        System.out.println("telefon: ");
        this.telefon = in.nextLine();
        System.out.println("Adresa: ");
        this.adresa = in.nextLine();
//        this.adresa = new Adresa(in);
        System.out.println("Parola: ");
        this.parola = in.nextLine();
    }
    @Override
    public String toString() {
        return "VizitatorVirtual{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", ziNastere=" + ziNastere +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adresa=" + adresa + '\'' +
                ", parola=" + parola +
                '}';
    }
    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    private String parola;


    public String getNume() {
        return nume;
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

    public String getZiNastere() {
        return ziNastere;
    }

    public void setZiNastere(String ziNastere) {
        this.ziNastere = ziNastere;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }


    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }


}
