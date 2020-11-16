package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import beans.Userdata;





public class Dao  {

	ResourceBundle rb = ResourceBundle.getBundle("main");


    String url = rb.getString("URL");
    String id =rb.getString("ID");
    String pass = rb.getString("PASS");


   public Userdata select_emp(int emp_no){
      Connection conn = null;
      Userdata data = null;

      PreparedStatement stat = null;
      ResultSet rset = null;



      try {
    	 Class.forName("org.postgresql.Driver");
         conn = DriverManager.getConnection(this.url, this.id, this.pass);

         String sql = "SELECT * FROM emp_table  WHERE emp_no = ?";
         stat = conn.prepareStatement(sql);
         stat.setInt(1, emp_no);
         rset = stat.executeQuery();
         if (rset.next()) {
            data = new Userdata();
            data.setEmp_no(rset.getInt("emp_no"));
            data.setPass(rset.getString("pass"));
            data.setName(rset.getString("name"));
         }
      } catch (SQLException | ClassNotFoundException var23) {
         var23.printStackTrace();



      } finally {
         if (stat != null) {
            try {
               stat.close();
            } catch (SQLException var22) {
               var22.printStackTrace();
            }         }

         if (rset != null) {
            try {
               rset.close();
            } catch (SQLException var21) {
               var21.printStackTrace();
            }         }

         if (conn != null) {
            try {
               conn.close();
            } catch (SQLException var20) {
               var20.printStackTrace();
            }         }
      }

      return data;
   }
}