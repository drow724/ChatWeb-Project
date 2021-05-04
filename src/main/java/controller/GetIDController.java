package controller;

import java.io.IOException;
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
import service.WriteService;

@WebServlet("/getID")
public class GetIDController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String userEmail =(String) session.getAttribute("userEmail");
			String userName =(String) session.getAttribute("userName");
			WriteService writeService = new WriteService();
			User user = writeService.getFind(userEmail, userName);
			if(user ==  null) {
				request.getRequestDispatcher("/WEB-INF/view/error.jsp")
				.forward(request, response);
			}else {
				System.out.println(user);
				  request.setAttribute("user", user);
				request.getRequestDispatcher("/WEB-INF/view/getID.jsp")
				.forward(request, response);
			}
			
	}
}
