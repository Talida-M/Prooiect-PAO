package services;

import database.ContDB;
import models.Adresa;
import models.Cont;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class ContService {
    private ContDB contDB;

    public ContService(ContDB contDB) {
        this.contDB = contDB;
    }
    public void register(Cont cont) throws SQLException {
        contDB.addCont(cont);
    }
    public Map<Integer, Cont> getAllConturi(Map<Integer, Adresa> locatii) {
        return contDB.getAllConturi(locatii);
    }
    public  void deleteCont(Map<Integer, Cont> conturi, Scanner scanner){
        for (Map.Entry<Integer, Cont> c : conturi.entrySet()){
            System.out.println(c.getKey() + " " + c.getValue().getNume() + " " + c.getValue().getPrenume());
        }
        System.out.println("Alegeti id-ul contului care doriti sa fie sters");
        String idClient =  scanner.nextLine();
        Cont cont = conturi.get(Integer.parseInt(idClient));
        System.out.println("Sunteti sigur ca doriti sa stergeti acest cont? da/nu");
        String r = scanner.nextLine();
        if (r.equals("da")) {
            contDB.deleteCont(cont);
            System.out.println("Contul a fost sters");
        }
        else{
            System.out.println("Contul NU a fost sters");
        }

    }
    public void updateEmail(Map<Integer, Cont> conturi, Scanner scanner) throws SQLException {
        for (Map.Entry<Integer, Cont> c : conturi.entrySet()) {
            System.out.println(c.getKey() + ". " + c.getValue().getNume() + " " + c.getValue().getPrenume());
        }
        System.out.println("Id-ul contului care necesita update");
        String id = scanner.nextLine();
        System.out.println("Noul Email.");
        String email = scanner.nextLine();
        Cont cont = conturi.get(Integer.parseInt(id));
        contDB.updateEmail(cont, email);
        System.out.println("Email modificat cu succes");
    }

    public void updateTelefon(Map<Integer, Cont> conturi, Scanner scanner) throws SQLException {
        for (Map.Entry<Integer, Cont> c : conturi.entrySet()) {
            System.out.println(c.getKey() + ". " + c.getValue().getNume() + " " + c.getValue().getPrenume());
        }
        System.out.println("Id-ul contului care necesita update");
        String id = scanner.nextLine();
        System.out.println("Noul numar de telefon.");
        String telefon = scanner.nextLine();
        Cont cont = conturi.get(Integer.parseInt(id));
        contDB.updateEmail(cont, telefon);
        System.out.println("Telefon modificat cu succes");
    }

    public void changePassword(Map<Integer, Cont> conturi, Scanner scanner) throws SQLException {
        for (Map.Entry<Integer, Cont> c : conturi.entrySet()) {
            System.out.println(c.getKey() + ". " + c.getValue().getNume() + " " + c.getValue().getPrenume());
        }
        System.out.println("Id-ul contului care necesita schimbarea parolei");
        String id = scanner.nextLine();
        System.out.println("Noua parola.");
        String parola = scanner.nextLine();
        Cont cont = conturi.get(Integer.parseInt(id));
        contDB.updateEmail(cont, parola);
        System.out.println("Parola modificat cu succes");
    }
}
