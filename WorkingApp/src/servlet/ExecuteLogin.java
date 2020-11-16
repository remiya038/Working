package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Userdata;
import dao.Dao;
import logic.LoginLogic;

@WebServlet({"/ExecuteLogin"})
public class ExecuteLogin extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.sendRedirect("Login");
    }







   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();

       Userdata session_data = (Userdata)session.getAttribute("LOGIN_INFO");
      new Userdata();
       if (session_data != null) {

          response.sendRedirect("Home");
      }
       Dao dao = new Dao();
       LoginLogic login = new LoginLogic();
       String emp_str = request.getParameter("emp_no");
       String pass = request.getParameter("pass");
       String coment = null;

       login = login.login(emp_str,pass);
       if(login.sevret=="Login") {
    	   session.setAttribute("coment", login.comment);
    	   response.sendRedirect(login.sevret);
       }else{
    	   int emp_no = Integer.parseInt(emp_str);
           Userdata userdata = dao.select_emp(emp_no);
    	   session.setAttribute("LOGIN_INFO",userdata);
    	   response.sendRedirect("Home");
       }
         // int emp_no = Integer.parseInt(request.getParameter("emp_no"));
         // Userdata data = login.login(emp_no);


    }

   }



