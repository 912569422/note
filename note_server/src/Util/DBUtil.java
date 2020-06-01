package Util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBUtil {
          static String dbName = "note_ _db"; //数据库名
          static String name ="root";//数据库用户名
          static String pass =" dsy1999422"; //数据库密码

          
          //main方法测试一下 是否能连接到数据库

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
	//释放资源
	
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
	//获取数据库连接对象
	
	Connection c = null;
	try {
	Class. forName ( "com.mysql.jdbc.Driver"); //加载mysq1的J dbc驱动
	c = (Connection)DriverManager.getConnection (" jdbc :mysq1://localhost:3306/" + dbName, name, pass); //获取数据库连接
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
	


	

