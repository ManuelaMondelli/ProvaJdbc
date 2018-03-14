/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.manu.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author massimo.caputo
 */
public class Utils {
    
    private static Utils mainUtil;
    private final Properties prop;
    private static Connection conn;
    private static Statement stm;
    private static ResultSet rs;
    
    
  /**
   * 
   * @throws FileNotFoundException
   * @throws IOException
   * @throws ClassNotFoundException
   * @throws SQLException 
   */
    private Utils() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
         //Istanza del file di Properties
        prop = new Properties();
        //Load file di Properties
        InputStream is;
        is = new FileInputStream("DBConnection.properties");
        prop.load(is);

        //Carico Driver
        Class.forName(prop.getProperty("driver"));
        //Add alla connection le credenziali
        conn = DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("user"), prop.getProperty("pwd"));
        
    }
    
    
    /**
     * Il metodo consente di ottenere la connessione
     * @return Connection
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static synchronized Connection getConnetion() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException{        
        
        if( mainUtil == null){
            mainUtil = new Utils();            
        }   
        return conn;
    }

    
    /**
     * Il metodo chiude la connessione
     */
    public static synchronized void closeConnection(){
        if ( conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   public static synchronized void closeStatement(){
        if ( stm != null){
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static synchronized void closeRs(){
        if ( rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
