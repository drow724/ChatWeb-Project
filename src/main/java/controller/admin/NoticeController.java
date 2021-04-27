package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Board;
import entity.Notice;
import service.WriteService;

@WebServlet("/admin/notice")
public class NoticeController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			int pageNumber = 1;
			if(request.getParameter("pageNumber") != null) {
				pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
			}
			
			WriteService service = new WriteService();
			ArrayList<Notice> list = service.getNoticeList(pageNumber);
			int nextPage = service.nextPage(pageNumber + 1);
			
			request.setAttribute("list", list);
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("nextPage", nextPage);
			
			request.getRequestDispatcher("/WEB-INF/view/admin/notice.jsp")
			.forward(request, response);
		
	}
}
