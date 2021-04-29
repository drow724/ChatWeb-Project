package controller.admin;

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
import entity.User;
import entity.UserDAO;
import service.AdminService;
import service.WriteService;

@WebServlet("/admin/board")
public class BoardController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("Admin") == "½ÂÀÎ") {
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
			
			request.getRequestDispatcher("/WEB-INF/view/admin/board.jsp")
			.forward(request, response);
		} else {
			request
			.getRequestDispatcher("/WEB-INF/view/admin/index.jsp")
			.forward(request, response);
		}	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int boardID = Integer.parseInt(request.getParameter("id"));
		 
		 AdminService adminService = new AdminService();
		 int result = adminService.delete(boardID);
		 if (result == -1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'writeError'");
				script.println("</script>");
			}
			else {
				 request.getRequestDispatcher("/WEB-INF/view/admin/board.jsp")
					.forward(request, response);
			}
		
		
			}
}
