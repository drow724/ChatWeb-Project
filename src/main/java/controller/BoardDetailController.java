package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Board;
import service.WriteService;

@WebServlet("/notice/detail")
public class BoardDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   int boardId = Integer.parseInt(request.getParameter("BoardId"));
	
		   WriteService service = new WriteService();
		   Board board = service.getBoard(boardId);
		   request.setAttribute("b", board);
		   
			request.getRequestDispatcher("/WEB-INF/view/notice/boardDetail.jsp").forward(request, response);
	}
}
