package com.gokul;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.protocol.Resultset;


@WebServlet("/recipedis")

public class recipedis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd = null;
			Connection con = null;		
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","PHW#84#jeor");
			PreparedStatement pst = con.prepareStatement("select * from recipeupload;"); 
			ResultSet rs = pst.executeQuery();
			// Assuming you have a Recipe class with corresponding fields
			List<Recipe> recipeList = new ArrayList<Recipe>();
			while (rs.next()) {
			    Recipe recipe = new Recipe();
			    recipe.setRecipename(rs.getString("recipename"));
			    recipe.setRecipeing(rs.getString("recipeing"));
			    recipe.setRecipepro(rs.getString("recipepro"));
			    recipe.setUsername(rs.getString("username"));
			    recipeList.add(recipe);
			}
			request.setAttribute("recipeList", recipeList);
			rd=request.getRequestDispatcher("recipedis.jsp");
			rd.forward(request, response);
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
}


