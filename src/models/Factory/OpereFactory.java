package models.Factory;

import models.Opera;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class OpereFactory {
    private static int uniqueId = 23455;

public static Opera addOpera(String titlu, String an, String stil){
    return new Opera(uniqueId++, titlu, an, stil);
}
public static Opera addIstoric(String titlu)  {
        return new Opera(uniqueId++, titlu);
    }

    public Opera createOpera(ResultSet in) throws SQLException {
        return new Opera(uniqueId++, in);
    }
}
