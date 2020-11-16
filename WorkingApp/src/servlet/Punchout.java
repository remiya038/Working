package servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Timesheet;
import beans.Userdata;
import logic.Timesheet_logic;



@WebServlet({"/punchout"})
public class Punchout extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.sendRedirect("Home");
   }






   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      HttpSession session = request.getSession();
	      Userdata session_data = (Userdata)session.getAttribute("LOGIN_INFO");
	      Boolean end =null;
	      new Userdata();
	      new Timesheet();
	      Timesheet_logic logic = new Timesheet_logic();
	      if (session_data == null) {
	    	  response.sendRedirect("Login");//LOGIN_INFOがない場合はログイン画面へ
	      } else {
	    		 int numRow = logic.punchout(session_data.getEmp_no());
	    		 if (numRow !=0l) {
	    			 //session.setAttribute("timesheet", timesheet);
	    			 session.setAttribute("attendance", "punchout");
	    			 response.sendRedirect("Complete");

	         }
	      }

	   }
	}


