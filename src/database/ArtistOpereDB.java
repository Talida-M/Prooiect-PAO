package database;

import config.Database;
import models.ArtistOpere;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArtistOpereDB {
    public void addArtistOpera(ArtistOpere artistOpere) throws SQLException {
        String query = "insert into artistOpere values (null,?,? )";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setInt(1, artistOpere.getIdArt());
            statement.setInt(2, artistOpere.getIdO());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteArtistOpera(ArtistOpere opera) {
        String query = "delete from `artistOpere` where `id` = ?;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setInt(1, opera.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, ArtistOpere> getAllOpereByArtists() {
        Map<Integer, ArtistOpere> map = new HashMap<Integer, ArtistOpere>();
        String query = "select * from artistOpere";
        try{
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ArtistOpere artistOpere = new ArtistOpere();
                Integer id = resultSet.getInt(1);
                artistOpere.setId(id);
                artistOpere.setIdArt(resultSet.getInt(2));
                artistOpere.setIdO(resultSet.getInt(3));
                map.put(id, artistOpere);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void getOpereByArtist(Integer idA) {
        String query = "select * from `artistOpere` where `idArt` = ?;";
        try {
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, idA);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ArtistOpere artistOpere = new ArtistOpere();
                Integer id = resultSet.getInt(1);
                artistOpere.setIdArt(resultSet.getInt(2));
                artistOpere.setIdO(resultSet.getInt(3));
                //restaurant.setId(id);
                System.out.println(artistOpere);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Integer> getOperaByArtist(Integer idA) {
        List<Integer> lista = new ArrayList<>();
        String query = "select idO from `artistOpere` where `idArt` = ?;";
        try {
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, idA);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ArtistOpere artistOpere = new ArtistOpere();
                artistOpere.setIdO(resultSet.getInt(3));
                //restaurant.setId(id);
                lista.add(artistOpere.getIdO());
                System.out.println(artistOpere);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
