package cn.student.controlller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.student.Factory.ServiceFactory;

/**
 * 删除
 */
@WebServlet("/studentDel")
public class studentDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 boolean data = false;
		Set<Integer> student_id = new HashSet<Integer>();
		student_id.add(Integer.valueOf(request.getParameter("student_id")));
		try {
		 data = ServiceFactory.getService().delete(student_id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.getSession().setAttribute("data", data);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
