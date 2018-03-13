package com.acn.manu.eserStatement.statement;

import com.acn.manu.eserStatement.Dto;
import com.acn.manu.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuela
 */
public class Create {

    private Connection connection;
    private Statement stm;
    private ResultSet rs;
    private Dto dto;
    private boolean result;
    
    private static final String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID) " +
                                      "VALUES (211, 'Manuela', 'Mondelli', 'mmondelli', '3397199499', '19-FEB-18', 'FI_MGR', 400, 0, 100, 10)";
    
    /**
     * Il metodo crea un record sul DB
     * @return il numero di record inseriti
     */
    public void create() {

        try {
            connection = Utils.getConnetion();
            stm = connection.createStatement();
            stm.execute(sql);
            
            /*while(rs.next()){
                dto.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
                dto.setFirstName(rs.getString("FIRST_NAME"));
                dto.setLastName(rs.getString("LAST_NAME"));
                dto.setEmail(rs.getString("EMAIL"));
                dto.setPhoneNumber(rs.getString("phone"));
                dto.setHireDate(rs.getString("data"));
                dto.setJobId(rs.getString("idJob"));
                dto.setSalary(rs.getDouble(String.valueOf("salary")));
                dto.setCommissionPct(rs.getDouble(String.valueOf("commission")));
                dto.setManagerId(rs.getInt("idManager"));
                dto.setDepartmentId(rs.getInt("idDepartment"));
            }*/
            
        } catch (SQLException ex) {
            Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Utils.closeConnection();
        }
          
    }

}
