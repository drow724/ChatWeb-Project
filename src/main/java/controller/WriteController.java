package controller;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/write")
public class WriteController extends HttpServlet {

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
		request
		.getRequestDispatcher("/WEB-INF/view/write.jsp")
		.forward(request, response);
	}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String boardTitle = request.getParameter("boardTitle");
		
		String userID = (String) session.getAttribute("userID");
		String boardContent =request.getParameter("boardContent");
		//String boardFiles = request.getParameter("boardFiles");
		
//		Board board = new Board();
//		board.setBoardTitle(boardTitle);
//		board.setBoardContent(boardContent);
		
		if (boardTitle == null || boardContent == null) {
			System.out.println(boardTitle);
			System.out.println(boardContent);
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'writeNullError'");
			script.println("</script>");
		}else {
			WriteService writeService = new WriteService();
			int result = writeService.write(boardTitle, userID, boardContent);
			if (result == -1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'writeError'");
				script.println("</script>");
			}
			else {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'board'");
				script.println("</script>");
			}
		}
	}
}
