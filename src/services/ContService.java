package services;

import database.AdresaDB;
import database.ArtistDB;
import database.ContDB;
import models.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class ContService {
    private ContDB contDB;
    private ArtistDB artistDB;
    Audit audit = new Audit();
    private AdresaDB adresaDB;
    protected  int rol_;

    public  ContService(){}
    public int getRol() {
        return rol_;
    }


    public void setRol(int rol_) {
        this.rol_ = rol_;
    }

    public ContService(ContDB contDB) {
        this.contDB = contDB;
    }
    public void register(Cont cont) throws SQLException {
        contDB.addCont(cont);
        Scanner scanner = new Scanner(System.in);
        createArtist(cont, scanner);
    }
    public void createArtist(Cont cont, Scanner scanner){
        System.out.println("Adaugati o descriere pentru ca vizitatorii sa poata afla mai multe despre persoana din spatelel operelor");
        String descriere = scanner.nextLine();
        Artist artist = new Artist(cont.getIdClient(), cont.getNume(),
                cont.getPrenume(), cont.getZiNastere(), cont.getEmail(), cont.getTelefon(), cont.getAdresa(), cont.getParola(), 0,  descriere);
        artistDB.addArtist(artist);
    }
    public Map<Integer, Cont> getAllConturi() {
        return contDB.getAllConturi();
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
//    public void updateEmail(Map<Integer, Cont> conturi, Scanner scanner) throws SQLException {
//        for (Map.Entry<Integer, Cont> c : conturi.entrySet()) {
//            System.out.println(c.getKey() + ". " + c.getValue().getNume() + " " + c.getValue().getPrenume());
//        }
//        System.out.println("Id-ul contului care necesita update");
//        String id = scanner.nextLine();
//        System.out.println("Noul Email.");
//        String email = scanner.nextLine();
//        Cont cont = conturi.get(Integer.parseInt(id));
//        contDB.updateEmail(cont, email);
//        System.out.println("Email modificat cu succes");
//    }

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

    public Cont Login (Scanner scanner, int rol) throws IOException {
        Roluri rol1;
        this.rol_ = rol;
        if (Roluri.compareToArt(rol) ){
            System.out.println("Email");
            String email = scanner.nextLine();
            if (email.equals(contDB.getEmail(email))) {
                System.out.println("Parola");
                String parola = scanner.nextLine();
                if (email.equals(contDB.getParola(email))) {
                    System.out.println("Rol: " + Roluri.getByCode(rol) + " Bun venit");
                    return new Artist(email, parola);
                }
                else {
                    System.out.println("Parola incorecta");
                    System.out.println("Introduceti din nou parola");
                    System.out.println("Parola");
                    String parola2 = scanner.nextLine();
                    if (email.equals(contDB.getParola(email))) {
                        System.out.println("Rol: " + Roluri.getByCode(rol) + " Bun venit");
                        return new Artist(email, parola2);
                    }
                    else {
                        System.out.println("Parola incorecta");
                        return null;
                    }
                }

            }
            else {
                System.out.println("Nu exista cont inregistrat cu acest email");
                return null;
            }
        }
        if (Roluri.compareToC(rol) ){
            System.out.println("Email");
            String email = scanner.nextLine();
            if (email.equals(contDB.getEmail(email))) {
                System.out.println("Parola");
                String parola = scanner.nextLine();
                if (email.equals(contDB.getParola(email))) {
                    return new Cont(email, parola);
                }
                else {
                    System.out.println("Parola incorecta");
                    System.out.println("Introduceti din nou parola");
                    System.out.println("Parola");
                    String parola2 = scanner.nextLine();
                    if (email.equals(contDB.getParola(email))) {
                        System.out.println("Rol: " + Roluri.getByCode(rol) + " Bun venit ");
                        return new Cont(email, parola2);
                    }
                    else {
                        System.out.println("Parola incorecta");
                        return null;
                    }
                }

            }
            else {
                System.out.println("Nu exista cont inregistrat cu acest email");
                return null;
            }

        }
        if (Roluri.compareTo(rol) ){
            System.out.println("Nume ");
            String nume = scanner.nextLine();
            System.out.println("Prenume ");
            String prenume = scanner.nextLine();
            System.out.println("Cod Acces");
            String codA = scanner.nextLine();
            FileReader fr = new FileReader("Cheie.txt");
            Scanner inFile = new Scanner(fr);
            String  cod;
            String n = nume + " " + prenume;
            cod = inFile.nextLine();
            if (codA.equals(cod))
                System.out.println("Bun venit " + n);
                Administrator adm =  new Administrator(nume, prenume);
                audit.addAction4(nume + " " + prenume);
                return new Cont(nume, codA);

        }
        return null;
    }

    public Cont cont (Scanner scanner) {
        System.out.println("Completati astfel: nume/prenume/ziNastere/email/telefon/phone number/adresa/parola");
        String line = scanner.nextLine();
        String[] sp = line.split("/");
        System.out.println("Locatie:");

        return new Cont(sp[0], sp[1], sp[2], sp[3], sp[4], sp[5],  sp[6]);
    }
    public  void delogare(){
        this.rol_ = 0;
        System.out.println("Ati fost delogat cu succes");
        return;

    }

}
