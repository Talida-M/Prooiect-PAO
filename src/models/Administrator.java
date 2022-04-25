package models;

public class Administrator {
    private String nume, prenume;
    private String cheieAcces;

    public Administrator(String nume, String prenume, String cheieAcces) {
        this.nume = nume;
        this.prenume = prenume;
        this.cheieAcces = cheieAcces;
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
                ", cheieAcces='" + cheieAcces + '\'' +
                '}';
    }
}
