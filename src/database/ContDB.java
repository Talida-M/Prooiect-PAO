package database;

import config.Database;
import models.Adresa;
import models.Cont;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ContDB {
    public void addCont(Cont cont) throws SQLException {
        String query = "insert into cont values (null,?,?,?,?,?,? )";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setString(1, cont.getNume());
            statement.setString(2, cont.getPrenume());
            statement.setString(3, cont.getZiNastere());
            statement.setString(4, cont.getEmail());
            statement.setString(5, cont.getTelefon());
            statement.setString(5, cont.getAdresa());
            statement.setString(6, cont.getParola());
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        Adresa adresa = cont.getAdresa();
//        query = query + adresa.getOras() + ", ";


    }

    public void updateEmail(Cont cont, String email) throws SQLException {
        String query = "update `cont` set `email` = ? where `idClient` = ?;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setString(1, email);
            statement.setInt(2, cont.getIdClient());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePassword(Cont cont, String parola) throws SQLException {
        String query = "update `cont` set `parola` = ? where `idClient` = ?;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setString(1, parola);
            statement.setInt(2, cont.getIdClient());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateTelefon(Cont cont, String telefon) throws SQLException {
        String query = "update `cont` set `telefon` = ? where `idClient` = ?;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setString(1, telefon);
            statement.setInt(2, cont.getIdClient());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteCont(Cont cont) {
        String query = "delete from `cont` where `idClient` = ?;";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(query)) {
            statement.setInt(1, cont.getIdClient());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Cont> getAllConturi() {
        Map<Integer, Cont> conturi = new HashMap<Integer, Cont>();
        String query = "select * from cont";
        try{
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cont cont = new Cont();
                Integer idClient = resultSet.getInt(1);
                cont.setIdClient(idClient);
                cont.setNume(resultSet.getString(2));
                cont.setPrenume(resultSet.getString(3));
                cont.setZiNastere(resultSet.getString(4));
                cont.setEmail(resultSet.getString(5));
                cont.setTelefon(resultSet.getString(6));
                cont.setAdresa(resultSet.getString(7));
                cont.setParola(resultSet.getString(8));
//                cont.setAdresa(locatii.get(resultSet.getInt(8)));

                conturi.put(idClient, cont);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return conturi;
    }

    public void getContById(int idClient) {
        String query = "select * from `cont` where `oras` = ?;";
        try{
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, idClient);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cont cont = new Cont();
                Integer id = resultSet.getInt(1);

                //restaurant.setId(id);
                cont.setNume(resultSet.getString(2));
                cont.setPrenume(resultSet.getString(3));
                cont.setZiNastere(resultSet.getString(4));
                cont.setEmail(resultSet.getString(5));
                cont.setTelefon(resultSet.getString(6));
                cont.setAdresa(resultSet.getString(7));
                cont.setParola(resultSet.getString(8));
//                cont.setAdresa(adresa.get(resultSet.getInt(8)));

                System.out.println(cont);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getNameById(int idClient) {
        String query = "select nume || ' ' || prenume from `cont` where `idClient` = ?;";
        try{
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, idClient);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cont cont = new Cont();
                cont.setNume(resultSet.getString(1));
                cont.setPrenume(resultSet.getString(2));

                System.out.println(cont);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
    public String getEmail(String  email) {
        String query = "select email from `cont` where `email` = ?;";
        try{
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cont cont = new Cont();
                cont.setEmail(resultSet.getString(1));
                System.out.println(cont);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
    public String getParola(String  email) {
        String query = "select parola from `cont` where `email` = ?;";
        try{
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cont cont = new Cont();
                cont.setParola(resultSet.getString(2));
                System.out.println(cont);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
}
