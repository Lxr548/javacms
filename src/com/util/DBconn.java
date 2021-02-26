package com.util;
 
import java.sql.*;


public class DBconn {
	static String driver="com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/sx_ssl?useunicuee=true& characterEncoding=utf8"; 
	static String username = "root"; 
	static String password = "123"; 
	static ResultSet rs = null;
	static Connection conn = null;
	static Statement sta =null;
	static PreparedStatement psta =null;
	public static  Connection getConn(){
		try {
			Class.forName(driver);
			try {
				conn = DriverManager.getConnection(url,username,password);
				return conn;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}
	public static Statement createStatement()
	{
		try {
			sta=getConn().createStatement();
			return sta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//创造数据预处理对象
	public static PreparedStatement createPreparedStatement(String sql)
	{
		try {
			psta = getConn().prepareStatement(sql);
			return psta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return psta;
	}
	//关闭所有打开的资源
	public static void closeConn()
	{
		if(psta==null)
		{
			try {
				psta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(sta==null)
		{
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn==null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}