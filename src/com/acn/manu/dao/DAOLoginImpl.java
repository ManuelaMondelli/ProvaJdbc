/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.manu.dao;

import com.acn.manu.dto.DTOEmployee;
import com.acn.manu.dto.DTOLogin;
import com.acn.manu.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOLoginImpl {

    Utils utils;
    DTOEmployee dtoEmp;
    static final String sql = "SELECT FIRST_NAME, LAST_NAME, EMAIL from EMPLOYEES";

    //Questa classe è quella che effettivamente esegue le query sul DB
    //Generalmente il risultaato viene inserito in un DTO
    public DTOEmployee retriveCredentials() {

        try {
            Connection conn = Utils.getConnetion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs != null) {
                
                dtoEmp = new DTOEmployee();
                //STEP 5: Extract data from result set 
                while (rs.next()) {
                    //Retrieve by column name 
                    dtoEmp.setFirstName(rs.getString("FIRST_NAME"));
                    dtoEmp.setLastName(rs.getString("LAST_NAME"));
                    dtoEmp.setEmail(rs.getString("EMAIL"));
                    //Display values 
                    System.out.print("FIRST_NAME: " + dtoEmp.getFirstName());
                    System.out.print(", LAST_NAME: " + dtoEmp.getLastName());
                    System.out.print(", EMAIL: " + dtoEmp.getEmail());
                    System.out.println();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOLoginImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) { 
            Logger.getLogger(DAOLoginImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOLoginImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtoEmp;
    }

}
