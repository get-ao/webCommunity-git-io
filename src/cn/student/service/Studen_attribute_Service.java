package cn.student.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.student.entity.student_attribute;

public interface Studen_attribute_Service {
	//插入数据
	public boolean insert(student_attribute sAttribute) throws Exception;
	//更新数据
	public boolean updata(student_attribute saAttribute) throws Exception;
	//删除数据
	public boolean delete(Set<Integer> id) throws Exception;
	//id查找
	public student_attribute get(int id) throws Exception;
	//查询全部
	public List<student_attribute> list() throws Exception;
	//查询总页数
	public int getCount(int page) throws Exception;
	//查询指定页数的数据
	public List<student_attribute> getAttributes (int pageNo,int pageSize) throws Exception;
	
}
