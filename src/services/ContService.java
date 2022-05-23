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

    public  ContService(){
        this.contDB = new ContDB();
        this.artistDB = new ArtistDB();
    }

    public int getRol() {
        return rol_;
    }


    public void setRol(int rol_) {
        this.rol_ = rol_;
    }


    public void register(Cont cont) throws SQLException {
        contDB.addCont(cont);
//        Scanner scanner = new Scanner(System.in);
//        createArtist(cont, scanner);
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
        String id = scanner.next();
        System.out.println("Noul numar de telefon.");
        String telefon = scanner.next();
        Cont cont = conturi.get(Integer.parseInt(id));
        contDB.updateEmail(cont, telefon);
        System.out.println("Telefon modificat cu succes");
    }
 public int getId(String email){
        return contDB.getId(email);
 }
    public void changePassword(Map<Integer, Cont> conturi, Scanner scanner) throws SQLException {
        for (Map.Entry<Integer, Cont> c : conturi.entrySet()) {
            System.out.println(c.getKey() + ". " + c.getValue().getNume() + " " + c.getValue().getPrenume());
        }
        System.out.println("Id-ul contului care necesita schimbarea parolei");
        String id = scanner.next();
        System.out.println("Noua parola.");
        String parola = scanner.next();
        Cont cont = conturi.get(Integer.parseInt(id));
        contDB.changePassword(cont, parola);
        System.out.println("Parola modificat cu succes");
    }

    public void Login (Scanner scanner, int rol, Map<Integer, Cont> conturi) throws IOException {
        this.rol_ = rol;
        if (rol == 2){
            int contor = 0;
            System.out.println("Email");
            String email = scanner.next();
            for (Map.Entry<Integer, Cont> c : conturi.entrySet()) {
                if (email.equals(c.getValue().getEmail())){
                    contor = 1;
                    break;
                }
            }
            if (contor == 1) {
                System.out.println("Parola");
                String parola = scanner.next();
                int c2 = 0;
                for (Map.Entry<Integer, Cont> c : conturi.entrySet()) {
                    if (parola.equals(c.getValue().getParola())) {
                        c2 = 1;
                        break;
                    }
                }
                if (c2 == 1) {
                    System.out.println("Rol: Vizitator"   + " Bun venit");
                   // return new Cont(contDB.getContById();email, parola);
                }
                else {
                    System.out.println("Parola incorecta");
                    System.out.println("Introduceti din nou parola");
                    System.out.println("Parola");
                    String parola2 = scanner.next();
                    int c3 = 0;
                    for (Map.Entry<Integer, Cont> c : conturi.entrySet()) {
                        if (parola.equals(c.getValue().getParola())) {
                            c3 = 1;
                            break;
                        }
                    }
                    if (c3 == 1) {
                        System.out.println("Rol: Vizitator"   + " Bun venit");
                     //   return new Cont(email, parola2);
                    }
                    else {
                        System.out.println("Parola incorecta");
                        System.exit(0);
                    }
                }

            }
            else {
                System.out.println("Nu exista cont inregistrat cu acest email");
                System.exit(0);
            }
        }
        if (rol == 3){
            int contor = 0;
            System.out.println("Email");
            String email = scanner.next();
            for (Map.Entry<Integer, Cont> c : conturi.entrySet()) {
                if (email.equals(c.getValue().getEmail())){
                    contor = 1;
                    break;
                }
            }
            if (contor == 1) {
                System.out.println("Parola");
                String parola = scanner.next();
                int c2 = 0;
                for (Map.Entry<Integer, Cont> c : conturi.entrySet()) {
                    if (parola.equals(c.getValue().getParola())) {
                        c2 = 1;
                        break;
                    }
                }
                if (c2 == 1) {
                    System.out.println("Rol: Vizitator"   + " Bun venit");
                    // return new Cont(contDB.getContById();email, parola);
                }
                else {
                    System.out.println("Parola incorecta");
                    System.out.println("Introduceti din nou parola");
                    System.out.println("Parola");
                    String parola2 = scanner.next();
                    int c3 = 0;
                    for (Map.Entry<Integer, Cont> c : conturi.entrySet()) {
                        if (parola.equals(c.getValue().getParola())) {
                            c3 = 1;
                            break;
                        }
                    }
                    if (c3 == 1) {
                        System.out.println("Rol: Vizitator"   + " Bun venit");
                        //   return new Cont(email, parola2);
                    }
                    else {
                        System.out.println("Parola incorecta");
                        System.exit(0);
                    }
                }

            }
            else {
                System.out.println("Nu exista cont inregistrat cu acest email");
                System.exit(0);
            }

        }
        if (rol == 1){
            System.out.println("Nume ");
            String nume = scanner.next();
            System.out.println("Prenume ");
            String prenume = scanner.next();
            System.out.println("Cod Acces");
            String codA = scanner.next();
            FileReader fr = new FileReader("src/services/cheie.txt");
            Scanner inFile = new Scanner(fr);
            String  cod;
            String n = nume + " " + prenume;
            cod = inFile.nextLine();
            if (codA.equals(cod))
                System.out.println("Bun venit " + n);
                Administrator adm =  new Administrator(nume, prenume);
                audit.addAction4(nume + " " + prenume);
                //return new Cont(nume, codA);

        }
       // return null;
    }

    public Cont cont (Scanner scanner) {
        System.out.println("Completati cu: nume/prenume/ziNastere/email/telefon/adresa(strada,nr,oras -fara spatii-)/parola");
        String nume = scanner.next();
        String prenume= scanner.next();
        String zi = scanner.next();
        String email = scanner.next();
        String t = scanner.next();
        String adr = scanner.next();
        String p = scanner.next();
        return new Cont( nume, prenume, zi, email, t, adr, p);
    }
    public  void delogare(){
        this.rol_ = 0;
        System.out.println("Ati fost delogat cu succes");
        return;

    }

}
