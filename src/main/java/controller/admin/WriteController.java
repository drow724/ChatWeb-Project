package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;

import entity.Board;
import entity.User;
import entity.UserDAO;
import service.AdminService;
import service.WriteService;

@WebServlet("/admin/write")
public class WriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("Admin") == "½ÂÀÎ") {
			request.getRequestDispatcher("/WEB-INF/view/admin/write.jsp")
			.forward(request, response);

		} else {
			request
			.getRequestDispatcher("/WEB-INF/view/admin/index.jsp")
			.forward(request, response);
		}
		

}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String noticeTitle = request.getParameter("noticeTitle");
		String temp = request.getParameter("noticeAvailable");
		int noticeAvailable = 0;
		if(temp == null){
			temp = "0";
			noticeAvailable = Integer.parseInt(temp);
		}
		String noticeContent =request.getParameter("noticeContent");
		//String boardFiles = request.getParameter("boardFiles");
		
//		Board board = new Board();
//		board.setBoardTitle(boardTitle);
//		board.setBoardContent(boardContent);
		
		if (noticeTitle == null || noticeContent == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'writeNullError'");
			script.println("</script>");
		}else {
			AdminService adminService = new AdminService();
			int result = adminService.noticeWrite(noticeTitle, noticeAvailable, noticeContent);
			if (result == -1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'writeError'");
				script.println("</script>");
			}
			else {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'notice'");
				script.println("</script>");
			}
		}
	}
}
