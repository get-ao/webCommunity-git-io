package cn.student.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.mysql.jdbc.Connection;

import cn.student.entity.student_attribute;

public class Student_Dao_imp   implements Student_Dao {

	private Connection conn;	
	private PreparedStatement pstet; 
	public 	Student_Dao_imp(Connection conn) {
		this.conn=conn;
	}
	@Override
	public boolean doCreat(student_attribute sAttribute) throws Exception {
		String sql = "insert into student_attribute(id,student_id,name,age,sex,grade) values (null,?,?,?,?,?)";
		this.pstet = this.conn.prepareStatement(sql);
		this.pstet.setInt(1, sAttribute.getstudent_id());
		this.pstet.setString(2, sAttribute.getName());
		this.pstet.setInt(3, sAttribute.getAge());
		this.pstet.setString(4, sAttribute.getSex());
		this.pstet.setString(5, sAttribute.getGrade());
		return this.pstet.executeUpdate() > 0;
	}

	@Override
	public boolean doUpdata(student_attribute sAttribute) throws Exception {
		String sql = "update student_attribute set  name=?,age=?,sex=?,grade=? where student_id=?";
		this.pstet = this.conn.prepareStatement(sql);
		this.pstet.setString(1, sAttribute.getName());
		this.pstet.setInt(2, sAttribute.getAge());
		this.pstet.setString(3, sAttribute.getSex());
		this.pstet.setString(4, sAttribute.getGrade());
		this.pstet.setInt(5, sAttribute.getstudent_id());
		return this.pstet.executeUpdate() > 0;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> id) throws Exception {
		if(id==null||id.size()==0) {
			return false;
		}
		StringBuffer sql = new StringBuffer();
		sql.append("delete from student_attribute where student_id in (");
		Iterator<Integer> iter = id.iterator();
		while(iter.hasNext()) {
			sql.append(iter.next()).append(",");
		}
		sql.delete(sql.length()-1, sql.length()).append(")");
		this.pstet = this.conn.prepareStatement(sql.toString());
		return this.pstet.executeUpdate()==id.size();
	}

	@Override
	public student_attribute findById(Integer student_id) throws Exception {
		student_attribute sAttribute = null;
		String sql = "select * from student_attribute where student_id=? ";
		this.pstet = this.conn.prepareStatement(sql);
		this.pstet.setInt(1, student_id);
		ResultSet rs = this.pstet.executeQuery();
		if(rs.next()) {
			sAttribute = new student_attribute();
			sAttribute.setId(rs.getInt(1));
			sAttribute.setstudent_id(rs.getInt(2));
			sAttribute.setName(rs.getString(3));
			sAttribute.setAge(rs.getInt(4));
			sAttribute.setSex(rs.getString(5));
			sAttribute.setGrade(rs.getString(6));
		}
		return sAttribute;
	}

	@Override
	public List<student_attribute> findAll() throws Exception {
		List<student_attribute> all = new ArrayList<student_attribute>();
		String sql = "select*from student_attribute";
		this.pstet = this.conn.prepareStatement(sql);
		ResultSet rs = pstet.executeQuery();
		while(rs.next()) {
		student_attribute	sAttribute = new student_attribute();
			sAttribute.setId(rs.getInt(1));
			sAttribute.setstudent_id(rs.getInt(2));
			sAttribute.setName(rs.getString(3));
			sAttribute.setAge(rs.getInt(4));
			sAttribute.setSex(rs.getString(5));
			sAttribute.setGrade(rs.getString(6));
			all.add(sAttribute);
		}
		return all;
	}
	@Override
	public int getPageCount(int pageSize) throws Exception {
		String sql = "select count(*) from student_attribute";
		this.pstet = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstet.executeQuery();
		rs.next();
		int rowsCount = rs.getInt(1);
		int pageCount = (int)Math.ceil(1.0*rowsCount/pageSize);//算出多少页
		return pageCount;
	}
	@Override
	/**
	 * pageNo：要找的页数
	 * pageSize：当前页数的个数
	 */
	public List<student_attribute> getPagelist(int pageNo, int pageSize) throws Exception {
		List<student_attribute> list = new ArrayList<student_attribute>();
		String sql = "select * from student_attribute limit ?,?";
		this.pstet = this.conn.prepareStatement(sql);
		this.pstet.setInt(1, (pageNo-1)*pageSize);//距离这一页的第一行数据，其前面有多少行
		this.pstet.setInt(2, pageSize);//每页多少行
		ResultSet rs = this.pstet.executeQuery();
		while(rs.next()) {
			student_attribute sAttribute = new student_attribute();
			sAttribute.setId(rs.getInt(1));
			sAttribute.setstudent_id(rs.getInt(2));
			sAttribute.setName(rs.getString(3));
			sAttribute.setAge(rs.getInt(4));
			sAttribute.setSex(rs.getString(5));
			sAttribute.setGrade(rs.getString(6));
			list.add(sAttribute);
		}
		return list;
	}

}
