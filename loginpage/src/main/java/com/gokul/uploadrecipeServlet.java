package com.gokul;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.cj.Session;

@WebServlet("/RecipeServlet")
@MultipartConfig
public class uploadrecipeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	HttpSession session = req.getSession();
        String recipeName = req.getParameter("recipeName");
        String recipeingr = req.getParameter("ingredients");
        String recipeproc = req.getParameter("procedure");
        String usr = (String) session.getAttribute("name");
        RequestDispatcher rd = null;

        InputStream inputStream = null; // Input stream of the upload file

        Part filePart = req.getPart("recipeImage");
        if (filePart != null) {
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "PHW#84#jeor");

            //Insert data and image into the database
            PreparedStatement pst = con.prepareStatement("INSERT INTO recipeupload (recipename,recipeing,recipepro,username) VALUES (?, ?, ?, ?)");
            pst.setString(1, recipeName);
            pst.setString(2, recipeingr);
            pst.setString(3, recipeproc);
            pst.setString(4, usr);
            int result = pst.executeUpdate();
            if(result>0) {
            		res.sendRedirect("index.jsp");
            }
            else {
            	System.out.println("Query not executed");
            }
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
