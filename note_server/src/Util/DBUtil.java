package Util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBUtil {
          static String dbName = "note_ _db"; //���ݿ���
          static String name ="root";//���ݿ��û���
          static String pass =" dsy1999422"; //���ݿ�����

          
          //main��������һ�� �Ƿ������ӵ����ݿ�

public static void main(String[] args) {

	Connection c = getConnection() ;
try {
	Statement st = (Statement)c. createStatement() ; 
	
	st. execute(" insert into user (name, pass) values(' zhangsan' ;'123' )");
	close(c,st, null) ;
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


}


public static void close(Connection c, Statement stat, ResultSet rs) {
	//�ͷ���Դ
	
	if(rs != null) {
	try {
	     rs. close();
	}catch (SQLException e) {
	// T0DO Auto-generated catch block
	e.printStackTrace();
	     }
	}
	if(stat!= null ) {
	try {
	stat.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e. printStackTrace();
	 	 }
	}
	if(c != null) {
	try {
	c.close();
	}catch (SQLException e) {
	// T0DO Auto-generated catch block
	e.printStackTrace();
	
	}
	}
}
	

public static Connection getConnection() {
	//��ȡ���ݿ����Ӷ���
	
	Connection c = null;
	try {
	Class. forName ( "com.mysql.jdbc.Driver"); //����mysq1��J dbc����
	c = (Connection)DriverManager.getConnection (" jdbc :mysq1://localhost:3306/" + dbName, name, pass); //��ȡ���ݿ�����
	} catch (ClassNotFoundException e) {
	// T0DO Auto-generated catch block
	e.printStackTrace();
	} catch (SQLException e) {
	// T0D0 Auto-generated catch block
	e.printStackTrace();
	}
	return c;

	
}
	}
	


	

