package database;
import config.Database;
import models.Opera;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class OperaDB {
    public void addOpera(Opera opera) throws SQLException {
        String query = "insert into opera values (null,?,?,? )";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setString(1, opera.getTitlu());
            statement.setString(2, opera.getAn());
            statement.setString(3, opera.getStil());
            statement.setDouble(4, opera.getPret());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTitlu(Opera opera, String titlu) throws SQLException {
        String query = "update `opera` set `titlu` = ? where `id` = ?;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setString(1, titlu);
            statement.setInt(2, opera.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePret(Opera opera, double pret) throws SQLException {
        String query = "update `opera` set `pret` = ? where `id` = ?;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setDouble(1, pret);
            statement.setInt(2, opera.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOpera(Opera opera) {
        String query = "delete from `opera` where `id` = ?;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setInt(1, opera.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Opera> getAllOpere() {
        Map<Integer, Opera> map = new HashMap<Integer, Opera>();
        String query = "select * from opera";
        try{
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Opera opera = new Opera();
                Integer id = resultSet.getInt(1);
                opera.setId(id);
                opera.setTitlu(resultSet.getString(2));
                opera.setAn(resultSet.getString(3));
                opera.setStil(resultSet.getString(4));
                opera.setPret(resultSet.getDouble(5));
                map.put(id, opera);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public Map<Integer, Opera> getAllOpereById(Integer id) {
        Map<Integer, Opera> map = new HashMap<Integer, Opera>();
        String query = "select * from opera where id = ?;";
        try{
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Opera opera = new Opera();
                Integer idO = resultSet.getInt(1);
                opera.setId(id);
                opera.setTitlu(resultSet.getString(2));
                opera.setAn(resultSet.getString(3));
                opera.setStil(resultSet.getString(4));
                opera.setPret(resultSet.getDouble(5));
                map.put(id, opera);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public Map<String, Opera> getAllOpereByStil(String stil) {
        Map<String, Opera> map = new HashMap<String, Opera>();
        String query = "select * from opera where stil = ?;";
        try{
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            preparedStatement.setString(1, stil);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Opera opera = new Opera();
                opera.setTitlu(resultSet.getString(2));
                opera.setAn(resultSet.getString(3));
                opera.setStil(resultSet.getString(4));
                opera.setPret(resultSet.getDouble(5));
                map.put(stil, opera);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}