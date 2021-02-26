package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PersonDao;
import com.model.Person;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonDao personDao = new PersonDao();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
	    String path="list.jsp"; 
		
	    if(method.equals("list")){
		    List<Person> list = null;
			try {
				list = personDao.findAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    request.setAttribute("list", list);
		}else if(method.equals("add")){
			String full_name_zh = request.getParameter("full_name_zh");//获取姓名
			String full_name_en = request.getParameter("full_name_en");//获取英文名
			String sex = request.getParameter("sex");//获取性别
			String politics_type = request.getParameter("politics_type");//获取政治面貌
			String education_level = request.getParameter("education_level");//获取教育水平
			String wei_chat = request.getParameter("wei_chat");//获取微信号
			String email = request.getParameter("email");//获取邮箱
			String cellphone = request.getParameter("cellphone");//获取电话
			String telephone = request.getParameter("telephone");//获取手机
			String work_unit = request.getParameter("work_unit");//获取工作
			String title = request.getParameter("title");//获取标题
			String home_address = request.getParameter("home_address");//获取住址
			String identity_card_no = request.getParameter("identity_card_no");//获取身份证号码
			//将
			Person person = new Person();
			person.setFull_name_zh(full_name_zh);
			person.setFull_name_en(full_name_en);
			person.setSex(sex);
			person.setPolitics_type(politics_type);
			person.setEducation_level(education_level);
			person.setWei_chat(wei_chat);
			person.setEmail(email);
			person.setCellphone(cellphone);
			person.setTelephone(telephone);
			person.setWork_unit(work_unit);
			person.setTitle(title);
			person.setHome_address(home_address);
			person.setIdentity_card_no(identity_card_no);
			try {
				personDao.add(person);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			path="AddressServlet?method=list";
		}else if(method.equals("toedit")){
			int member_id = Integer.parseInt(request.getParameter("member_id"));
			Person person = null;
			try {
				person = personDao.findById(member_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			request.setAttribute("person", person);
			path ="edit.jsp";
		}else if(method.equals("edit")){
			int member_id = Integer.parseInt(request.getParameter("member_id"));
			String date_status = request.getParameter("date_status");
			Person person = new Person();
			person.setMember_id(member_id);
			person.setDate_status(date_status);
			try {
				personDao.update(person);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			path="AddressServlet?method=list";
		}
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}
 
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doGet(request, response);     
		
	}

}
