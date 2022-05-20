package models.BazaDeDate;

import com.sun.jdi.connect.spi.Connection;
import models.Factory.OpereFactory;
import models.Opera;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperaBD {
    java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect_pao", "root", "ParolaMySQL16");

    OpereFactory opereFact = new OpereFactory();
    public OperaBD() throws SQLException {
    }


    public List<Opera> read(){
        List<Opera> opere = new ArrayList<>();
        try{
            Statement statement;
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Opera");
            while(result.next()) {
                Opera current =  opereFact.createOpera(result);//new Opera(result);
                opere.add(current);
            }
            statement.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return opere;
    }

    public void create(Opera opera){
        try{
            String query = "INSERT INTO Opera (id, titlu, an, stil) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, opera.getTitlu());
            preparedStmt.setInt(2, opera.getId());
            preparedStmt.setString(3, opera.getAn());
            preparedStmt.setString(4, opera.getStil());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void deleteDupaId(Opera opera){
        try{

            String query = "DELETE FROM Opera WHERE id = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, opera.getId());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
