
package com.acn.manu.eserStatement.statement;

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
public class Delete {
    
    private Connection connection;
    private Statement stm;
    private boolean result;
    private ResultSet rs;
    private int row;
    
    private static final String sql="DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID=211";
    
    public int deleteRecord(){
        try{
            connection=Utils.getConnetion();
            stm=connection.createStatement();
            row=stm.executeUpdate(sql);
            
            /*while(rs.first()){
                result=true;
            }*/
            
            System.out.println("L'aggiornamento è stato effettuato " +row);
            
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
        return row;
        
    }
}
