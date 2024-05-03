package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import Db.Dbconnect;
import model.userinfo;

public class recipedisplay {
	Connection conn = null;
	HttpSession session;

	 recipedisplay() throws SQLException {
		conn = Dbconnect.getConnection();
	}
	
	public List recipedis(String umail) throws SQLException {
		List<userinfo> userlist = new <userinfo>ArrayList();
			
		PreparedStatement pst = conn.prepareStatement("select * from recipeupload where recipemail=?");
		pst.setString(1, umail);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			userinfo user = new userinfo();
			user.setRecipename(rs.getString("recipename"));
			user.setRecipeing(rs.getString("recipeing"));
			user.setRecipeing(rs.getString("recipepro"));
			userlist.add(user);
		}
		return userlist;
	}

	
}
