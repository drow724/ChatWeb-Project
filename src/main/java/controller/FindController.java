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

@WebServlet("/find")
public class FindController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			request
			.getRequestDispatcher("/WEB-INF/view/find.jsp")
			.forward(request, response);
}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userEmail = request.getParameter("userEmail");
		String userName =request.getParameter("userName");
		
		UserDAO userDAO = new UserDAO();
		int result = userDAO.find(userEmail, userName);
		if (userEmail == null || userName == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'nullError'");
			script.println("</script>");
		}
		else if(result == 0) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'nullError'");
			script.println("</script>");
		}
		else if(result == 1){
			session.setAttribute("userName", userName);
			session.setAttribute("userEmail", userEmail);
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'getID'");
			script.println("</script>");
		}
	}
}
