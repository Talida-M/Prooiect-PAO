package main;
import models.*;
import services.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

public class MainClass {
    boolean end = false;
    Audit audit = new Audit();

    static List<String> comenziDisponibile = Arrays.asList("register", "login", "artist");

    public static final String purple = "\u001B[45m";
    public static final String cyan = "\u001B[46m";
    public static final String green = "\u001B[42m";
    public final String yellowBackg = "\u001B[43m";
    public static final String bold = "\u001B[1m";
    public static final String reset = "\u001B[0m";
    public static String stil;

    public static void main(String[] args) throws ParseException, IOException, SQLException {
        ContService contService = new ContService();
        ArtistServices artistServices = new ArtistServices();
        GalerieExpozitieService galerieExpozitieService = new GalerieExpozitieService();
        VizitatorServices vizitatorServices = new VizitatorServices();
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> lista = new HashMap<>();
//        Map<Integer, Adresa> locatii = contService.getAdrese();
        Map<Integer, Cont> contS = contService.getAllConturi();
        Map<Integer, Opera> opereS = artistServices.getAllOpere();
        Map<Integer, Galerie> galerie = galerieExpozitieService.getGalerie();
        Map<Integer, Expozitie> expoS = galerieExpozitieService.getExpozitii(galerie);
        Map<Integer, Artist> artistS = artistServices.getArtisti();
        Map<Integer, ArtistOpere> artistOpereM = artistServices.getAllAO();
        Map<String, Opera> opereStil = artistServices.getAllOpereByStil(stil);

        System.out.println(bold + "Bun venit in lumea virtuala a artei, Galeria ART IS LIFE" + reset);
        System.out.println("In funtie de rolul pe care il aveti, puteti alege din meniul cu optiuni");
        System.out.println("Sunteti ADMIN(1)/VIZITATOR(2)/ARTIST(3)?");
        Integer r = scanner.nextInt();
        while (true) {
            System.out.println("MENIU");
            if (r == 2) { //pentru vizitator/client
                System.out.println(purple + " 1.Register " + reset);
                System.out.println(purple + " 2.Login " + reset);
                System.out.print("Optiunea este: ");
                int o = scanner.nextInt();
                switch (o) {
                    case 0: {
                        System.out.println(purple + "Sesiunea a fost abandonata" + reset);
                        System.exit(0);
                    }
                    case 2: {
                        contService.Login(scanner, r);
                        boolean bool = true;
                        while (bool) {
                            System.out.println();
                            System.out.println(purple + "1.Vizualizeaza detaliile despre viitoarele expozitii ");
                            System.out.println(purple + "2.Vizualizare  Opere ");
                            System.out.println(purple + "3.Cereri Catre Admin ");
                            System.out.println("4.Inapoi la meniu.");
                            System.out.println("Alege optiunea");
                            int submeniu = scanner.nextInt();
                            switch (submeniu) {
                                case 4: {
                                    bool = false;
                                    break;
                                }
                                case 1: {
                                    for (Map.Entry<Integer, Expozitie> expo : expoS.entrySet()) {
                                        System.out.println(expo.getValue().getTitluExpozitie() + " " + expo.getValue().getDataInceput() + " " + expo.getValue().getDataSfarsit() + " " + expo.getValue().getTip());

                                    }
                                    System.out.println("Enter pentru a iesi");
                                    String iesire = scanner.nextLine();
                                    break;
                                }
                                case 2: {
                                    boolean bool2 = true;
                                    while (bool2) {
                                        System.out.println();
                                        System.out.println(purple + "1.Vizualizeaza toate operele");
                                        System.out.println(purple + "2.Vizualizare  opere dupa stil");
                                        System.out.println(purple + "3.Apreciaza opere ");
                                        System.out.println(purple + "4.Vezi numarul de aprecieri ");
                                        System.out.println("5.Inapoi la meniu.");
                                        System.out.println("Alege optiunea");
                                        int submeniu2 = scanner.nextInt();
                                        switch (submeniu2) {
                                            case 5: {
                                                bool2 = false;
                                                break;
                                            }
                                            case 1: {
                                                for (Map.Entry<Integer, Opera> op : opereS.entrySet()) {
                                                    System.out.println(op.getValue().getId() + " " + op.getValue().getTitlu() + " " + op.getValue().getStil() + " " + op.getValue().getAn() + " " + op.getValue().getPret());
                                                }
                                                System.out.println("Enter pentru a iesi");
                                                String iesire = scanner.nextLine();
                                                break;
                                            }
                                            case 2: {
                                                System.out.println("Alegeti Stilul operelor pe care odriti sa le vizualizati");
                                                System.out.println("Abstract/Contemporan/Hiperrealism/Futurist");
                                                stil = scanner.nextLine();
                                                for (Map.Entry<String, Opera> op : opereStil.entrySet()) {
                                                    System.out.println(op.getValue().getId() + " " + op.getValue().getTitlu() + " " + op.getValue().getStil() + " " + op.getValue().getAn() + " " + op.getValue().getPret());
                                                }
                                                System.out.println("Enter pentru a iesi");
                                                String iesire = scanner.nextLine();
                                                break;
                                            }
                                            case 3: {
                                                System.out.println("Adaugati nume si prenume");
                                                String user = scanner.nextLine();
                                                vizitatorServices.putOpereOnList(scanner, user);
                                                System.out.println("Enter pentru a iesi");
                                                String iesire = scanner.nextLine();
                                                break;
                                            }
                                            case 4: {
                                                System.out.println("Numarul de aprecieri a fiecarei opera este afisata mai jos: ");
                                                vizitatorServices.NumaraAprecieri(opereS);
                                                System.out.println("2*Enter pentru a iesi");
                                                String iesire = scanner.nextLine();
                                                String iesire2 = scanner.nextLine();
                                                break;
                                            }
                                        }
                                    }
                                }
                                case 3: {
                                    vizitatorServices.CereriCatreAdmin(scanner);
                                    System.out.println("Enter pentru a iesi");
                                    String iesire = scanner.nextLine();
                                    break;
                                }
                            }
                        }
                    }
                    case 1: {
                        System.out.println("Inregistrati-va ca si vizitator: ");
                        contService.register(contService.cont(scanner));
                        System.out.println("Enter pentru a iesi" + reset);
                        String iesire = scanner.nextLine();
                        break;
                    }
                }

            }
            if (r == 3) {
                System.out.println(cyan + " 1.Register " + reset);
                System.out.println(cyan + " 2.Login " + reset);
                System.out.print("Optiunea este: ");
                int o = scanner.nextInt();
                switch (o) {
                    default:{
                        System.out.println("Comanda introdusa nu exista");
                    }
                    case 0: {
                        System.out.println(cyan + "Sesiunea a fost abandonata");
                        System.exit(0);
                    }
                    case 1: {
                        System.out.println("Inregistrati-va ca si artist: ");
                        contService.register(contService.cont(scanner));
                        System.out.println("Enter pentru a iesi" + reset);
                        String iesire = scanner.nextLine();
                        break;
                    }
                    case 2: {
                        contService.Login(scanner, r);
                        boolean bool3 = true;
                        while (bool3) {
                            System.out.println();
                            System.out.println(cyan + "1.Adauga Opera");
                            System.out.println("2.Sterge Opera");
                            System.out.println("3.Modifica Pret");
                            System.out.println("4.Inapoi");
                            System.out.println("Alege optiunea");
                            int meniuA = scanner.nextInt();
                            switch (meniuA) {
                                case 1: {
                                    artistServices.addOpera(artistServices.operaB(scanner));
                                    opereS = artistServices.getAllOpere();
                                    System.out.println("Enter pentru a iesi");
                                    String iesire = scanner.nextLine();
                                    break;
                                }
                                case 2: {
                                    artistServices.deleteOpera(opereS, scanner);
                                    System.out.println(cyan + "Enter pentru a iesi");
                                    String iesire = scanner.nextLine();
                                    break;
                                }
                                case 3: {
                                    artistServices.updatePret(scanner, opereS);
                                    System.out.println(cyan + "Enter pentru a iesi" + reset);
                                    String iesire = scanner.nextLine();
                                    break;
                                }
                                case 4: {
                                    bool3 = false;
                                    break;
                                }
                                default:{
                                    System.out.println("Comanda introdusa nu exista");
                                }
                            }

                        }
                    }
                }
            }
            if (r == 1) {
                contService.Login(scanner, 1);
                boolean bool = true;
                while (bool) {
                    System.out.println();
                    System.out.println(green + "1.Creare Expozitie");
                    System.out.println(green + "2.Vezi Conturi");
                    System.out.println(green + "3.Vezi Expozitie");
                    System.out.println(green + "4.Realizare Cereri de la Vizitator");
                    System.out.println(green + "5.Iesire");
                    System.out.print("Optiunea este: ");
                    int o = scanner.nextInt();
                    switch (o) {
                        case 5: {
                            bool = false;
                            System.out.println(cyan + "Sesiunea a fost abandonata");
                            System.exit(0);
                        }
                        case 1: {
                            galerieExpozitieService.createExpozitie(galerieExpozitieService.expoGal(scanner, (Galerie) galerie));
                            opereS = artistServices.getAllOpere();
                            System.out.println("Enter pentru a iesi");
                            String iesire = scanner.nextLine();
                            break;
                        }
                        case 3: {
                            for (Map.Entry<Integer, Expozitie> expo : expoS.entrySet()) {
                                System.out.println(expo.getValue().getTitluExpozitie() + " " + expo.getValue().getDataInceput() + " " + expo.getValue().getDataSfarsit() + " " + expo.getValue().getTip());
                                System.out.println("Enter pentru a iesi");
                                String iesire = scanner.nextLine();
                                break;
                            }
                        }
                        case 2: {
                            for (Map.Entry<Integer, Cont> expo : contS.entrySet()) {
                                System.out.println(expo.getValue().getIdClient() + " " + expo.getValue().getNume() + " " + expo.getValue().getPrenume() + " " + expo.getValue().getEmail() + " " + expo.getValue().getTelefon() + " " + expo.getValue().getAdresa() + " " + expo.getValue().getParola());
                                System.out.println("Enter pentru a iesi");
                                String iesire = scanner.nextLine();
                                break;
                            }
                        }

                        case 4: {
                            boolean bool2 = true;
                            while (bool2) {
                                System.out.println();
                                System.out.println("1.Sterge cont vizitator");
                                System.out.println("2.Modifica email");
                                System.out.println("3.Modifica telefon");
                                System.out.println("4.Inapoi");
                                System.out.println("Alege optiunea");
                                int meniuA = scanner.nextInt();
                                switch (meniuA) {
                                    case 1: {
                                        contService.deleteCont(contS, scanner);
                                        System.out.println(green + "Enter pentru a iesi");
                                        String iesire = scanner.nextLine();
                                        break;
                                    }
                                    case  2:{
                                        contService.updateTelefon(contS, scanner);
                                        System.out.println(green + "Enter pentru a iesi" + reset);
                                        String iesire = scanner.nextLine();
                                        break;
                                    }
                                    case 3:{
                                        contService.changePassword(contS, scanner);
                                        System.out.println(green + "Enter pentru a iesi" + reset);
                                        String iesire = scanner.nextLine();
                                        break;
                                    }
                                    case 4:{
                                        bool2 = false;
                                        break;
                                    }
                                    default:{
                                        System.out.println("Comanda introdusa nu exista");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
