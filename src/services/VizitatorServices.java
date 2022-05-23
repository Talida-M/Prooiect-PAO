package services;

import database.ContDB;
import models.Cont;
import models.Opera;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VizitatorServices {
    private Audit audit;
    private ContDB contDB;
    public VizitatorServices(){
        this.contDB = new ContDB();
        this.audit = new Audit();
    }

    public void putOpereOnList(Scanner scanner, String user) throws IOException {
        System.out.println("Apreciati opera: Titlu Opera/Artist");
        String apreciere = scanner.next();
        System.out.println("Opera " + apreciere + " a fost apreciata");
        audit.addAction2(apreciere, user);
    }

    public  void CereriCatreAdmin(Scanner scanner) throws IOException {
        System.out.println("In cazul in care doriti sa va schimbati parola sau sa faceti un update numarului de telefon lasati un mesaj aici. Administratorul site-ului se va ocupa de asta.");
        System.out.println("Pentru schimbarea parolei/numarului de telefon va rog sa specificati noua parola/numar");
        System.out.println("De asemenea daca doriti stergerea contului, acest lucru este posibil");
        String mesaj = scanner.next();
        audit.addAction3(mesaj);
    }
public void NumaraAprecieri(Map<Integer, Opera> opere) throws FileNotFoundException {
    File file = new File("src/files/listaActiuni.csv");
    Map<String, Integer> aprecieri = new HashMap<>();
    Scanner scanner = new Scanner(file);
    for (Map.Entry<Integer, Opera> c : opere.entrySet()){
        int counter = 0;
        while (scanner.hasNext()){
            String[] input = scanner.nextLine().split(",");
            if (input[0].equals(c.getValue().getTitlu())){
                counter +=1;
            }
        }
        System.out.println(c.getValue().getTitlu() + " " + counter);
        aprecieri.put(c.getValue().getTitlu(), counter);
    }

}
}
