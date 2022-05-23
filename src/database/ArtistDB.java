package database;

import config.Database;
import models.Adresa;
import models.Artist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

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
                Integer id = resultSet.getInt(1);
                artist.setIdClient(id);
                artist.setNume(resultSet.getString(2));
                artist.setPrenume(resultSet.getString(3));
                artist.setZiNastere(resultSet.getString(4));
                artist.setEmail(resultSet.getString(5));
                artist.setTelefon(resultSet.getString(6));
//                artist.setAdresa(locatii.get(resultSet.getInt(7)));
                artist.setParola(resultSet.getString(8));
                Integer idA = resultSet.getInt(9);
                artist.setDescriere(resultSet.getString(10));
                map.put(id, artist);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
