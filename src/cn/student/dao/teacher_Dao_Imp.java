package cn.student.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import cn.student.entity.teacher_user;

public class teacher_Dao_Imp implements teacher_Dao {
	
	private Connection conn;	
	private PreparedStatement pstet; 
	public 	teacher_Dao_Imp(Connection conn) {
		this.conn=conn;
	}
	@Override
	public boolean login(teacher_user teacher_user) throws Exception {
		boolean flag = false;
		String user = teacher_user.getT_username();
		String psw = teacher_user.getT_password();
		List<teacher_user> list = new ArrayList<teacher_user>();
		String sql = "select*from teacher_user";
		this.pstet = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstet.executeQuery();
		while(rs.next()) {
			teacher_user tUser = new teacher_user();
			tUser.setT_username(rs.getString(2));
			tUser.setT_password(rs.getString(3));
			list.add(tUser);
		}
		for(int i=0;i<list.size();i++) {
			if(user.equals(list.get(i).getT_username())&&psw.equals(list.get(i).getT_password())) {
				flag = true;
			}
		}
		return flag;
	}

}
