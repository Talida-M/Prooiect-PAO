package services;
import models.Administrator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Audit {
    FileWriter writer;

    public Audit() {
        try {
            File dir = new File("src/files");
            File file1 = new File("src/files/opere.csv");
            File file2 = new File("src/files/listaActiuni.csv");
            File file3 = new File("src/files/cereri.csv");
            File file4 = new File("src/files/admini.csv");
            this.writer = new FileWriter("src/files/opere.csv",true);
            this.writer = new FileWriter("src/files/listaActiuni.csv",true);
            this.writer = new FileWriter("src/files/cereri.csv",true);
            this.writer = new FileWriter("src/files/admini.csv",true);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public void addAction1(String action) throws IOException {
        this.writer = new FileWriter("src/files/opere.csv",true);
        long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        this.writer.write((action + ','+ timestamp + '\n'));
        this.writer.close();
    }
    public void addAction2(String action1, String action2) throws IOException {
        this.writer = new FileWriter("src/files/listaActiuni.csv",true);
        long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        this.writer.write((action1 + ',' + action2 + timestamp + '\n'));
        this.writer.close();
    }
    public void addAction3(String action) throws IOException {
        this.writer = new FileWriter("src/files/cereri.csv",true);
        long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        this.writer.write((action + ','+ timestamp + '\n'));
        this.writer.close();
    }
    public void addAction4(String action) throws IOException {
        this.writer = new FileWriter("src/files/admini.csv",true);
        long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        this.writer.write((action + ','+ timestamp + '\n'));
        this.writer.close();
    }
}
