package models;

import java.util.ArrayList;

public class Galerie {
    private String nume;
    private Adresa locatie;
    private ArrayList<Opera> opere;

    public Galerie(String nume, Adresa locatie, ArrayList<Opera> opere) {
        this.nume = nume;
        this.locatie = locatie;
        this.opere = opere;
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

    public ArrayList<Opera> getOpere() {
        return opere;
    }

    public void setOpere(ArrayList<Opera> opere) {
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
