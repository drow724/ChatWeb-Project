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
import service.WriteService;

@WebServlet("/board")
public class BoardController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String userID = null;
		if(session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
		if(userID == null) {
			request
			.getRequestDispatcher("/WEB-INF/view/index.jsp")
			.forward(request, response);
		}else {
			int pageNumber = 1;
			if(request.getParameter("pageNumber") != null) {
				pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
			}
			
			WriteService service = new WriteService();
			ArrayList<Board> list = service.getList(pageNumber);
			int nextPage = service.nextPage(pageNumber + 1);
			
			request.setAttribute("list", list);
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("nextPage", nextPage);
			
			request.getRequestDispatcher("/WEB-INF/view/board.jsp")
			.forward(request, response);
			
		}	
		
	}
}
