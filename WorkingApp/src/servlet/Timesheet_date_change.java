 package servlet;
 import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Timesheet;
import beans.Userdata;
import logic.Time_logic;
import logic.Timesheet_logic;

 @WebServlet({"/timesheet_date_change"})
 public class Timesheet_date_change extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request, response);
    }






    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
       Userdata session_data = (Userdata)session.getAttribute("LOGIN_INFO");
       new Userdata();
       new ArrayList();
       Timesheet_logic logic = new Timesheet_logic();
       Time_logic time_logic = new Time_logic();
       if (session_data != null) {
         ArrayList<Timesheet> timesheets = logic.table(session_data.getEmp_no());
         if (timesheets != null) {
        	 int year = Integer.parseInt(request.getParameter("year"));
        	 int month = Integer.parseInt(request.getParameter("month"));
        	 int maxday = time_logic.getActualMaximum(year,month);
        	 session.setAttribute("timesheets", timesheets);//勤怠情報出力
        	 session.setAttribute("year", year);
        	 session.setAttribute("month", month);
        	 session.setAttribute("maxday", maxday);
        	 response.sendRedirect("Timesheet");
          }
       } else {
          response.sendRedirect("Login");
       }
    }
 }
