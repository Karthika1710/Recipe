package com.gokul;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.mysql.cj.jdbc.Blob;

@WebServlet("/youruploads")
public class youruploads extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String umail = (String)session.getAttribute("umail");
		RequestDispatcher rd = null;
		Connection con = null;		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Gv@9443430629");
		PreparedStatement pst = con.prepareStatement("select * from recipeupload where recipemail=?;");
		pst.setString(1,umail);		
		ResultSet rs = pst.executeQuery();
		// Assuming you have a Recipe class with corresponding fields

		List<yourecipe> YourList = new ArrayList<yourecipe>();
		while (rs.next()) {
		    yourecipe yourecipe = new yourecipe();

			yourecipe.setYourecipename(rs.getString("recipename"));
		    yourecipe.setYourecipeing(rs.getString("recipeing"));
		    yourecipe.setYourecipepro(rs.getString("recipepro"));
		    YourList.add(yourecipe);
		}
		request.setAttribute("yourList", YourList);
		rd=request.getRequestDispatcher("uploads.jsp");
		rd.forward(request, response);
		con.close();
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
}
		
	}

