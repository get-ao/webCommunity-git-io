package cn.student.controlller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.student.Factory.ServiceFactory;
import cn.student.entity.student_attribute;

/**
 * 
 */
@WebServlet("/studentAdd")
public class studentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public studentAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String student_id = request.getParameter("student_id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String grade = request.getParameter("grade");
		student_attribute sAttribute = new student_attribute();
		sAttribute.setstudent_id(Integer.valueOf(student_id));
		sAttribute.setName(name);
		sAttribute.setAge(Integer.valueOf(age));
		sAttribute.setSex(sex);
		sAttribute.setGrade(grade);
		try {
		 ServiceFactory.getService().insert(sAttribute);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("sAttribute", sAttribute);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
