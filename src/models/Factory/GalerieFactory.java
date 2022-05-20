package models.Factory;

import models.Adresa;
import models.Artist;
import models.Galerie;
import models.Opera;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GalerieFactory {
    private static int idUnicG = 100;

    public static void incrementidUnic(int inc) {
        GalerieFactory.idUnicG+= inc;
    }
//    public Opera createOpera(Scanner in) throws ParseException{
//        return new Opera(idUnic++, in);
//    }

    public Galerie createGalerie(ResultSet in) throws SQLException {
        return new Galerie(idUnicG++, in);
    }
}
