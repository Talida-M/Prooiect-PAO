package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Opera{
    private  int id;
    private String titlu;
    private String an;
    private String stil;

    public Opera( int id,  String titlu, String an, String stil) {
        this.id = id;
        this.titlu = titlu;
        this.an = an;
        this.stil = stil;
    }
    public Opera( int id,  String titlu) {
        this.id = id;
        this.titlu = titlu;
    }




    @Override
    public String toString() {
        return "Opera{" +
                "id=" + id +
                ", nume='" + titlu + '\'' +
                ", an='" + an + '\'' +
                ", stil='" + stil + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public Opera( ResultSet in) throws SQLException {
        this.titlu = in.getString("Nume");
        this.an = in.getString("An");
        this.stil = in.getString("Stil");
    }
    public void read( Scanner in) throws SQLException {
        System.out.println("Titlu: ");
        this.titlu = in.nextLine();
        System.out.println("An: ");
        this.an = in.nextLine();
        System.out.println("Stil: ");
        this.stil = in.nextLine();
    }


    public Opera(int id, ResultSet in) throws SQLException {
        this.id = id;
        this.titlu = in.getString("Nume");
        this.an = in.getString("An");
        this.stil = in.getString("Stil");

    }


    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String nume) {
        this.titlu = titlu;
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
