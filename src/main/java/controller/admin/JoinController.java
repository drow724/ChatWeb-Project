package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import entity.UserDAO;

@WebServlet("/admin/join")
public class JoinController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request
		.getRequestDispatcher("/WEB-INF/view/admin/join.jsp")
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
		HttpSession session = request.getSession();
		
		user.setUserID(userID);
		user.setUserPassword(userPassword);
		user.setUserName(userName);
		user.setUserGender(userGender);
		user.setUserEmail(userEmail);
		
		if (userID == null || userPassword == null || userName == null || userGender == null || userEmail == null ) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'joinError'");
			script.println("</script>");
		}else {
			UserDAO userDAO = new UserDAO();
			int result = userDAO.join(user);
			if (result == -1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'overlapError'");
				script.println("</script>");
			}
			else {
				session.setAttribute("userID", user.getUserID());
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'main'");
				script.println("</script>");
			}
		
		}
	}
}
