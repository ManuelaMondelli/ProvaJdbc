/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.manu.eserStatement.preparestatement;

import com.acn.manu.dto.DTOEmployee;
import com.acn.manu.eserStatement.Dto;
import com.acn.manu.eserStatement.statement.Retrieve;
import com.acn.manu.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuela
 */
public class RetrievePS {
    
    private static Connection connection;
    private static PreparedStatement pstm;
    private static ResultSet rs;
    
    private Dto dto;
  
    
    static final String sql="SELECT FIRST_NAME, LAST_NAME, EMAIL FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
    
    //Il metodo stampa il ResultSet contenente nome, cognome e email dell'impiegato
    //L'impiegato è cercato attraverso ID
     public Dto findID(int idE) throws SQLException{
         int res = 0;
        try{
            connection=Utils.getConnetion();
            pstm=connection.prepareStatement(sql);
            pstm.setString(1, String.valueOf(idE));
            rs=pstm.executeQuery();
            dto = new Dto();
            while(rs.next()){
                dto.setFirstName(rs.getString("FIRST_NAME"));
                dto.setLastName(rs.getString("LAST_NAME"));
                dto.setEmail(rs.getString("EMAIL")); 
                dto.setResultSql(1);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            pstm.close();
            rs.close();
            connection.close();
        }
        return dto;
    }
}
