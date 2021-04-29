package controller.admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Notice;
import service.WriteService;

@WebServlet("/admin/noticeDetail")
public class NoticeDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("Admin") == "½ÂÀÎ") {
			int noticeID = Integer.parseInt(request.getParameter("id"));
			   WriteService service = new WriteService();
			   Notice notice = service.getNotice(noticeID);
			   
			   request.setAttribute("notice", notice);
				request.getRequestDispatcher("/WEB-INF/view/admin/noticeDetail.jsp").forward(request, response);
		} else {
			request
			.getRequestDispatcher("/WEB-INF/view/admin/index.jsp")
			.forward(request, response);
		}
		   
	}
}
