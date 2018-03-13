/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.manu.dao;

import com.acn.manu.dto.NewDto;
import com.acn.manu.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuela
 */
public class NewDao {
    
    NewDto dtoR = new NewDto();
    static final String sql="select e.FIRST_NAME, e.LAST_NAME from login l, employees e " +
                            "  where l.employee_id = e.employee_id and l.USERNAME = ? and l.PASSWORD = ?";
    private boolean resultQuery = false;
    
    
    
    public NewDto retrieve(NewDto dtoLogin) throws SQLException{
        try{
        Connection connection=Utils.getConnetion();
        PreparedStatement pst =connection.prepareStatement(sql);
        pst.setString(1,dtoLogin.getUsername() );
        pst.setString(2,dtoLogin.getPassword() );
        ResultSet result=pst.executeQuery();
        
        
        while(result.next()){
           dtoR.setFirstName(result.getString("FIRST_NAME"));
           dtoR.setLastName(result.getString("LAST_NAME"));
           dtoR.setExist("true");
           System.out.println("FIRST_NAME " +dtoR.getFirstName());
           System.out.println("LAST_NAME" +dtoR.getLastName());
        }
        }catch (SQLException ex) {
            Logger.getLogger(DAOLoginImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) { 
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtoR;
    }
    
}
