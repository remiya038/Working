package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Userdata;
import logic.Timesheet_logic;
import setting.Logic_setting;



@WebServlet({"/Home"})
public class Home extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request, response);
   }





   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      Userdata session_data = (Userdata)session.getAttribute("LOGIN_INFO");
      Boolean start,end,mode = null;
      Timesheet_logic logic = new Timesheet_logic();
      Logic_setting setting = new Logic_setting();
      //モードのチェック false:通常モード　true:テストモード---------------

      //モードのチェック終わり--------------------------------------------------

      if (session_data == null) {
         response.sendRedirect("Login");
      } else {


    	//出勤と退勤が可能か判定
    	 start = logic.start_check(session_data.getEmp_no());
    	 end = logic.end_check(session_data.getEmp_no());

    	 request.setAttribute("start", start);
    	 request.setAttribute("end", end);
         request.setAttribute("name", session_data.getName());
         ServletContext context = this.getServletContext();
         RequestDispatcher dispatch = context.getRequestDispatcher("/TOP.jsp");
         dispatch.forward(request, response);
      }
   }
}
