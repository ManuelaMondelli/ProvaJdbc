package com.acn.manu.eserStatement.preparestatement;

import com.acn.manu.dto.DTOEmployee;
import com.acn.manu.eserStatement.Dto;
import com.acn.manu.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuela
 */
public class CreatePS {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    private Dto dto;

    private static final String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID)"
                                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public Dto created(int idE, String name, String surname, String email, String phone, String data, String idJob, double salary, double commission, int idManager, int idDepartment) {
        try {
            connection = Utils.getConnetion();
            pst = connection.prepareStatement(sql);
           
            pst.setInt(1, idE);
            pst.setString(2, name);
            pst.setString(3, surname);
            pst.setString(4, email);
            pst.setString(5, phone);
            pst.setString(6, data);
            pst.setString(7, idJob);
            pst.setDouble(8, salary);
            pst.setDouble(9, commission);
            pst.setInt(10, idManager);
            pst.setInt(11, idDepartment);
            
            pst.executeQuery();
            
            /*
            Dto dto = new Dto();
            
            while (rs.next()) {
                dto.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
                dto.setFirstName(rs.getString("FIRST_NAME"));
                dto.setLastName(rs.getString("LAST_NAME"));
                dto.setEmail(rs.getString("EMAIL"));
                dto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                dto.setHireDate(rs.getString("HIRE_DATE"));
                dto.setJobId(rs.getString("JOB_ID"));
                dto.setSalary(rs.getDouble(String.valueOf("SALARY")));
                dto.setCommissionPct(rs.getDouble(String.valueOf("COMMISSION_PCT")));
                dto.setManagerId(rs.getInt("MANAGER_ID"));
                dto.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
            }
               */
        } catch (IOException ex) {
            Logger.getLogger(CreatePS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreatePS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreatePS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CreatePS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dto;
    }

    public void created(Dto emp) {
        try {
            connection = Utils.getConnetion();
            pst = connection.prepareStatement(sql);
           
            pst.setInt(1, emp.getEmployeeId());
            pst.setString(2, emp.getFirstName());
            pst.setString(3, emp.getLastName());
            pst.setString(4, emp.getEmail());
            pst.setString(5, emp.getPhoneNumber());
            pst.setString(6, emp.getHireDate());
            pst.setString(7, emp.getJobId());
            pst.setDouble(8, emp.getSalary());
            pst.setDouble(9, emp.getCommissionPct());
            pst.setInt(10, emp.getManagerId());
            pst.setInt(11, emp.getDepartmentId());
            
            pst.executeQuery();
            
            /*
            Dto dto = new Dto();
            
            while (rs.next()) {
                dto.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
                dto.setFirstName(rs.getString("FIRST_NAME"));
                dto.setLastName(rs.getString("LAST_NAME"));
                dto.setEmail(rs.getString("EMAIL"));
                dto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                dto.setHireDate(rs.getString("HIRE_DATE"));
                dto.setJobId(rs.getString("JOB_ID"));
                dto.setSalary(rs.getDouble(String.valueOf("SALARY")));
                dto.setCommissionPct(rs.getDouble(String.valueOf("COMMISSION_PCT")));
                dto.setManagerId(rs.getInt("MANAGER_ID"));
                dto.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
            }
               */
        } catch (IOException ex) {
            Logger.getLogger(CreatePS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreatePS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreatePS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CreatePS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
