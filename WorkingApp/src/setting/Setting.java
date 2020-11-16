package setting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet01
 */
@WebServlet("/Setting")
public class Setting extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Setting() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
      }

      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  	Beans_setting beans = new Beans_setting();
    	  	Logic_setting logic = new Logic_setting();
    	  	beans = logic.get();
		  	request.setAttribute("beans", beans);
		  	String msg = (String) request.getAttribute("msg");
		  	request.setAttribute("msg",msg);
    	    ServletContext context = this.getServletContext();

    	    //サーバーにあげる際にsetting.JSPを削除 サーバーでSetting.javaへアクセスするとLogin.javaの処理
            RequestDispatcher dispatch = context.getRequestDispatcher("/setting.jsp");
            if(dispatch == null) {
            	dispatch.forward(request, response);
            }else{
    	    	response.sendRedirect("Login");
            }


      }
   }