package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import entity.User;
import entity.UserDAO;
import service.AdminService;

@WebServlet("/admin/adminLogin")
public class LoginController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("password") == null) {
			request
			.getRequestDispatcher("/WEB-INF/view/admin/nullError.jsp")
			.forward(request, response);
		}
		HttpSession session = request.getSession();
		int password = Integer.parseInt(request.getParameter("password"));
		AdminService adminService = new AdminService();
		int result = adminService.adminLogin(password);
		if (result == 1) {
			session.setAttribute("Admin", "½ÂÀÎ");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'main'");
			script.println("</script>");
		}
		else if(result == 0) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'passwordError'");
			script.println("</script>");
		}
		else if(result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'idError'");
			script.println("</script>");
		}
		else if(result == -2) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'dbError'");
			script.println("</script>");
		}
	}

}
