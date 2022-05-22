package main;
import services.Audit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    boolean end = false;
    Audit audit = new Audit();
    static List<String> comenziDisponibile = Arrays.asList("register", "login", "afiseaza conturi");

    public static void main(String[] args) throws ParseException, IOException, SQLException {


    }

}
