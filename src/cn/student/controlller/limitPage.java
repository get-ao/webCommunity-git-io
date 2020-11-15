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
 * Servlet implementation class limitPage
 */
@WebServlet("/limitPage")
public class limitPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public limitPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int limit = 0;
		int page = 0;
		JSONObject jsonObject = null;
		limit = Integer.parseInt(request.getParameter("limit"));
		page = Integer.parseInt(request.getParameter("page"));
		List<student_attribute> list = new ArrayList<student_attribute>();
		try {
			int countItem = ServiceFactory.getService().getCount(1);//总数据量
			list = ServiceFactory.getService().getAttributes(page, limit);
			jsonObject = jsonArray(list, countItem);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		request.setAttribute("jsonObject", jsonObject);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(jsonObject);
	}
	public static JSONObject jsonArray(List<student_attribute> list,int countItem) {
		//主体JSON
		JSONObject jsonMain = new JSONObject();
		//Item:[{}]
		JSONObject jsonItem = new JSONObject();
		//为item 添加值
		jsonItem.put("item", list);
		//添加status
		jsonMain.put("status", 200);
		//添加message
		jsonMain.put("message", "");
		//添加datasize
		jsonMain.put("datasize", countItem);
		//JOSN 添加 rows rows为item
		jsonMain.put("row",jsonItem);
		
		return jsonMain;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
