package cn.student.dao;

import java.util.List;
import java.util.Set;

import cn.student.entity.student_attribute;

public interface Student_Dao {
	//添加成员
	public boolean doCreat(student_attribute sAttribute) throws Exception;
	//更新信息
	public boolean doUpdata(student_attribute sAttribute) throws Exception;
	//删除成员
	public boolean doRemoveBatch(Set<Integer> id) throws Exception;
	//查找成员
	public student_attribute findById(Integer id) throws Exception;
	//查询全部
	public  List<student_attribute> findAll() throws Exception;
	//获取总页数
	public int getPageCount(int pageSize) throws Exception;
	//获取指定页的数据
	public List<student_attribute> getPagelist(int pageNo,int pageSize) throws Exception;
}
