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
import setting.Logic_setting;



 @WebServlet({"/Login"})
 public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request, response);

    }






    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
       Logic_setting setting = new Logic_setting();
       Userdata session_data = (Userdata)session.getAttribute("LOGIN_INFO");
       String coment = (String)session.getAttribute("coment");
       Boolean mode = null;

       if (session_data != null) {
          response.sendRedirect("Home");
       } else {
         request.setAttribute("coment", coment);
          ServletContext context = this.getServletContext();
          RequestDispatcher dispatch = request.getRequestDispatcher("/Login.jsp");
          dispatch.forward(request, response);
       }
    }
 }