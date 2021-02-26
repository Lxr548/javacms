package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Admin;
import com.dao.AdminDao;
import com.util.DBconn;
import com.util.StringUtil;
/**
 * Servlet implementation class AddMessageServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBconn dbconn=new DBconn();
	AdminDao adminDao=new AdminDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");//获取用户名
		String password = request.getParameter("password");//获取密码
		//将集合对象保存到应用上下文中
		request.setAttribute("account", account);
		request.setAttribute("password", password);
		//判断用户名和密码是否为空
		if(StringUtil.isEmpty(account)||StringUtil.isEmpty(password)){
			request.setAttribute("error", "用户名或密码为空!");
			//如果用户名和密码为空则重定向到登录页面
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		//实例化user类
		Admin admin  = new Admin(account,password);
		Connection conn = null;
		
		try {
			
			conn = DBconn.getConn();
			Admin currentAdmin = AdminDao.login(conn, admin);
			//判断用户名、
			if(currentAdmin==null){
				request.setAttribute("error", "用户名或密码错误!");
				//服务器端跳转
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}else{
				//获取session对象
				HttpSession session  = request.getSession();
				session.setAttribute("currentAdmin", currentAdmin);
				//客户端跳转
				response.sendRedirect("applylist.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBconn.closeConn();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}