package cn.student.util;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;

public class baseDAO {
	//驱动
	private static String driver = "com.mysql.jdbc.Driver";
	//URL
	private static String url = "jdbc:mysql://127.0.0.1:3306/student";
	//用户名
	private static String user = "root";
	//密码
	private static String psw  = "haroot"; 
	//数据库连接
    private Connection conn = null;
    //statement对象
   public baseDAO() {
	   try {
		Class.forName(driver);
		this.conn = (Connection) DriverManager.getConnection(url,user,psw);
	} catch (Exception e) {
		
	}
   }
	 //取得一个数据库的连接
	public Connection getConnection() {
		return this.conn;
	}
	//数据库的关闭
	public void close() {
		if(this.conn!=null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
