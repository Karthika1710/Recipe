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

import com.mysql.cj.Session;
import com.mysql.cj.protocol.Resultset;


@WebServlet("/Home")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String umail  = request.getParameter("username");
		String pwd = request.getParameter("password");
		Connection con =null;
		RequestDispatcher rd = null;
		String usr = null;
		HttpSession session = request.getSession();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","PHW#84#jeor");
			PreparedStatement pst = con.prepareStatement("select * from userlogin where uemail=? and upwd=?");
			PreparedStatement pst1 = con.prepareStatement("select uname from userlogin where uemail=?");
			pst.setString(1,umail);
			pst.setString(2,pwd);
			pst1.setString(1, umail);
			ResultSet rs = pst.executeQuery();
			ResultSet rs1 = pst1.executeQuery();
			if(rs.next()) {
				rs1.next();
				usr = rs1.getString("uname");
				session.setAttribute("name",usr);				
				session.setAttribute("umail",umail);				
				rd = request.getRequestDispatcher("home.jsp");
				
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
