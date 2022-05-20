package models;

import models.Factory.OpereFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client extends Cont {
    private ArrayList<Opera> istoricAchizitii;

    public Client(int idClient, String nume, String prenume, Date ziNastere, String email, String telefon, Adresa adresa, String parola, ArrayList<Opera> istoricAchizitii) {
        super(idClient, nume, prenume, ziNastere, email, telefon, adresa, parola);
        this.istoricAchizitii = istoricAchizitii;
    }

    public ArrayList<Opera> getIstoricAchizitii() {
        return istoricAchizitii;
    }

    public void addIstoric(String titlu){
        Opera opera = OpereFactory.addIstoric( titlu);
        istoricAchizitii.add(opera);
    }
    public void setIstoricAchizitii(List<Opera> istoricAchizitii) {
        this.istoricAchizitii = (ArrayList<Opera>) istoricAchizitii;
    }
}
