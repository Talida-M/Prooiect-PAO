package main;

import services.Audit;
import services.LoginRegister;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class MainClass {
    boolean end = false;
    Audit audit = new Audit();
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/proiect_pao";
            String user = "root";
            String password = "ParolaMySQL16";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public static void main(String[] args) throws ParseException, IOException {
        Scanner in = new Scanner(System.in);

        LoginRegister client = new LoginRegister();
//        client.inregistreazaClient(in);
//        client.inregistreazaClient(in);
//        client.login();
        LoginRegister admin = new LoginRegister();
        admin.loginAdministrator(in);
//        LoginRegister.getInstance().login();
    }

}
