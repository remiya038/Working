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

 @WebServlet({"/timesheet_output"})
 public class Timesheet_output extends HttpServlet {
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
        	 session.setAttribute("timesheets", timesheets);//勤怠情報出力
        	 //今の日付時刻の情報をセット
        	 session.setAttribute("year", time_logic.getYear());
        	 session.setAttribute("month", time_logic.getMonth());
        	 session.setAttribute("maxday", time_logic.getActualMaximum( time_logic.getYear(),time_logic.getMonth()));
        	 response.sendRedirect("Timesheet");
          }
       } else {
          response.sendRedirect("Login");
       }
    }
 }
