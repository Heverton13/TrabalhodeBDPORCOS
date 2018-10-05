
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConBanco {
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/sistemas_porcos";
    private String user = "postgres";
    private String password = "postgre";
    
    
    public Connection dbConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
        } catch (SQLException ex) {
            Logger.getLogger(ConBanco.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("not connected");
        }
        return connection;
    }
    
    public void inserIntoPorco(int id, String codigo){
        dbConnection();
        String query = "INSERT INTO porco(id, codigo) VALUES (?, ?);";
        
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, codigo);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public void deleteFromPorco(int id){
       
        dbConnection();
        String query = "Delete from porco WHERE ID = ? ;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   }
   
   public void readPorcos(){
       
        dbConnection();
        String query = "SELECT * FROM PORCO;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
        while (rs.next()){
            System.out.println(rs.getInt(1) + ": " + rs.getString(2));
        } 
            
        } catch (SQLException ex) {
            Logger.getLogger(ConBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   }
      
    
}
