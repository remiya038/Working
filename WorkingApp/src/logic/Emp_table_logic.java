 package logic;

 import beans.Userdata;
import dao.Dao;


 public class Emp_table_logic {
    public Userdata login(int emp_no) {
       Dao dao = new Dao();
       Userdata data = dao.select_emp(emp_no);
       return data;
    }
 }
