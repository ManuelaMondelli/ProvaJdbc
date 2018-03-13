/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.manu.eserStatement.statement;

import com.acn.manu.dto.DTOEmployee;
import com.acn.manu.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuela
 */
public class Retrieve {
    
    private Connection connection;
    private Statement stm;
    private ResultSet rs;
    
    static final String sql="SELECT * FROM EMPLOYEES";
    private List<DTOEmployee> listEmployee;
    private DTOEmployee dtoSingle;
    
    public Retrieve() {
        listEmployee = new ArrayList<>();
    }
    
    
    
    
    //Il metodo stampa un ResultSet con il risultato della query
    //La query cerca tutti gli impiegati del database
    public List<DTOEmployee> findAll(){
        try{
            connection=Utils.getConnetion();
            stm=connection.createStatement();
            rs=stm.executeQuery(sql);
            //Inizio a scorrere il ResultSet
            ResultSetMetaData rsmd = rs.getMetaData();
            
            for (int i = 1 ;  i <= rsmd.getColumnCount() ; i++){
                System.out.print(rsmd.getColumnName(i));
                System.out.print("\t");
                
            }
            System.out.println("");
            while( rs.next()){
                 for (int p = 1 ;  p <= rsmd.getColumnCount() ; p++){
                    System.out.print(rs.getString(rsmd.getColumnName(p)));
                    System.out.print("\t");
                 }
               System.out.println("");
            }
             while( rs.next()){
                 dtoSingle = new DTOEmployee();                 
                 //Cominio a leggere il risultato del record i-esimo
                 //Riempio il DTO i-esimo
                 dtoSingle.setFirstName( rs.getString("FIRST_NAME") );
                 dtoSingle.setLastName( rs.getString("LAST_NAME") );
                 dtoSingle.setEmail( rs.getString("EMAIL") );
                 //Dopo essermi costruito il singolo DTO, lo carico nella lista
                 //La lista conterrà tanti DTO di Employee quanti sono i record preenti nel ResultSet
                 listEmployee.add(dtoSingle);
                
             }
            
        } catch (IOException ex) {
            Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            Utils.closeConnection();
        }
        return listEmployee;
    }

}
