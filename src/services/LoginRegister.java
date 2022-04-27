package services;
import models.Adresa;
import models.Client;
import models.Cont;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class LoginRegister {
    private List<Cont> conturi = new ArrayList<>();

    public LoginRegister() { }

    public List<Cont> getConturi() {
        return conturi;
    }

    public LoginRegister(List<Cont> conturi, List<Cont> client) {
        this.conturi = conturi;
        this.client = client;
    }

    public void setConturi(List<Cont> conturi) {
        this.conturi = conturi;
    }

    private static LoginRegister singleton = null;
    private List<Cont> client = new ArrayList<Cont>();

    public void setClient(List<Cont> client) {
        this.client = client;
    }
    public List<Cont> getClient() {
        return client;
    }



    public static LoginRegister getInstance()
    {
        if (singleton == null)
            singleton = new LoginRegister();
        return singleton;
    }
    private static List<String[]> coloaneCSV(String fileName){
        List<String[]> coloane = new ArrayList<>();
        try(var in = new BufferedReader(new FileReader(fileName))) {

            String l;

            while((l = in.readLine()) != null ) {
                String[] fields = l.replaceAll(" ", "").split(",");
                coloane.add(fields);
            }
        } catch (IOException e) {
            System.out.println("Nu avem niciun client!");
        }

        return coloane;

    }

    public void luamCSV() {
        try{
            var coloane= LoginRegister.coloaneCSV("clienti.csv");
            for(var fields : coloane){
                var newCont = new Cont(
                        fields[0],
                        fields[1],
                        new SimpleDateFormat("yyyy-MM-dd").parse(fields[2]),
                        fields[3],
                        fields[4],
                        new Adresa(fields[5], fields[6],Integer.parseInt(fields[7]),fields[8]),
                        fields[9]
                );
                client.add(newCont);
            }
        }catch (ParseException e){
            System.out.println(e.toString());
        }

    }
    public void toCSV(){
        try{
            var writer = new FileWriter("clienti.csv");
            for(var c : this.client){
                writer.write(c.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
    private Cont inputPentruCont(Scanner in) throws Exception{
        if (this.conturi.size() == 0)
            throw new Exception("Nu avem clienti inregistrati");
        return conturi.get(0);

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
        Scanner s = new Scanner(System.in);
        System.out.println("Introduceti email:");
        String email = s.nextLine();
        var coloane= coloaneCSV("clienti.csv");
        for (var fields : coloane){
            if (fields[4] == email) {
                System.out.println("Introduceti parola:");
                String parola = s.nextLine();
                if (fields[9] == parola)
                    System.out.println("Bun venit " + fields[0] + fields[1]);
                else {
                    System.out.println("Parola Incorecta");
                    System.out.println("Introduceti din nou parola:");
                    String parola2 = s.nextLine();
                }
                break;
            }
            else {
                System.out.println("Email incorect. Daca nu aveti inca cont, inregistrati-va!");

            }
        }


    }
}
