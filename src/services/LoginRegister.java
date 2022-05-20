package services;
import models.Administrator;
import models.Adresa;
import models.Client;
import models.Cont;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class LoginRegister {
    private List<Cont> conturi = new ArrayList<>();
//    private static LoginRegister singleton = null;
    private List<Cont> client = new ArrayList<>();
    private List<Administrator> admini = new ArrayList<>();
    public List<Administrator> getAdmin() {
        return admini;
    }

    public void setAdmin(List<Administrator> admini) {
        this.admini = admini;
    }

    public LoginRegister() { }

    public List<Cont> getConturi() {
        return conturi;
    }

    public LoginRegister(List<Cont> conturi, List<Cont> client, List<Administrator> admini) {
        this.conturi = conturi;
        this.client = client;
        this.admini = admini;
    }

    public void setConturi(List<Cont> conturi) {
        this.conturi = conturi;
    }



    public void setClient(List<Cont> client) {
        this.client = client;
    }
    public List<Cont> getClient() {
        return client;
    }



//    public static LoginRegister getInstance()
//    {
//        if (singleton == null)
//            singleton = new LoginRegister();
//        return singleton;
//    }
//    private static List<String[]> coloaneCSV(String fileName){
//        List<String[]> coloane = new ArrayList<>();
//        try(var in = new BufferedReader(new FileReader(fileName))) {
//
//            String l;
//
//            while((l = in.readLine()) != null ) {
//                String[] fields = l.replaceAll(" ", "").split(",");
//                coloane.add(fields);
//            }
//        } catch (IOException e) {
//            System.out.println("Nu avem niciun client!");
//        }
//
//        return coloane;
//
//    }
//
//    public void luamCSV() {
//        try{
//            var coloane= LoginRegister.coloaneCSV("clienti.csv");
//            for(var fields : coloane){
//                var newCont = new Cont(
//                        fields[0],
//                        fields[1],
//                        new SimpleDateFormat("yyyy-MM-dd").parse(fields[2]),
//                        fields[3],
//                        fields[4],
//                        new Adresa(fields[5], fields[6],fields[7],Integer.parseInt(fields[8])),
//                        fields[9]
//                );
//                client.add(newCont);
//            }
//        }catch (ParseException e){
//            System.out.println(e.toString());
//        }
//
//    }
//    public void toCSV(){
//        try{
//            var writer = new FileWriter("clienti.csv");
//            for(var c : this.client){
//                writer.write(c.toCSV());
//                writer.write("\n");
//            }
//            writer.close();
//        }catch (IOException e){
//            System.out.println(e.toString());
//        }
//    }
    private Cont inputPentruCont(Scanner in) throws Exception{
        if (this.client.size() == 0)
            throw new Exception("Nu avem clienti inregistrati");
        return client.get(0);

    }
    public void inregistreazaClient(Scanner in) throws ParseException {
        Cont nouCont =  new Cont(in);
        this.conturi.add(nouCont);
        System.out.println("Ati fost  inregistrat ca nou client");
    }
    public void getCont(Scanner in) throws Exception{
        var cont = this.inputPentruCont(in);
        System.out.println(cont.toString());
    }
    public void login (){
        int b = 1;
        int counter = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Introduceti email:");
        String email = s.nextLine();
        for (var fields : this.conturi){
//            System.out.println(fields.getEmail());
            if (email.equals(fields.getEmail())) {
                counter = 1;
                System.out.println("Introduceti parola:");
                String parola = s.nextLine();
                    if ( parola.equals(fields.getParola()))
                        System.out.println("Bun venit " + fields.getNume() + " " + fields.getPrenume());

                    else {
                        while (b == 1){
                        System.out.println("Parola Incorecta");
                        System.out.println("Introduceti din nou parola:");
                        parola = s.nextLine();
                        if ( parola.equals(fields.getParola())) {
                            System.out.println("Bun venit " + fields.getNume() + fields.getPrenume());
                            b = 0;
                            }
                    }
                }
                break;
            }
          if (counter == 0) {
                System.out.println("Email incorect. Daca nu aveti inca cont, inregistrati-va!");

            }
        }


    }
    public void loginAdministrator(Scanner in) throws IOException {
        Scanner s = new Scanner(System.in);
        Administrator admin =  new Administrator(in);
        System.out.println("Introduceti cheie acces:");
        String cheie = s.nextLine();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("D:\\Proiecte\\Prooiect-PAO\\src\\models\\Cheie.txt"));;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String content = scanner.useDelimiter("\n").next();
        scanner.close();
        if (cheie.equals(content)){
            this.admini.add(admin);
            System.out.println("Bun venit " + admin.getNume() + " " + admin.getPrenume());
        }
    }


}
