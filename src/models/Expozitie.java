package models;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Expozitie {
    private int idE;
    private String titluExpozitie;
    private String tip;
    private String dataInceput, dataSfarsit;
    protected Galerie galerie;

    public Expozitie(int idE, String titluExpozitie, String tip, String dataInceput, String dataSfarsit, Galerie galerie) {
        this.idE = idE;
        this.titluExpozitie = titluExpozitie;
        this.tip = tip;
        this.dataInceput = dataInceput;
        this.dataSfarsit = dataSfarsit;
        this.galerie = galerie;
    }

    public Expozitie(String titluExpozitie, String tip, String dataInceput, String dataSfarsit, Galerie galerie) {
        this.titluExpozitie = titluExpozitie;
        this.tip = tip;
        this.dataInceput = dataInceput;
        this.dataSfarsit = dataSfarsit;
        this.galerie = galerie;
    }

    public Expozitie() {

    }

    public void read(Scanner in) throws ParseException {
        System.out.println("Titlu Expozitir: ");
        this.titluExpozitie = in.nextLine();
        System.out.println("Tip: ");
        this.tip = in.nextLine();
        System.out.println("Tip: ");
        this.tip = in.nextLine();
        System.out.println("Data inceput(dd-MM-yyyy): ");
        this.dataInceput = in.nextLine();
        System.out.println("Data sfarsit(dd-MM-yyyy): ");
        this.dataSfarsit = in.nextLine();
        this.galerie = new Galerie(in);
    }

    @Override
    public String toString() {
        return "Expozitie{" +
                "titluExpozitie='" + titluExpozitie + '\'' +
                ", tip='" + tip + '\'' +
                ", dataInceput=" + dataInceput +
                ", dataSfarsit=" + dataSfarsit +
                ", galerie=" + galerie +
                '}';
    }
    public String getTitluExpozitie() {
        return titluExpozitie;
    }

    public void setTitluExpozitie(String titluExpozitie) {
        this.titluExpozitie = titluExpozitie;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getDataInceput() {
        return dataInceput;
    }

    public void setDataInceput(String dataInceput) {
        this.dataInceput = dataInceput;
    }

    public String getDataSfarsit() {
        return dataSfarsit;
    }

    public void setDataSfarsit(String dataSfarsit) {
        this.dataSfarsit = dataSfarsit;
    }

    public Galerie getGalerie() {
        return galerie;
    }

    public void setGalerie(Galerie galerie) {
        this.galerie = galerie;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }
}
