package controller.admin;

import java.io.Console;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import entity.UserDAO;

@WebServlet("/admin/main") 
public class MainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("Admin") == "????") {
			request
			.getRequestDispatcher("/WEB-INF/view/admin/main.jsp")
			.forward(request, response);
		} else {
			request
			.getRequestDispatcher("/WEB-INF/view/admin/index.jsp")
			.forward(request, response);
		}
	}
}
