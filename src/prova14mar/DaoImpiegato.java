package prova14mar;

import com.acn.manu.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuela.mondelli
 */
public class DaoImpiegato {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    Dto dto;
    private static final String sql = "SELECT FIRST_NAME, LAST_NAME, MANAGER_ID, DEPARTMENT_ID FROM EMPLOYEES WHERE EMPLOYEE_ID=?";

    public Dto impiegato(int idE) {
        try {
            dto=new Dto();
            connection = Utils.getConnetion();
            pst = connection.prepareStatement(sql);

            pst.setInt(1, idE);
            rs = pst.executeQuery();
            
            while(rs.next()){
            dto.setFirstName(rs.getString("FIRST_NAME"));
            dto.setLastName(rs.getString("LAST_NAME"));
            dto.setLastName(rs.getString("MANAGER_ID"));
            dto.setLastName(rs.getString("DEPARTMENT_ID"));
            }
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoImpiegato.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoImpiegato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return dto;
    }
}
