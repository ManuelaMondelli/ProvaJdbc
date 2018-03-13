/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.manu.eserStatement.preparestatement;

import com.acn.manu.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuela
 */
public class DeletePS {
    
    private Connection connection;
    private PreparedStatement pst;
    private int row=0;
    
    private final static String sql="DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
    
    public int deleted(int idE){
        try{
            connection=Utils.getConnetion();
            pst=connection.prepareStatement(sql);
            
            pst.setInt(1, idE);
            
            row=pst.executeUpdate();
            
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DeletePS.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                pst.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DeletePS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return row;
    }
    
}
