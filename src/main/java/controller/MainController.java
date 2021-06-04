package controller;

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

@WebServlet("/main")
public class MainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userID = null;
		if(session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
			UserDAO userDAO = new UserDAO();
			String userName = userDAO.FindName(userID);
			request.setAttribute("userName", userName);
			request
			.getRequestDispatcher("/WEB-INF/view/main.jsp")
			.forward(request, response);
					
		}else {
			
		request
		.getRequestDispatcher("/WEB-INF/view/index.jsp")
		.forward(request, response);
		}
	}

}
