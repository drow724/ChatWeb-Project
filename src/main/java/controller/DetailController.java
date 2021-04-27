package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Board;
import entity.Comment;
import service.WriteService;

@WebServlet("/detail")
public class DetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   int boardId = Integer.parseInt(request.getParameter("id"));
		   WriteService service = new WriteService();
		   Board board = service.getBoard(boardId);
		   ArrayList<Comment> list = service.getCommentList(boardId);
		   
		   request.setAttribute("board", board);
		   request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/view/detail.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 int boardId = Integer.parseInt(request.getParameter("id"));
		   String commentContent = request.getParameter("detailContent");
		   HttpSession session = request.getSession();
		   String userID = (String) session.getAttribute("userID");
		   if(commentContent == null) {
			   PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'writeNullError'");
				script.println("</script>");
		   }else {
			   WriteService service = new WriteService();
			   int result = service.CommentWrite(commentContent, userID, boardId);
				if (result == -1) {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("location.href = 'writeError'");
					script.println("</script>");
				}
				else {
					PrintWriter script = response.getWriter();
				    script.println("<script>");
					script.println("location.href = "+"'detail?id="+boardId+"'");
					script.println("</script>");
				}
		   }
	}
}
