package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Board;
import entity.User;
import entity.UserDAO;
import service.AdminService;
import service.WriteService;

@WebServlet("/admin/changePw")
public class ChangePwController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request
		.getRequestDispatcher("/WEB-INF/view/admin/changePw.jsp")
		.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			int password = Integer.parseInt(request.getParameter("password"));
			AdminService adminService = new AdminService();
			
			int result = adminService.changePw(password);
			
			if(result==-1) {
				request
				.getRequestDispatcher("/WEB-INF/view/admin/dbError.jsp")
				.forward(request, response);
			} else {
				request
				.getRequestDispatcher("/WEB-INF/view/admin/finish.jsp")
				.forward(request, response);
			}
	}
}
