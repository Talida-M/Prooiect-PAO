package services;
import models.Adresa;
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
    private List<Cont> client = new ArrayList<Cont>();

    public List<Cont> getClient() {
        return client;
    }

    public void setClient(List<Cont> client) {
        this.client = client;
    }

    private static List<String[]> ColoaneCSV(String fileName){
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
            var coloane= ColoaneCSV("clienti.csv");
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

    public void login (){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduceti email:");
        String email = s.nextLine();
        var coloane= ColoaneCSV("clienti.csv");
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
