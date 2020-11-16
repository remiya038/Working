package setting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("直叩き");
    	request.setAttribute("msg", "不正な動作です");
    	 ServletContext context = this.getServletContext();
         RequestDispatcher dispatch = context.getRequestDispatcher("/Setting");
         dispatch.forward(request, response);
      }

      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  HttpSession session = request.getSession();
    	  Logic_setting logic =new Logic_setting();
    	  Beans_setting beans = new Beans_setting();
    	  beans =logic.get();
    	  int row = 0;
    	  int a = Integer.parseInt(request.getParameter("mode"));
    	  //テストモードを選んだ場合
    	  if(Integer.parseInt(request.getParameter("mode"))==1) {
    		  if(beans.getMode()==1) {
    			  session.setAttribute("setting_msg", "現在テストモードに設定されています");
    		  }
    		  if(request.getParameter("date") =="" || request.getParameter("time")=="") {
    			  //テスト環境の日付情報が不足
    		  session.setAttribute("setting_msg", "日付情報に空白が含まれています");
    		  }else if(request.getParameter("date") =="" && request.getParameter("time")==""){

    		  }else {
    			  //モードと日付情報を更新
    			  session.setAttribute("setting_msg", "テストモードに変更し、日付時刻をセットしました");
    			 int mode = Integer.parseInt(request.getParameter("mode"));
    	    	 row = logic.update(mode, request.getParameter("date"), request.getParameter("time"));
    		  }
    		  //通常モードを選んだ場合
    	  }else if(Integer.parseInt(request.getParameter("mode"))==0) {
    		  if(beans.getMode()==0) {
    			  session.setAttribute("setting_msg", "現在通常モードに設定されています");
        		  //response.sendRedirect("Setting");
    		  }else {
    		  	//モードのみを更新
    		  	int mode = Integer.parseInt(request.getParameter("mode"));
    	    	 row = logic.update2(mode);
    	    	 session.setAttribute("setting_msg", "通常モードに変更しました");
    		  }
    	  }
    	  if(row == 0) {
    		  System.out.println("DB変更なし");
    	  }else {
    		  //ServletContext context = this.getServletContext();
              //RequestDispatcher dispatch = context.getRequestDispatcher("/Setting");
              //dispatch.forward(request, response);


    	  }
    	  response.sendRedirect("Setting");
      }
   }
