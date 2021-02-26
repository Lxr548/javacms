package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
import com.model.Admin;

public class AdminDao {
	//根据用户名查找用户密码
	public static Admin login(Connection conn,Admin admin)throws Exception{
		Admin resultAdmin = null;
		String sql = "select * from admin where account=? and password=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, admin.getAccount());
		pstmt.setString(2, admin.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			resultAdmin = new Admin();
			resultAdmin.setAccount(rs.getString("account"));
			resultAdmin.setPassword(rs.getString("password"));
		}
		return resultAdmin;
	}
	
}