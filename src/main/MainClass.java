package main;

import models.Login;
import services.LoginRegister;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("What is your name?");
        Scanner in = new Scanner(System.in);

        LoginRegister.getInstance().luamCSV();
        try {
            LoginRegister.getInstance().inregistreazaClient(in);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        LoginRegister.getInstance().setClient(LoginRegister.getInstance().getConturi());
        LoginRegister.getInstance().toCSV();
        LoginRegister.getInstance().login();
    }

}
