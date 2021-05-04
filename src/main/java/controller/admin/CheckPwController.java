package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import entity.User;
import entity.UserDAO;
import service.AdminService;

@WebServlet("/admin/checkPw")
public class CheckPwController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request
		.getRequestDispatcher("/WEB-INF/view/admin/checkPw.jsp")
		.forward(request, response);
	}	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int password =Integer.parseInt(request.getParameter("password"));
		
		AdminService adminService = new AdminService();
		
		
		int result = adminService.adminLogin(password);
		if (result == 1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'changePw'");
			script.println("</script>");
		}
		else if(request.getParameter("password") == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'passwordError'");
			script.println("</script>");
		}
	}
}
