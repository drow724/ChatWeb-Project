package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import entity.Board;
import entity.User;
import entity.UserDAO;
import service.WriteService;
@MultipartConfig(
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*50,
		maxRequestSize = 1024*1024*50*5
		)
@WebServlet("/write")
public class WriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("userID") != null) {
			request
			.getRequestDispatcher("/WEB-INF/view/write.jsp")
			.forward(request, response);

		}else {
			request
			.getRequestDispatcher("/WEB-INF/view/index.jsp")
			.forward(request, response);
	}
}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String boardTitle = request.getParameter("boardTitle");
		
		String userID = (String) session.getAttribute("userID");
		String boardContent =request.getParameter("boardContent");
		
		Collection<Part> parts = request.getParts();
		StringBuilder builder = new StringBuilder();
		for(Part p : parts) {
			if(!p.getName().equals("boardFiles")) continue;
			if(p.getSize() == 0) continue;
			
			Part filePart = p;
			String fileName = filePart.getSubmittedFileName();
			builder.append(fileName);
			builder.append(",");
			
			InputStream fis = filePart.getInputStream();
			
			//"/upload/" -> "c:/temp/upload"
		
			String realPath = request.getServletContext().getRealPath("/upload");
			
			File path = new File(realPath);
			if(path.exists())
				path.mkdirs();
			
			String filePath = realPath + File.separator + fileName;
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1024];
			int size=0;
			
			while((size=fis.read(buf)) != -1) 
				fos.write(buf, 0, size);
				
			fos.close();
			fis.close();
		}
		
		builder.delete(builder.length()-1, builder.length());
		if (boardTitle == null || boardContent == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'writeNullError'");
			script.println("</script>");
		}else {
			WriteService writeService = new WriteService();
			int result = writeService.write(boardTitle, userID, boardContent, builder.toString());
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
