package models.BazaDeDate;

import models.Artist;
import models.Cont;
import models.Factory.ContFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistBD {
    java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect_pao", "root", "ParolaMySQL16");

    public ArtistBD() throws SQLException {
    }


    public List<Artist> read(){
        List<Artist> artisti = new ArrayList<>();
        try{
            Statement statement;
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Cont");
            while(result.next()) {
                Artist current =  new Artist(result);
                artisti.add(current);
            }
            statement.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return artisti;
    }

    public void create(Artist artist){
        try{
            String query = "INSERT INTO Cont (nume, prenume,telefon, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, artist.getNume());
            preparedStmt.setString(2, artist.getPrenume());
            preparedStmt.setString(3, artist.getTelefon());
            preparedStmt.setString(4, artist.getEmail());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void deleteDupaId(Cont cont){
        try{

            String query = "DELETE FROM Cont WHERE nume = ? and prenume=?";
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
