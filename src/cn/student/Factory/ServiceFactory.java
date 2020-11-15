package cn.student.Factory;

import cn.student.service.Studen_attribute_Service;
import cn.student.service.Student_attribute_serviceImp;
import cn.student.service.teacher_Service;
import cn.student.service.teacher_service_imp;

public class ServiceFactory {
	public static Studen_attribute_Service getService() {
		return new Student_attribute_serviceImp();
	}
	public static teacher_Service geTeacher_Service() {
		return new teacher_service_imp();
	}
}
