package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import biz.userBiz;
import entity.user;

public class addServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int userId=Integer.parseInt(request.getParameter("userId"));
		String userName=request.getParameter("userName");
		userName=new String(userName.getBytes("iso-8859-1"),"utf-8");
		String userPwd=request.getParameter("userPwd");
		userPwd=new String(userPwd.getBytes("iso-8859-1"),"utf-8");
		int userAge=Integer.parseInt(request.getParameter("userAge"));
		user user=new user();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		user.setUserAge(userAge);
		userBiz addBiz=new userBiz();
		boolean add=addBiz.addUser(user);
		if(add)
		{
			List<user> userInfo=addBiz.getAlluser();
			JSONArray jsonArray=JSONArray.fromObject(userInfo);
			out.print(jsonArray);
			//out.print("<script>alert('增加成功')</script>");
		}
		else
		{
			//out.print("<script>alert('增加失败')</script>");
		}
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
