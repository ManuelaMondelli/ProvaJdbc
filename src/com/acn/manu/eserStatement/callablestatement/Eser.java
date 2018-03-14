package com.acn.manu.eserStatement.callablestatement;

import com.acn.manu.utils.Utils;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuela.mondelli
 */
public class Eser {

    private Connection connection;
    private CallableStatement cls;
    private String regionName;
    private static final String sql = "{call GET_REGION_NAME (?,?)}";

    public String country(int idRegion){
        try {
            connection = Utils.getConnetion();
            cls = connection.prepareCall(sql);
            cls.setInt(1, idRegion);
            cls.registerOutParameter(2, java.sql.Types.VARCHAR);
            
            cls.executeUpdate();
            regionName = cls.getString(2);

           System.out.println(" REGION NAME " + regionName);

        } catch (SQLException ex) {
            Logger.getLogger(Eser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Eser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Eser.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                cls.close();
            } catch (SQLException ex) {
                Logger.getLogger(Eser.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Eser.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return regionName;
    }
}
