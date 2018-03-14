/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova14mar;

import com.acn.manu.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuela.mondelli
 */
public class DaoAnagrafica {

    private Connection connection;
    private PreparedStatement pstm;
    private ResultSet rs;
    Dto dto;

    private final static String sql = "SELECT FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE EMPLOYEE_ID=?";

    public DaoAnagrafica() {
         dto=new Dto();        
    }
    
    

    public Dto anagrafica(int idE) {
        try {
            connection = Utils.getConnetion();
            pstm = connection.prepareStatement(sql);

            pstm.setInt(1, idE);
            rs=pstm.executeQuery();
            
            while(rs.next()){
                dto.setFirstName(rs.getString("FIRST_NAME"));
                dto.setLastName(rs.getString("LAST_NAME"));
            }
        } catch (IOException ex) {
            Logger.getLogger(DaoAnagrafica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoAnagrafica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoAnagrafica.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                pstm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoAnagrafica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dto;
    }
}
