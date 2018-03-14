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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuela.mondelli
 */
public class DaoLogin {
    

    private Connection connection;
    private PreparedStatement pstm;
    private boolean result = false;
    
    private static String sql_login = " select email from EMPLOYEES where email = ?";
    
    /**
     * 
     * @param email
     * @return 
     */
    public boolean checkLogin(String email){
        System.out.println("INIZIO checkLogin");
         try{
            connection = Utils.getConnetion();
            pstm = connection.prepareStatement(sql_login);
            pstm.setString(1, email);
            ResultSet rs = pstm.executeQuery();
            if (rs.next() ) {
                result = true;
            }
            
                     
         }catch (IOException ex) {
            Logger.getLogger(DaoLista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoLista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoLista.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                pstm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         System.out.println("result: " + result);
         System.out.println("FINE checkLogin");
         return result;
    }
}
