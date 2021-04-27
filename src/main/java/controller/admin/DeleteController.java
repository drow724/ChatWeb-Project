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

@WebServlet("/admin/delete")
public class DeleteController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href ="+"'board?id="+boardID+"'");
				script.println("</script>");
		}
	}
}
