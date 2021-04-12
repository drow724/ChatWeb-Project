package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import entity.UserDAO;

@WebServlet("/join")
public class JoinController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request
		.getRequestDispatcher("/WEB-INF/view/join.jsp")
		.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String userPassword =request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		String userGender =request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		
		User user = new User();
		
		user.setUserID(userID);
		user.setUserPassword(userPassword);
		user.setUserName(userName);
		user.setUserGender(userGender);
		user.setUserEmail(userEmail);
		
		if (userID == null || userPassword == null || userName == null || userGender == null || userEmail == null ) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'regerror.jsp'");
			script.println("</script>");
		}else {
			UserDAO userDAO = new UserDAO();
			int result = userDAO.join(user);
			if (result == 1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'main.jsp'");
				script.println("</script>");
		}
		
		}
	}
}
