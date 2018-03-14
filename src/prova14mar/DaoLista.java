package prova14mar;

import com.acn.manu.dto.DTOEmployee;
import com.acn.manu.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuela.mondelli
 */
public class DaoLista {

    private Connection connection;
    private Statement stm;
    private ResultSet rs;

    static final String SQL = "SELECT * FROM EMPLOYEES";

    public DaoLista() {
    }

    public List<Dto> lista() {
        List<Dto> lista = new ArrayList<>();
        try {
            connection = Utils.getConnetion();
            stm = connection.createStatement();
            rs = stm.executeQuery(SQL);

            //iL dto DI APPOGGIO MI SERVE PER RECUPERARE I SINGOLI RECORD ESTRATTI DALLA QUERY
            // E LETTI ATTRAVERSO IL RESULT SET
            Dto dtoEmpApp;
            while (rs.next()) {
                dtoEmpApp = new Dto();

                dtoEmpApp.setFirstName(rs.getString("FIRST_NAME"));
                dtoEmpApp.setLastName(rs.getString("LAST_NAME"));
                dtoEmpApp.setEmail(rs.getString("EMAIL"));
                dtoEmpApp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                dtoEmpApp.setHireDate(rs.getString("HIRE_DATE"));
                dtoEmpApp.setJobId(rs.getString("JOB_ID"));
                dtoEmpApp.setSalary(rs.getDouble(String.valueOf("SALARY")));
                dtoEmpApp.setCommissionPct(rs.getDouble(String.valueOf("COMMISSION_PCT")));
                dtoEmpApp.setManagerId(rs.getInt("MANAGER_ID"));
                dtoEmpApp.setDepartmentId(rs.getInt("DEPARTMENT_ID"));

                lista.add(dtoEmpApp);
            }
        } catch (IOException ex) {
            Logger.getLogger(DaoLista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoLista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoLista.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}
