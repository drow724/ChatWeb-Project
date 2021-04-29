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
import service.AdminService;
import service.WriteService;

@WebServlet("/admin/notice")
public class NoticeController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("Admin") == "½ÂÀÎ") {
			int pageNumber = 1;
			if(request.getParameter("pageNumber") != null) {
				pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
			}
			
			AdminService adminService = new AdminService();
			ArrayList<Notice> list = adminService.getNoticeList(pageNumber);
			int nextPage = adminService.nextPage(pageNumber + 1);
			
			request.setAttribute("list", list);
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("nextPage", nextPage);
			
			request.getRequestDispatcher("/WEB-INF/view/admin/notice.jsp")
			.forward(request, response);
		
		} else {
			request
			.getRequestDispatcher("/WEB-INF/view/admin/index.jsp")
			.forward(request, response);
		}
			
	}
}
