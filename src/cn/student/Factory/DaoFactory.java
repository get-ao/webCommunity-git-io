package cn.student.Factory;

import com.mysql.jdbc.Connection;

import cn.student.dao.Student_Dao;
import cn.student.dao.Student_Dao_imp;
import cn.student.dao.teacher_Dao;
import cn.student.dao.teacher_Dao_Imp;

public interface DaoFactory { 
	public static Student_Dao getStudent_Dao(Connection conn) {
		return new Student_Dao_imp(conn);
	}
	public static teacher_Dao getteacher_Dao(Connection conn) {
		return new teacher_Dao_Imp(conn);
	}
}
