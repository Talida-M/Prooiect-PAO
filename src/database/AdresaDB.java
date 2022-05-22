package database;

import config.Database;
import models.Adresa;
import models.Opera;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AdresaDB {
    public void addAdresa(Adresa adresa) throws SQLException {
        String query = "insert into adresa values (null,?,?,?,? )";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setString(1, adresa.getStrada());
            statement.setString(2, adresa.getTara());
            statement.setString(3, adresa.getOras());
            statement.setInt(4, adresa.getCodPostal());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAdresa(Adresa adresa) {
        String query = "delete from `adresa` where `idLoc` = ?;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setInt(1, adresa.getIdLoc());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Adresa> getAllAdrese() {
        Map<Integer, Adresa> map = new HashMap<Integer, Adresa>();
        String query = "select * from adresa";
        try{
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Adresa adresa = new Adresa();
                Integer id = resultSet.getInt(1);
                adresa.setIdLoc(id);
                adresa.setStrada(resultSet.getString(2));
                adresa.setTara(resultSet.getString(3));
                adresa.setOras(resultSet.getString(4));
                adresa.setCodPostal(resultSet.getInt(5));
                map.put(id, adresa);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
