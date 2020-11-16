package logic;

import beans.Userdata;
import dao.Dao;

public class LoginLogic {
	public String sevret;
	public String comment;
	public LoginLogic login(String emp_str,String pass) {
	       Dao dao = new Dao();
	       //返り値用にクラスをインスタンス化
	       LoginLogic rtn = new LoginLogic();
	       if (this.checkEmpStr(emp_str) == 0) {
	           int emp_no = Integer.parseInt(emp_str);
	           Userdata userdata = dao.select_emp(emp_no);
	           	if (userdata != null) {
	           		if (pass.equals(userdata.getPass())) {
	           			rtn.sevret = "Home";
	           		} else {
	           			rtn.comment = "パスが違います";
	           			rtn.sevret = "Login";
	           		}
	          } else {
	        	  rtn.comment = "社員番号が見つかりませんます";
	        	  rtn.sevret = "Login";
	          }
	       } else {
	           if (this.checkEmpStr(emp_str) == 1) {
	        	   rtn.comment =  "社員番号が数値ではありません";
	        	   rtn.sevret = "Login";
	          }
	           if (this.checkEmpStr(emp_str) == 2) {
	        	   rtn.comment = "入力がありません";
	        	   rtn.sevret = "Login";
	          }
	       }
	      // Userdata data = dao.select_emp(emp_no);
	       return rtn;
	    }


	private int checkEmpStr(String emp_str) {
	      byte n;
	       if (!this.checkNull(emp_str)) {
	          if (!this.checkNumber(emp_str)) {
	             n = 0;
	         } else {
	             n = 1;
	         }
	      } else {
	          n = 2;
	      }
	       return n;
	   }


	   private boolean checkNull(String emp_str) {
	       return emp_str.isEmpty();
	   }


	   private boolean checkNumber(String emp_str) {
	      try {
	          Integer.parseInt(emp_str);
	          return false;
	       } catch (NumberFormatException var3) {
	          return true;
	      }
	   }

}
