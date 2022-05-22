package models;


import java.util.ArrayList;
import java.util.List;

public class VizitatorVirtual extends Cont {
    private ArrayList<String> listaDorinte;

    public VizitatorVirtual(int idClient, String nume, String prenume, String ziNastere, String email, String telefon, Adresa adresa, String parola, ArrayList<String> listaDorinte) {
        super(idClient, nume, prenume, ziNastere, email, telefon, adresa, parola);
        this.listaDorinte = listaDorinte;
    }

    public ArrayList<String> getlistaDorinte() {
        return listaDorinte;
    }


    public void setlistaDorinte(List<String> listaDorinte) {
        this.listaDorinte = (ArrayList<String>) listaDorinte;
    }

    @Override
    public String toString() {
        return "VizitatorVirtual{" +
                "listaDorinte=" + listaDorinte +
                '}';
    }
}
