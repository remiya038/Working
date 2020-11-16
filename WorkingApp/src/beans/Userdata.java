 package beans;

 import java.io.Serializable;

 public class Userdata implements Serializable {
    private int emp_no;
    private String pass;
    private String name;

    public int getEmp_no() {
       return this.emp_no;
    }
    public void setEmp_no(int emp_no) {
      this.emp_no = emp_no;
    }
    public String getPass() {
       return this.pass;
    }
    public void setPass(String pass) {
       this.pass = pass;
    }
    public String getName() {
       return this.name;
    }
    public void setName(String name) {
       this.name = name;
    }
 }
