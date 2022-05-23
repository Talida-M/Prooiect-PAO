package services;

import database.ArtistDB;
import database.ArtistOpereDB;
import database.OperaDB;
import models.Adresa;
import models.Artist;
import models.ArtistOpere;
import models.Opera;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ArtistServices {
    private ArtistDB artistDB;
    Artist artist;
    private OperaDB operaDB;
    private ArtistOpereDB artistOpereDB;
    public ArtistServices(){}

    public void addOpera(Opera opera) throws SQLException {
        System.out.println("Adaugati o opera pentru a fi expusa:");
        operaDB.addOpera(opera);
        ArtistOpere artistOpere = new ArtistOpere(artist.getIdArt(), opera.getId());
        artistOpereDB.addArtistOpera(artistOpere);

    }

    public void deleteOpera(Map<Integer, Opera> opere, Scanner scanner) {
        List<Integer> lista = artistOpereDB.getOperaByArtist(artist.getIdArt());
        for (int l : lista) {
            for (Map.Entry<Integer, Opera> o : operaDB.getAllOpereById(l).entrySet()) {
                System.out.println(o.getKey() + "." + o.getValue().getId() + " " + o.getValue().getTitlu() + ", " + o.getValue().getPret());
            }
        }
            System.out.println("Alegeti id-ul operei pe care doriti sa o eliminati din galerie");
        String id = scanner.nextLine();
        Opera opera = opere.get(Integer.parseInt(id));
        System.out.println("Sunteti sigur ca doriti sa stergeti aceasta opera? da/nu");
        String r = scanner.nextLine();
        if (r.equals("da")) {
            operaDB.deleteOpera(opera);
            System.out.println("Opera nu mai face parte din galeria noastra");
        } else {
            System.out.println("Opera NU a fost eliminata din galerie");
        }

    }
    public void updatePret(Scanner scanner, Map<Integer, Opera> opere) throws SQLException {
        List<Integer> lista = artistOpereDB.getOperaByArtist(artist.getIdArt());
        for (int l : lista){
            for (Map.Entry<Integer, Opera> o : operaDB.getAllOpereById(l).entrySet()){
                System.out.println(o.getKey() + "." + o.getValue().getId() + " " + o.getValue().getTitlu() + ", " + o.getValue().getPret());
            }

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
        System.out.println("Scrie: titlu,an,stil,pret");
        String line = scanner.nextLine();
        String[] op = line.split(",");
        return new Opera(op[0], op[2],op[3], Integer.parseInt(op[3]));
    }

}
