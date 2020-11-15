package cn.student.service;

import cn.student.Factory.DaoFactory;
import cn.student.entity.teacher_user;
import cn.student.util.baseDAO;

public class teacher_service_imp implements teacher_Service {
	private baseDAO dbc = new baseDAO();
	@Override
	public boolean login(teacher_user teacher_user) throws Exception {
		try {
			return DaoFactory.getteacher_Dao(dbc.getConnection()).login(teacher_user);
		} catch (Exception e) {
			throw e;
		}
		finally {
			this.dbc.close();
		}
	}

}
