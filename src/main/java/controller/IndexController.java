package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

@WebServlet("/index")
public class IndexController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String userID = null;
		if(session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
			System.out.println(userID);
		}
		if(userID != null) {
			request
			.getRequestDispatcher("/WEB-INF/view/main.jsp")
			.forward(request, response);
		}
		else if(userID == null){
		request
		.getRequestDispatcher("/WEB-INF/view/index.jsp")
		.forward(request, response);
		}
	}	
}
