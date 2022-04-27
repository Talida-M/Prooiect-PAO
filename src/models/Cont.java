package models;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Cont {
   // private final int idClient;
    private String nume, prenume;
    private Date ziNastere;
    private String email, telefon;

    public Cont(String nume, String prenume, Date ziNastere, String email, String telefon, Adresa adresa, String parola) {
        this.nume = nume;
        this.prenume = prenume;
        this.ziNastere = ziNastere;
        this.email = email;
        this.telefon = telefon;
        this.adresa = adresa;
        this.parola = parola;
    }

    private Adresa adresa;

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

    public Date getZiNastere() {
        return ziNastere;
    }

    public void setZiNastere(Date ziNastere) {
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

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public void read(Scanner in) throws ParseException {
        System.out.println("Prenume: ");
        this.prenume = in.nextLine();
        System.out.println("Nume: ");
        this.nume = in.nextLine();
        System.out.println("Zi nastere (yyyy-MM-dd): ");
        this.ziNastere = new SimpleDateFormat("yyyy-MM-dd").parse(in.nextLine());
        System.out.println("Email: ");
        this.email = in.nextLine();
        System.out.println("telefon: ");
        this.telefon = in.nextLine();
        System.out.println("Adresa: ");
        this.adresa = new Adresa(in);
        System.out.println("Parola: ");
        this.parola = in.nextLine();
    }
    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", ziNastere=" + ziNastere +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adresa=" + adresa + '\'' +
                ", parola=" + parola +
                '}';
    }

    public String toCSV() {
        return nume + "," + prenume
                + "," + (new SimpleDateFormat("yyyy-MM-dd")).format(ziNastere)
                + "," + email + "," + telefon
                + "," + adresa.toCSV() + "," + parola;
    }
}
