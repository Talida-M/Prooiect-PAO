package models;

import java.util.Date;

public class Opera extends Artist{
    private int id;
    private String nume;
    private String an;
    private String stil;

    public Opera(String nume, String prenume, String telefon, String email, int id, String nume1, String an, String stil) {
        super(nume, prenume, telefon, email);
        this.id = id;
        this.nume = nume1;
        this.an = an;
        this.stil = stil;
    }

    @Override
    public String toString() {
        return "Opera{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", an='" + an + '\'' +
                ", stil='" + stil + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNume() {
        return nume;
    }

    @Override
    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public String getStil() {
        return stil;
    }

    public void setStil(String stil) {
        this.stil = stil;
    }
}
