package com.dao;

import java.sql.*;
import java.util.*;

import com.model.*;
import com.util.*;

public class PersonDao {
	public void add(Person person) throws Exception{
		try{
			Connection conn = DBconn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("insert into member_personage (full_name_zh,full_name_en,sex,politics_type,education_level,wei_chat,email,cellphone,telephone, work_unit,title,home_address,identity_card_no,resumes) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,person.getFull_name_zh());
			pstmt.setString(2,person.getFull_name_en());
			pstmt.setString(3,person.getsSex());
			pstmt.setString(4,person.getPolitics_type());
			pstmt.setString(5,person.getEducation_level());
			pstmt.setString(6,person.getWei_chat());
			pstmt.setString(7,person.getEmail());
			pstmt.setString(8,person.getCellphone());
			pstmt.setString(9,person.getTelephone());
			pstmt.setString(10,person.getWork_unit());
			pstmt.setString(11,person.getTitle());
			pstmt.setString(12,person.getHome_address());
			pstmt.setString(13,person.getIdentity_card_no());
			pstmt.setString(14,person.getResumes());
			pstmt.executeUpdate();
			DBconn.closeConn();
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public void update(Person person)throws Exception{
		try {
			Connection conn = DBconn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("update member_personage set date_status=? where member_id=?");
			pstmt.setString(1,person.getDate_status());
			pstmt.setInt(2,person.getMember_id());
			pstmt.executeUpdate();
			DBconn.closeConn();
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
  public List<Person> findAll()throws Exception{
		List<Person> list = new ArrayList<Person>();
		try {
			Connection conn = DBconn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("select * from member_personage");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Person person = new Person();
				person.setFull_name_zh(rs.getString(1));
				person.setCreate_date(rs.getString(2));
				person.setDate_status(rs.getString(3));
			   list.add(person);
			}
			DBconn.closeConn();
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);
		}
		return list;
	}
  
  public Person findById(int id)throws Exception{
	  Person person = new Person();
	  try {
			Connection conn = DBconn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("select * from member_personage where member_id=?");
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				person.setFull_name_zh(rs.getString(1));
				person.setSex(rs.getString(2));
				person.setEducation_level(rs.getString(3));
				person.setCellphone(rs.getString(4));
				person.setDate_status(rs.getString(5));
			}

			DBconn.closeConn();
	  	}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);
		}	
		return person;
	}	
}