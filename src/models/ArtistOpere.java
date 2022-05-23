package models;

public class ArtistOpere {
    public int id;
    public int idArt;
    public int idO;


    public ArtistOpere() {
    }

    public ArtistOpere(int idArt, int idO) {
        this.idArt = idArt;
        this.idO = idO;
    }

    public ArtistOpere(int id, int idArt, int idO) {
        this.id = id;
        this.idArt = idArt;
        this.idO = idO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdArt() {
        return idArt;
    }

    public void setIdArt(int idArt) {
        this.idArt = idArt;
    }

    public int getIdO() {
        return idO;
    }

    public void setIdO(int idO) {
        this.idO = idO;
    }

    @Override
    public String toString() {
        return "ArtistOpere{" +
                "id=" + id +
                ", idArt=" + idArt +
                ", idO=" + idO +
                '}';
    }
}
