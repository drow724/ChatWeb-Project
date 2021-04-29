package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Notice;
import service.WriteService;

@WebServlet("/noticeDetail")
public class NoticeDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   int noticeID = Integer.parseInt(request.getParameter("id"));
		   WriteService service = new WriteService();
		   Notice notice = service.getNotice(noticeID);
		   
		   request.setAttribute("notice", notice);
			request.getRequestDispatcher("/WEB-INF/view/noticeDetail.jsp").forward(request, response);
	}
}
