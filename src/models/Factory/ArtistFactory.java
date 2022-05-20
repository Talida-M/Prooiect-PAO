package models.Factory;

import models.Artist;
import models.Cont;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistFactory {
    private static int idUnic2 = 100;

    public static void incrementidUnic(int inc) {
        ArtistFactory.idUnic2 += inc;
    }
//    public Opera createOpera(Scanner in) throws ParseException{
//        return new Opera(idUnic++, in);
//    }

    public Artist createArtist(String nume, String prenume, int idA) throws SQLException {
        return new Artist(nume, prenume, idUnic2++);
    }
}
