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
 * Servlet implementation class Complete
 */
@WebServlet("/Complete")
public class Complete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Complete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Userdata session_data = (Userdata)session.getAttribute("LOGIN_INFO");
		Timesheet timesheet = (Timesheet)session.getAttribute("timesheet");
		String attendance = (String)session.getAttribute("attendance");
		if (session_data == null) {
		response.sendRedirect("Login");
			} else {
				request.setAttribute("timesheett", timesheet);
				request.setAttribute("attendance", attendance);
				ServletContext context = this.getServletContext();
				RequestDispatcher dispatch = context.getRequestDispatcher("/complete.jsp");
				dispatch.forward(request, response);
			}
	}

}
