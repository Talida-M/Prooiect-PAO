package services;

import database.ExpozitieDB;
import database.GalerieDB;
import models.Expozitie;
import models.Galerie;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class GalerieExpozitieService {
    private GalerieDB galerieDB;
    private ExpozitieDB expozitieDB;
    public GalerieExpozitieService (){}

    public void updateNumeGalerie(Map<Integer, Galerie> galerieMap, Scanner scanner) throws SQLException {
        for (Map.Entry<Integer, Galerie> c : galerieMap.entrySet()) {
            System.out.println(c.getKey() + ". " + c.getValue().getNume());
        }
        System.out.println("Id-ul galeriei pentru a putea face  update");
        String id = scanner.nextLine();
        System.out.println("Noul Nume.");
        String nume = scanner.nextLine();
        Galerie galerie = galerieMap.get(Integer.parseInt(id));
        galerieDB.updateNume(galerie, nume);
        System.out.println("Numele a fost modificat cu succes");
    }
    public Map<Integer, Galerie> getGalerie() {
        return (Map<Integer, Galerie>) galerieDB.getGalerie();
    }
public void createExpozitie(Expozitie expozitie) throws SQLException {
    expozitieDB.addExpozitie(expozitie);
}
    public void updateData(Expozitie expozitie, String dataInceput, String dataSfarsit, Scanner scanner) throws SQLException {

        System.out.println("Id-ul expozitiei care necesita update");
        String id = scanner.nextLine();
        expozitieDB.updateData(expozitie, dataInceput, dataSfarsit);
        System.out.println("Data a fost modificata cu succes");
        return;
    }

    public  void deleteExpo(Map<Integer, Expozitie> expozitieMap, Scanner scanner){
        for (Map.Entry<Integer, Expozitie> c : expozitieMap.entrySet()){
            System.out.println(c.getKey() + " " + c.getValue().getTitluExpozitie());
        }
        System.out.println("Alegeti id-ul expozitiei care doriti sa fie stearsa");
        String idE =  scanner.nextLine();
        Expozitie expozitie = expozitieMap.get(Integer.parseInt(idE));
        System.out.println("Sunteti sigur ca doriti sa stergeti aceasta expozitie? da/nu");
        String r = scanner.nextLine();
        if (r.equals("da")) {
            expozitieDB.deleteExpozitie(expozitie);
            System.out.println("Expozitia " + expozitie.getTitluExpozitie() + "  a fost stearsa");
        }
        else{
            System.out.println("Expozitia NU a fost stearsa");
        }
    }

    public Expozitie expoGal (Scanner scanner, Galerie galerieMap) {
        System.out.println("Completati astfel: titlu expozitie/tip/data Inceput/data Sfarsit/galerie");
        String line = scanner.nextLine();
        String[] sp = line.split("/");
        System.out.println("Galerie:");
        return new Expozitie(sp[0], sp[1], sp[2], sp[3], galerieMap);
    }
    public Map<Integer, Expozitie> getExpozitii(Map<Integer, Galerie> galerie) {
        return (Map<Integer, Expozitie>) expozitieDB.getAllExpozitii(galerie);
    }
}
