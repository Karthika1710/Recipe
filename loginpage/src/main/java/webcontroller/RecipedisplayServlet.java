package webcontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.recipedisplay;
import model.userinfo;


@WebServlet("/RecipedisplayServlet")
public class RecipedisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
   private recipedisplay userdao;
   
   public RecipedisplayServlet() {
	   super();
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String umail = (String) session.getAttribute("umail");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			request.setAttribute("userlist", userdao.recipedis(umail));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		RequestDispatcher rd = request.getRequestDispatcher("uploads.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
