
package com.acn.manu.eserStatement.preparestatement;

import com.acn.manu.eserStatement.Dto;
import com.acn.manu.utils.Utils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuela
 */
public class UpdatePS {

    private Connection connection;
    private PreparedStatement pstm;
    private ResultSet rs;
    private Dto dto;
    
    static final String sql = "UPDATE EMPLOYEES SET COMMISSION_PCT= 0.3 WHERE EMPLOYEE_ID=?";

    public boolean update(int idE) throws IOException {
        boolean esito = true;
        try {
            
            connection = Utils.getConnetion();
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, idE);
            pstm.executeUpdate();
            
            /*Dto dto=new Dto();
            while(rs.next()){
                dto.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
                dto.setFirstName(rs.getString("FIRST_NAME"));
                dto.setLastName(rs.getString("LAST_NAME"));
                dto.setSalary(rs.getDouble("SALARY"));
                dto.setCommissionPct(rs.getDouble("COMMISSION_PCT"));
            }*/
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UpdatePS.class.getName()).log(Level.SEVERE, null, ex);
            esito = false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdatePS.class.getName()).log(Level.SEVERE, null, ex);
            esito = false;
        } catch (SQLException ex) {
            Logger.getLogger(UpdatePS.class.getName()).log(Level.SEVERE, null, ex);
            esito = false;
        } finally {
            try {
                pstm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UpdatePS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return esito;
    }
}
          