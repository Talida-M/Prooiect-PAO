package services;

import database.ArtistDB;
import database.ArtistOpereDB;
import database.OperaDB;
import models.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ArtistServices {
    private ArtistDB artistDB;
    Artist artist;
    private OperaDB operaDB;
    private ArtistOpereDB artistOpereDB;
    public ArtistServices(){
        this.operaDB = new OperaDB();
        this.artistDB = new ArtistDB();
        this.artistOpereDB = new ArtistOpereDB();

    }

    public void addOpera(Opera opera) throws SQLException {
//        System.out.println("Adaugati o opera pentru a fi expusa:");
        operaDB.addOpera(opera);
//        ArtistOpere artistOpere = new ArtistOpere(artist.getIdArt(), opera.getId());
//        artistOpereDB.addArtistOpera(artistOpere);
    }
    public void addArtistOpera(int id, int idA) throws SQLException {
        ArtistOpere artistOpere = new ArtistOpere(idA, id);
        artistOpereDB.addArtistOpera(artistOpere);
    }

    public void deleteOpera(Map<Integer, Opera> opere, Scanner scanner, String email) {
        for (Map.Entry<Integer, Opera> o : operaDB.getAllOpere().entrySet()) {
            System.out.println( o.getValue().getId() + " " + o.getValue().getTitlu() + ", " + o.getValue().getPret());
                }

        System.out.println("Alegeti id-ul operei pe care doriti sa o eliminati din galerie");
        int id = scanner.nextInt();
        Opera opera = opere.get(id);
        System.out.println("Sunteti sigur ca doriti sa stergeti aceasta opera? da/nu");
        String r = scanner.next();
        if (r.equals("da")) {
            operaDB.deleteOpera(opera);
            System.out.println("Opera nu mai face parte din galeria noastra");
        } else {
            System.out.println("Opera NU a fost eliminata din galerie");
        }

    }
    public void updatePret(Scanner scanner, Map<Integer, Opera> opere) throws SQLException {
        for (Map.Entry<Integer, Opera> o : operaDB.getAllOpere().entrySet()){
                System.out.println(o.getValue().getId() + " " + o.getValue().getTitlu() + ", " + o.getValue().getPret());


        }
        System.out.println("Id-ul operei care necesita update de pret");
        String id = scanner.nextLine();
        System.out.println("Noul pret.");
        Double numar = scanner.nextDouble();
        Opera opera = opere.get(Integer.parseInt(id));
        operaDB.updatePret(opera, numar);
        System.out.println("Pret modificat cu succes");
    }

    public Map<Integer, Opera> getAllOpere() {
        return operaDB.getAllOpere();
    }
    public Map<Integer, ArtistOpere> getAllAO() {
        return artistOpereDB.getAllOpereByArtists();
    }
    public Map<String, Opera> getAllOpereByStil(String stil) {
        return operaDB.getAllOpereByStil( stil);
    }
    public Map<Integer, Artist> getArtisti() {
        return artistDB.getAllArtists();

    }

    public Opera operaB(Scanner scanner) {
        System.out.println("Completeaza cu: titlu/an/stil/pret");
        String titlu = scanner.next();
        String an = scanner.next();
        String stil = scanner.next();
        Double pret = scanner.nextDouble();
        return new Opera(titlu, an,stil, pret);
    }
    public Artist artist(Scanner scanner, Cont cont) {
        System.out.println("Adaugati descriere");
        String line = scanner.nextLine();
        return new Artist(cont.getNume(), cont.getPrenume(), cont.getZiNastere(), cont.getEmail(), cont.getTelefon(), cont.getAdresa(), cont.getParola(),line );
    }



}
