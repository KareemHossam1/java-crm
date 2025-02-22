/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Austin Wong
 */
public class DBConnection {
    
    //<editor-fold desc="variables">
    
    // JDBC URL parts
    private static final String protocol = "jdbc";
    private static final String vendorName = ":mysql:";
    private static final String ipAddress = "//localhost:3306/meters_crm";
    
    // JDBC URL
    private static final String jdbcURL = protocol + vendorName + ipAddress;
    
    // Driver and Connection Interface Reference
    private static final String MYSQLJDBCDriver = "com.mysql.cj.jdbc.Driver";
    private static Connection conn = null;
    
    // Username and Password
    private static final String username = "root";
    private static final String password = "Password@MySQL1";
    
    //</editor-fold>
    
    public static Connection startConnection(){
        
        try{
            Class.forName(MYSQLJDBCDriver);
            conn = (Connection) DriverManager.getConnection(jdbcURL, username, password);
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            Logger.getLogger("errorlog.txt").log(Level.SEVERE,null,e);
        }
        
        return conn;
        
    }
    
    public static Connection getConnection(){
        return conn;
    }
    
    public static void closeConnection(){
        
        try{
            conn.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
}
