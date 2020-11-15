package cn.student.service;

import java.util.List;
import java.util.Set;

import cn.student.Factory.DaoFactory;
import cn.student.entity.student_attribute;
import cn.student.util.baseDAO;

public class Student_attribute_serviceImp implements Studen_attribute_Service {
	private baseDAO dbc = new baseDAO();
	@Override
	public boolean insert(student_attribute sAttribute) throws Exception {
		try {
			if(DaoFactory.getStudent_Dao(dbc.getConnection()).findById(sAttribute.getstudent_id())==null) {
				return DaoFactory.getStudent_Dao(dbc.getConnection()).doCreat(sAttribute);
			}
			return false;
		} catch (Exception e) {
			throw e;
		}
		finally {
			this.dbc.close();
		}
	}
	
	@Override
	public boolean updata(student_attribute saAttribute) throws Exception {
		try {
			return DaoFactory.getStudent_Dao(dbc.getConnection()).doUpdata(saAttribute);
		} catch (Exception e) {
			throw e;
		}
		finally {
			this.dbc.close();
		}
	}
	
	@Override
	public boolean delete(Set<Integer> student_id) throws Exception {
		try {
			return DaoFactory.getStudent_Dao(dbc.getConnection()).doRemoveBatch(student_id);
		} catch (Exception e) {
			throw e;
		}
		finally {
			this.dbc.close();
		}
	}
	
	@Override
	public student_attribute get(int student_id) throws Exception {
		try {
			return DaoFactory.getStudent_Dao(dbc.getConnection()).findById(student_id);
		} catch (Exception e) {
			throw e;
		}
		finally {
			this.dbc.close();
		}
	}
	
	@Override
	public List<student_attribute> list() throws Exception {
		try {
		return DaoFactory.getStudent_Dao(dbc.getConnection()).findAll();	
		} catch (Exception e) {
			throw e;
		}
		finally {
			this.dbc.close();
		}
	}

	@Override
	public int getCount(int page) throws Exception {
		try {
			return DaoFactory.getStudent_Dao(dbc.getConnection()).getPageCount(page);
		} catch (Exception e) {
			throw e;
		}
		finally {
			this.dbc.close();
		}
	}

	@Override
	public List<student_attribute> getAttributes(int pageNo, int pageSize) throws Exception {
		try {
			return DaoFactory.getStudent_Dao(dbc.getConnection()).getPagelist(pageNo, pageSize);
		} catch (Exception e) {
			throw e;
		}
		finally {
			this.dbc.close();
		}
	}
	
}
