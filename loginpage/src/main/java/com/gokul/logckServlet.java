package com.gokul;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logckServlet")
public class logckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmail  = request.getParameter("username");
		String cpwd = request.getParameter("password");
		System.out.println(cmail);
		System.out.println(cpwd);

		Connection con =null;
		RequestDispatcher rd = null;
		String usr = null;
		HttpSession session = request.getSession();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","PHW#84#jeor");
			PreparedStatement pst = con.prepareStatement("select * from cooklog where cmail=? and cpwd=?"); 
			PreparedStatement pst1 = con.prepareStatement("select cname from cooklog where cmail=?");
			pst.setString(1,cmail);
			pst.setString(2,cpwd);
			pst1.setString(1, cmail);
			ResultSet rs2 = pst.executeQuery();
			ResultSet rs3 = pst1.executeQuery();
			if(rs2.next()) {
				rs3.next();
				usr = rs2.getString("cname");
				session.setAttribute("name",usr);				
				session.setAttribute("umail",cmail);				
				rd = request.getRequestDispatcher("cookhome.jsp");
				
			}
			else {
				rd = request.getRequestDispatcher("login.jsp");
				
			}
			rd.forward(request, response);			
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
