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

import beans.Timesheet;
import beans.Userdata;

/**
 * Servlet implementation class Error
 */
@WebServlet("/Error")
public class Error extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Error() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
     }





     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Userdata session_data = (Userdata)session.getAttribute("LOGIN_INFO");
        Timesheet timesheet = (Timesheet)session.getAttribute("TIMESHEET");

        if (session_data == null) {
           response.sendRedirect("Login");
        } else {
           request.setAttribute("name", session_data.getName());
           ServletContext context = this.getServletContext();
           RequestDispatcher dispatch = context.getRequestDispatcher("/Error.jsp");
           dispatch.forward(request, response);
        }
     }
  }
