package models.BazaDeDate;

import models.Factory.ContFactory;
import models.Cont;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContBD {
    java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect_pao", "root", "ParolaMySQL16");

    ContFactory contFact = new ContFactory();
    public ContBD() throws SQLException {
    }


    public List<Cont> read(){
        List<Cont> conturi = new ArrayList<>();
        try{
            Statement statement;
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Cont");
            while(result.next()) {
                Cont current =  contFact.createCont(result);//new Cont(result);
                conturi.add(current);
            }
            statement.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return conturi;
    }

    public void create(Cont cont){
        try{
            String query = "INSERT INTO Cont (idClient,nume, prenume, ziNastere, email, telefon, adresa, parola) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, cont.getNume());
            preparedStmt.setString(2, cont.getPrenume());
            preparedStmt.setDate(3, (Date) cont.getZiNastere());
            preparedStmt.setString(4, cont.getEmail());
            preparedStmt.setString(5, cont.getTelefon());
            preparedStmt.setString(6, cont.getAdresa().getStrada());
            preparedStmt.setString(7, cont.getAdresa().getTara());
            preparedStmt.setString(8, cont.getAdresa().getOras());
            preparedStmt.setInt(9, cont.getAdresa().getCodPostal());
            preparedStmt.setString(10, cont.getParola());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void deleteDupaId(Cont cont){
        try{

            String query = "DELETE FROM Cont WHERE id = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, cont.getIdClient());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void deleteDupaMail(Cont cont){
        try{

            String query = "DELETE FROM Cont WHERE email = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, cont.getEmail());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
