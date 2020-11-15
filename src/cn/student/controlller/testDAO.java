package cn.student.controlller;

import cn.student.Factory.ServiceFactory;
import cn.student.entity.teacher_user;

public class testDAO {
	public static void main(String[] args) {
		teacher_user teacher_user = new teacher_user();
		teacher_user.setT_username("111");
		teacher_user.setT_password("111");
		try {
		boolean flag =	ServiceFactory.geTeacher_Service().login(teacher_user);
		System.out.println(flag);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
   