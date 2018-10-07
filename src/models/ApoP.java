/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Aluno
 */
public class ApoP {
    
    public static void main(String[] args) {
        
       
        ConBanco co  = new ConBanco();
         /*
        co.inserIntoBaia(2, 15.5, "N");
        co.inserIntoBaia(1, 20.6, "S");
        co.inserIntoBaia(3, 40.6, "N");
        
        co.inserIntoPorco(1, "Rabico", "0/01/2000", "10/01/2001");
        */
        
        
        co.inserirPorcoNaBaia(1,1, 1);
        //co.deleteFromPorcoDaBaia(1);
        co.readPorcos();
        co.readBaias();
        co.readPorcoNaBaia();
        
    }
    
}
