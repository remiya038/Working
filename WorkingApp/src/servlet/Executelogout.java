 package servlet;
 import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Userdata;


 @WebServlet({"/Executelogout"})
 public class Executelogout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
       Userdata session_data = (Userdata)session.getAttribute("LOGIN_INFO");
       if (session_data != null) {
          session.invalidate();
          response.sendRedirect("Login");
       } else {
          response.sendRedirect("Login");
       }
    }





    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request, response);
    }
 }
