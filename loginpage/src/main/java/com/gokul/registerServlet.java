package com.gokul;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname = (String)req.getParameter("name");
		String uemail = (String)req.getParameter("email");
		String upwd = (String)req.getParameter("pass");
		String urepass = (String)req.getParameter("re-pass");
		String ucontact = (String)req.getParameter("contact");
		String checklist = req.getParameter("agree");
		RequestDispatcher rd = null;
		Connection con = null;
		PrintWriter prt = res.getWriter();
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","PHW#84#jeor");
		PreparedStatement pst = con.prepareStatement("insert into userlogin(uname,upwd,ucontact,uemail) values(?,?,?,?)");
		pst.setString(1,uname);
		pst.setString(2,upwd);
		pst.setString(3,ucontact);
		pst.setString(4,uemail);
		rd = req.getRequestDispatcher("registration.jsp");
		req.setAttribute("usrname",uname);
		int id = pst.executeUpdate();   
		if(id > 0) {
			req.setAttribute("status", "success");
		}
		else {
			req.setAttribute("status","failed");
		}
		rd.forward(req,res);
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	}
}
