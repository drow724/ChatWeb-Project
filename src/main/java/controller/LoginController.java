package controller;

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

@WebServlet("/login")
public class LoginController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String userID = null;
		if(session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
		if(userID != null) {
			request
			.getRequestDispatcher("/WEB-INF/view/main.jsp")
			.forward(request, response);
		}else {
		request
		.getRequestDispatcher("/WEB-INF/view/login.jsp")
		.forward(request, response);
	}
}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String userID = request.getParameter("userID");
		String userPassword =request.getParameter("userPassword");
	
		UserDAO userDAO = new UserDAO();
		User user = new User();
		
		
		int result = userDAO.login(userID, userPassword);
		if (result == 1) {
			session.setAttribute("userID", userID);
			System.out.println(session.getAttribute("userID"));
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
