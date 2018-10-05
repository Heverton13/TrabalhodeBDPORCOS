
package models;

import java.sql.Connection;
import java.sql.Date;
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
    
    public void inserIntoPorco(int id, String nome, String data_nasc, String data_aqui){
        dbConnection();
        String query = "INSERT INTO porco(id, nome, data_nasc,data_aqui) VALUES (?, ?, ?,?);";
        
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, nome);
            pst.setString(3, data_nasc);
            pst.setString(4, data_aqui);
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
            System.out.println(rs.getInt(1) + " - " + rs.getString(2)+ " Data de Nascimento: " + rs.getString(3));
        } 
            
        } catch (SQLException ex) {
            Logger.getLogger(ConBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   }
   
    //Partes para a criação da baia
   
    public void inserIntoBaia(int id, double tamanho, String ind){
        dbConnection();
        String query = "INSERT INTO baia(id, tamanho,indicador_limpeza) VALUES (?, ?, ?);";
        
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            pst.setDouble(2, tamanho);
            pst.setString(3, ind);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteFromBaia(int id){
       
        dbConnection();
        String query = "Delete from baia WHERE ID = ? ;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   }
    
    public void readBaias(){
       
        dbConnection();
        String query = "SELECT * FROM baia;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
        while (rs.next()){
            System.out.println("Identificação: " + rs.getInt(1) + " Tamanho: " + rs.getString(2) + " Baia Limpa: " + rs.getString(3));
        } 
            
        } catch (SQLException ex) {
            Logger.getLogger(ConBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
   //FAZER CÓDIGOS AQUI PARA PORCO BAIA IGUAL OS DE CIMA!
   
    
}
