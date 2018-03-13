package Example;

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
public class Example {
    
    static final String JDBC= "OracleJDBC - ojdbc6.jar";   
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    static final String DRIVER = "oracle.jdbc.OracleDriver";
    
    static final String USER = "hr"; 
    static final String PASS = "oracle";
 
    
public static void main(String[] args)  { 
    
    Connection conn = null; 
    Statement stmt = null;
     ResultSet rs = null;
    try{ 
      //STEP 2: Register JDBC driver 
      System.out.println("Register JDBC driver"); 
      Class.forName(DRIVER); 
 
      //STEP 3: Open a connection 
      System.out.println("Connecting to database..."); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS); 
 
      //STEP 4: Execute a query 
      System.out.println("Creating statement..."); 
      stmt = conn.createStatement(); 
      String sql; 
      sql = "SELECT FIRST_NAME, LAST_NAME, EMAIL from EMPLOYEES"; 
        rs = stmt.executeQuery(sql); 
      //STEP 5: Extract data from result set 
      while(rs.next()){ 
         //Retrieve by column name 
         String nome  = rs.getString("FIRST_NAME"); 
         String lname  = rs.getString("LAST_NAME"); 
         String email  = rs.getString("EMAIL"); 
         //Display values 
         System.out.print("FIRST_NAME: " + nome); 
         System.out.print(", LAST_NAME: " + lname); 
         System.out.print(", EMAIL: " + email); 
         System.out.println();
      } 
      //STEP 6: Clean-up environment 
      
      rs.close();
    }catch (ClassNotFoundException ex) {
            Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex) {
            Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
         if( rs != null){
             try {
                 rs.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         if(conn != null){
             try {
                 conn.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
    }
}
}
