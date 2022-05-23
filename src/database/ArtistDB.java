package database;

import config.Database;
import models.Adresa;
import models.Artist;
import models.ArtistOpere;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ArtistDB {
    public void addArtist(Artist artist) {
        String query = "insert into artist values (?,?,?,?,?,?,?,null,?);";
        try(PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setString(1, artist.getNume());
            statement.setString(2, artist.getPrenume());
            statement.setString(3, artist.getZiNastere());
            statement.setString(4, artist.getEmail());
            statement.setString(5, artist.getTelefon());
            statement.setString(6, artist.getParola());
            statement.setInt(6, artist.getIdArt());
            statement.setString(8, String.valueOf(artist.getDescriere()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateTelefon(Artist artist, String telefon) {
        String query = "update `artist` set `telefon` = ? where `idClient` = ?;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setString(1, telefon);
            statement.setInt(2, artist.getIdClient());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateDescriere(Artist artist, String descriere) {
        String query = "update `artist` set `descriere` = ? where `idArt` = ?;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setString(1, descriere);
            statement.setInt(2, artist.getIdArt());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteArtist(Artist artist) {
        String query = "delete from `artist` where `idArt` = ?;";
        try(PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setDouble(1, artist.getIdArt());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Artist> getAllArtists() {
        Map map = new HashMap<Integer, Artist>();
        String query = "select * from artist;";
        try{
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setNume(resultSet.getString(1));
                artist.setPrenume(resultSet.getString(2));
                artist.setZiNastere(resultSet.getString(3));
                artist.setEmail(resultSet.getString(4));
                artist.setTelefon(resultSet.getString(5));
                artist.setAdresa(resultSet.getString(6));
                artist.setParola(resultSet.getString(7));
                Integer idA = resultSet.getInt(8);
                artist.setIdArt(idA);
                artist.setDescriere(resultSet.getString(9));
                map.put(idA, artist);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

}
