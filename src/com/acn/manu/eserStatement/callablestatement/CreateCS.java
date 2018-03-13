
package com.acn.manu.eserStatement.callablestatement;

import com.acn.manu.utils.Utils;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author manuela.mondelli
 */
public class CreateCS {
    
    private Connection connection;
    private CallableStatement cls;
    private int row;
    
    private static final String sql="{call add_job_history(?,?,?,?,?)}";
    
    /**
     * 
     * @param idE
     * @param sd
     * @param ed
     * @param idJob
     * @param idDepartment
     * @return 
     */
    public int create(int idE, String sd, String ed, int idJob, int idDepartment){
        
        try{
            connection=Utils.getConnetion();
            System.out.println("INIZIO CHIAMATA ALL PROCEDURA");
            cls=connection.prepareCall(sql);
            System.out.println("Setting parameter: ");            
            System.out.println("[ID_EMP]: "+ idE+ "[S_DATE]: " +sd+ " [E_DATE]: "+ed+ " [J_ID]: "+idJob+ " [D_ID]: "+idDepartment);            
                     
            cls.setInt(1,idE);
            cls.setString(1,sd);
            cls.setString(1,ed);
            cls.setInt(1,idJob);
            cls.setInt(1,idDepartment);
            System.out.println("FINE CHIAMATA ALL PROCEDURA");
            
       } catch (IOException ex) {
            Logger.getLogger(CreateCS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateCS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreateCS.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                cls.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CreateCS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return row;    
    }
}
