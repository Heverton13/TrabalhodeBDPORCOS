
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
    private String url = "jdbc:postgresql://localhost:5433/sistemas_porcos"; // 5432 usar esse na escola CVT
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
            System.out.println("Porco - ID:" + rs.getInt(1) + " - " + rs.getString(2)+ " Data de Nascimento: " + rs.getString(3));
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
            System.out.println("Baia - ID: " + rs.getInt(1) + " Tamanho: " + rs.getString(2) + " Baia Limpa: " + rs.getString(3));
        } 
            
        } catch (SQLException ex) {
            Logger.getLogger(ConBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
   //FAZER CÓDIGOS AQUI PARA PORCO BAIA IGUAL OS DE CIMA!
   
    public void inserirPorcoNaBaia(int id,int id_porco, int id_baia){
        dbConnection();
        String query = "INSERT INTO porco_na_baia(id, id_porco, id_baia) VALUES (?,?, ?);";
        
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1,id);
            pst.setInt(2, id_porco);
            pst.setDouble(3, id_baia);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteFromPorcoDaBaia(int id){
       
        dbConnection();
        String query = "Delete from porco_na_baia WHERE ID = ? ;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   }
    
    public void readPorcoNaBaia(){
       
        dbConnection();
        String query = "SELECT * FROM porco_na_baia;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
        while (rs.next()){
            System.out.println("Porcos: " + rs.getInt(2) + " Baia: " + rs.getInt(3));
        } 
            
        } catch (SQLException ex) {
            Logger.getLogger(ConBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
}
