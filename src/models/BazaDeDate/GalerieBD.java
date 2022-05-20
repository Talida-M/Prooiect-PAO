package models.BazaDeDate;

import models.Cont;
import models.Factory.GalerieFactory;
import models.Galerie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GalerieBD {
    java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect_pao", "root", "ParolaMySQL16");

    GalerieFactory galF = new GalerieFactory();
    public GalerieBD() throws SQLException {
    }


    public List<Galerie> read(){
        List<Galerie> gal = new ArrayList<>();
        try{
            Statement statement;
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Cont");
            while(result.next()) {
                Galerie current =  galF.createGalerie(result);//new Cont(result);
                gal.add(current);
            }
            statement.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return gal;
    }

    public void create(Galerie cont){
        try{
            String query = "INSERT INTO Galerie (idGal,nume, locatie, opere) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, cont.getNume());
            preparedStmt.setString(2, cont.getLocatie().getStrada());
            preparedStmt.setString(3, cont.getLocatie().getTara());
            preparedStmt.setString(4, cont.getLocatie().getOras());
            preparedStmt.setInt(5, cont.getLocatie().getCodPostal());
            preparedStmt.setObject(5, cont.getOpere());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void deleteDupaId(Galerie cont){
        try{

            String query = "DELETE FROM Galerie WHERE idGal = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, cont.getIdGal());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }


}
