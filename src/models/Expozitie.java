package models;

import java.util.Date;

public class Expozitie {
    private String titluExpozitie;
    private String tip;
    private Date dataInceput, dataSfarsit;
    protected Galerie galerie;

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

    public Date getDataInceput() {
        return dataInceput;
    }

    public void setDataInceput(Date dataInceput) {
        this.dataInceput = dataInceput;
    }

    public Date getDataSfarsit() {
        return dataSfarsit;
    }

    public void setDataSfarsit(Date dataSfarsit) {
        this.dataSfarsit = dataSfarsit;
    }

    public Galerie getGalerie() {
        return galerie;
    }

    public void setGalerie(Galerie galerie) {
        this.galerie = galerie;
    }

    public Expozitie(String titluExpozitie, String tip, Date dataInceput, Date dataSfarsit, Galerie galerie) {
        this.titluExpozitie = titluExpozitie;
        this.tip = tip;
        this.dataInceput = dataInceput;
        this.dataSfarsit = dataSfarsit;
        this.galerie = galerie;
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
}
