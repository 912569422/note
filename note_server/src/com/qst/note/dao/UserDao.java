package com.qst.note.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Util.DBUtil;
import userBean.userBean;

public class UserDao {

	
	//向user表中插入一条数据 (注册)
	public boolean regist (userBean user) {
	Connection c = DBUtil.getConnection() ;
	try {
	PreparedStatement pst = (PreparedStatement) c. prepareStatement ("insert into user ( name, pass, tel, qq, wechat)values(?,?,?,?,?)");
	
	pst. setString (0, user. getName());
	pst. setString(1,user. getPass());
	pst. setString (2, user. getTel());
	pst. setString(3, user. getqq());
	pst. setString (4,user. getWechat());
	boolean result = pst. execute ();
	DBUtil.close(c, pst, null);
	return result;
	} catch (SQLException e) {
	// T0DO Auto-generated catch block
	e. printStackTrace() ;
	return false;
	}

	
}
	
	public boolean login(String tel, String pass) {
		    Connection c = DBUtil. getConnection();
		    PreparedStatement pst = null;
		    try {
		           pst =(PreparedStatement) c. prepareStatement(" select pass from user where tel='?'" );
		           pst. setString(1,tel);
		           ResultSet rs = pst. executeQuery();
		           if (rs.first()) {
		                 String passInDb = rs. getString( "pass");
		                 if (passInDb. equals (pass))
		                      return true;
		            }
		} catch (SQLException e) {
		         e. printStackTrace();
		}finally {
		     DBUtil. close(c,pst, null);
		}
		return false;

	}
	
	//根据用户名返回ID
	public int getIDbyTel(String tel) {
	       Connection c = DBUtil.getConnection();
	       PreparedStatement pst = null;
	int id = 0;
	
	try {
	
		pst = (PreparedStatement) c.prepareStatement("select id from user where tel=?");
	    pst.setString(1, tel);
	    ResultSet rs = pst.executeQuery();
	     if(rs.first()) {
	            id = rs.getInt("id");
	
	     }
	} catch (SQLException e) {
	e.printStackTrace();
	}finally {
	
		DBUtil.close(c, pst, null);
	}
	return id;
    }
}
