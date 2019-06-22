/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author esyeha
 */
class koneksi_ {

    String userDb ="pko";
    String pswdDb ="pk0_2013";
    String urlDb ="jdbc:mysql://192.168.0.251:3306/simulasi";
    
    public com.mysql.jdbc.Connection getConnection(){
        com.mysql.jdbc.Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection(urlDb,userDb,pswdDb);
        } catch (Exception ex){
            ex.printStackTrace();
            
        }
        return con;
    }
    
}
