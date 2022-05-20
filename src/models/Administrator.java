package models;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public final class Administrator {
    private String nume, prenume;


    public Administrator(String nume, String prenume) throws IOException {
        this.nume = nume;
        this.prenume = prenume;

    }

    public Administrator(Scanner in) {
        System.out.println("Nume: ");
        this.nume = in.nextLine();
        System.out.println("Prenume: ");
        this.prenume = in.nextLine();

    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }
}
