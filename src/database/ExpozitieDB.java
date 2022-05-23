package database;

import config.Database;
import models.Adresa;
import models.Expozitie;
import models.Galerie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExpozitieDB {
    public void addExpozitie(Expozitie expozitie) throws SQLException {
        String query = "insert into expozitie values (null,?,?,?,?)";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setString(1, expozitie.getTitluExpozitie());
            statement.setString(2, expozitie.getTip());
            statement.setString(3, expozitie.getDataInceput());
            statement.setString(4, expozitie.getDataSfarsit());
            //statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public void updateData(Expozitie expozitie, String dataInceput, String dataSfarsit) throws SQLException {
        String query = "update `expozitie` set `dataInceput` = ? and `dataSfarsit` = ? where `idGal` = ?;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setString(1, dataInceput);
            statement.setString(2, dataSfarsit);
            statement.setInt(3, expozitie.getIdE());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteExpozitie(Expozitie expozitie) {
        String query = "delete from `expozitie` where `idE` = ?;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setInt(1, expozitie.getIdE());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Expozitie> getAllExpozitii(Map<Integer, Galerie> galerii) {
        Map<Integer, Expozitie>  expozitii = new HashMap<>();
        String query = "select * from expozitie";
        try{
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Expozitie expozitie = new Expozitie();
                Integer idE = resultSet.getInt(1);
                expozitie.setIdE(idE);
                expozitie.setTitluExpozitie(resultSet.getString(2));
                expozitie.setTip(resultSet.getString(3));
                expozitie.setDataInceput(resultSet.getString(4));
                expozitie.setDataSfarsit(resultSet.getString(5));
                expozitii.put(idE, expozitie);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return expozitii;
    }

}
