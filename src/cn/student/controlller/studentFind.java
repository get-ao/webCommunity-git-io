package cn.student.controlller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.student.Factory.ServiceFactory;
import cn.student.entity.student_attribute;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class studentFind
 */
@WebServlet("/studentFind")
public class studentFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentFind() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String key = request.getParameter("key");
		JSONObject jsonObject = null;
		List<student_attribute> list = new ArrayList<student_attribute>();
		try {
			student_attribute sAttribute = 	ServiceFactory.getService().get(Integer.valueOf(key));
			list.add(sAttribute);
			new limitPage();
			jsonObject = limitPage.jsonArray(list, list.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("jsonObject", jsonObject);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(jsonObject);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
