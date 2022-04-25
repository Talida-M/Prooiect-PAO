package models;
import java.util.Scanner;
public class Adresa {

    private String strada, tara, oras;
    private int codPostal;

    public Adresa(String strada, String tara, int codPostal, String oras) {
        this.strada = strada;
        this.tara = tara;
        this.codPostal = codPostal;
        this.oras = oras;

    }
    public Adresa(Scanner in){
        this.read(in);
    }

    public void read(Scanner in){
        System.out.println("Strada: ");
        this.strada = in.nextLine();
        System.out.println("Oras: ");
        this.oras = in.nextLine();
        System.out.println("tara: ");
        this.tara = in.nextLine();
        System.out.println("Cod Postal: ");
        this.codPostal = Integer.parseInt(in.nextLine());
    }


    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    @Override
    public String toString() {
        return "{" +
                "strada='" + strada + '\'' +
                ", oras='" + oras + '\'' +
                ", tara='" + tara + '\'' +
                ", codPostal=" + codPostal +
                '}';
    }


}
