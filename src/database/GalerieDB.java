package database;

import config.Database;
import models.Galerie;
import models.Opera;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GalerieDB {
    public void addGalerie(Galerie galerie) throws SQLException {
        String query = "insert into galerie values (null,?,? )";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setInt(1, galerie.getIdGal());
            statement.setString(2, galerie.getNume());
            statement.setString(3, galerie.getLocatie());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void updateNume(Galerie galerie, String nume) throws SQLException {
        String query = "update `galerie` set `nume` = ? where `idGal` = ?;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setString(1, nume);
            statement.setInt(2, galerie.getIdGal());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteGalerie(Galerie galerie) {
        String query = "delete from `galerie` where `idGal` = ?;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setInt(1, galerie.getIdGal());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Galerie> getGalerie() {
        Map<Integer, Galerie> galerii = new HashMap<>();
        String query = "select * from galerie";
        try{
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Galerie galerie = new Galerie();
                Integer idGal = resultSet.getInt(1);
                galerie.setIdGal(idGal);
                galerie.setNume(resultSet.getString(2));
                galerie.setLocatie(resultSet.getString(3));

                galerii.put(idGal, galerie);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return galerii;
    }
    public Galerie getGalerie1() {
        String query = "select * from galerie";
        Galerie galerie = new Galerie();
        try{
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                galerie.setIdGal(resultSet.getInt(1));
                galerie.setNume(resultSet.getString(2));
                galerie.setLocatie(resultSet.getString(3));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return galerie;
    }

//    public void getGalerieByOras(String oras,  Map<Integer, Galerie> galerie) {
//        String query = "select * from `galerie` where `oras` = ?;";
//        try{
//            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
//            preparedStatement.setString(1, oras);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Galerie galerie1 = new Galerie();
//                Integer id = resultSet.getInt(1);
//
//                //restaurant.setId(id);
//                galerie1.setLocatie(locatii.get(resultSet.getInt(2)));
//
//                System.out.println(galerie);
//            }
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
