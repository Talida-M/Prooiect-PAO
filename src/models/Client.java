package models;

import java.util.ArrayList;
import java.util.Date;

public class Client extends Cont {
    private ArrayList<String> istoricAchizitii;

    public Client(String nume, String prenume, Date ziNastere, String email, String telefon, Adresa adresa, String parola, ArrayList<String> istoricAchizitii) {
        super(nume, prenume, ziNastere, email, telefon, adresa, parola);
        this.istoricAchizitii = istoricAchizitii;
    }

    public ArrayList<String> getIstoricAchizitii() {
        return istoricAchizitii;
    }

    public void setIstoricAchizitii(ArrayList<String> istoricAchizitii) {
        this.istoricAchizitii = istoricAchizitii;
    }
}
