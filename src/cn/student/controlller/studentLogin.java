package cn.student.controlller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.student.Factory.ServiceFactory;
import cn.student.entity.teacher_user;

/**
 * Servlet implementation class studentLogin
 */
@WebServlet("/studentLogin")
public class studentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		boolean flag = false;
		String user = request.getParameter("user");
		String psw = request.getParameter("password");
		String kind = request.getParameter("kind");
		teacher_user teacher_user = new teacher_user();
		teacher_user.setT_username(user);
		teacher_user.setT_password(psw);
		try {
		 flag = ServiceFactory.geTeacher_Service().login(teacher_user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(flag&&kind.equals("老师")) {
			 request.getRequestDispatcher("/daohang.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
