
package com.acn.manu.eserStatement.statement;

import com.acn.manu.dto.DTOEmployee;
import com.acn.manu.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuela
 */
public class Update {
    
    private Connection connection;
    private Statement stmt;
    private ResultSet rs;
    private DTOEmployee dtoSingle;
    private int row;
    
    static final String sql="UPDATE EMPLOYEES SET FIRST_NAME='James' WHERE EMPLOYEE_ID=211";
    
    public int aggiorna() throws SQLException{
        try{
            connection=Utils.getConnetion();
            stmt=connection.createStatement();
            row=stmt.executeUpdate(sql);
            
            System.out.println("Sono state aggiornate " +row+" righe");
            
            
        } catch (IOException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stmt.close();
            connection.close();
        }
        return row;
    }
    
}
