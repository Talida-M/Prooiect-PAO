package models.Factory;

import models.Cont;
import models.Opera;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContFactory {
    private static int idUnic = 0;

    public static void incrementidUnic(int inc) {
        ContFactory.idUnic += inc;
    }
//    public Opera createOpera(Scanner in) throws ParseException{
//        return new Opera(idUnic++, in);
//    }

    public Cont createCont(ResultSet in) throws SQLException {
        return new Cont(idUnic++, in);
    }
}
