package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Board;
import entity.BoardView;
import entity.Comment;
import entity.Notice;

public class AdminService {
	private Connection conn;
	private ResultSet rs;
	
	public String getDate() {
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""; // 데이터베이스 오류
	}
	
	public int getNext() {
		String SQL = "SELECT noticeID FROM NOTICE ORDER BY noticeID DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1;// 첫 번째 게시물인 경우
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	public int delete(int boardID) {
		
		String SQL = "DELETE FROM BOARD WHERE boardID = ?;";
		
		String dbURL = "jdbc:mysql://localhost:3308/CHAT";
		String dbID = "root";
		String dbPassword = "0000";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,boardID);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	public int deleteNotice(int noticeID) {
		
		String SQL = "DELETE FROM NOTICE WHERE noticeID = ?;";
		
		String dbURL = "jdbc:mysql://localhost:3308/CHAT";
		String dbID = "root";
		String dbPassword = "0000";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,noticeID);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	public int changeNotice(int Password) {
		
		String SQL = "UPDATE NOTICE SET noticeAvailable = IF(noticeAvailable = 0, '1', '0') WHERE noticeID = ?;";

		String dbURL = "jdbc:mysql://localhost:3308/CHAT";
		String dbID = "root";
		String dbPassword = "0000";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,Password);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}

	public int changePw(int password) {
		
		String SQL = "UPDATE admin SET password = ?;";
		
		String dbURL = "jdbc:mysql://localhost:3308/CHAT";
		String dbID = "root";
		String dbPassword = "0000";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,password);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}

	public int noticeWrite(String noticeTitle, int noticeAvailable, String noticeContent) {
		
		String SQL = "INSERT INTO NOTICE VALUES (?, ?, ?, ?, ?)";
		
		String dbURL = "jdbc:mysql://localhost:3308/CHAT";
		String dbID = "root";
		String dbPassword = "0000";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, getNext());
			pstmt.setString(2, noticeTitle);
			pstmt.setString(3, getDate());
			pstmt.setString(4, noticeContent);
			pstmt.setInt(5, noticeAvailable);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	public ArrayList<Notice> getNoticeList(int pageNumber){
		String SQL = "SELECT * FROM NOTICE WHERE noticeID < ? ORDER BY noticeID DESC LIMIT 10;";
		
		String dbURL = "jdbc:mysql://localhost:3308/CHAT";
		String dbID = "root";
		String dbPassword = "0000";
		
		ArrayList<Notice> list = new ArrayList<Notice>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Notice notice = new Notice();
				notice.setNoticeID(rs.getInt(1));
				notice.setNoticeTitle(rs.getString(2));
				notice.setNoticeDate(rs.getString(3));
				notice.setNoticeContent(rs.getString(4));
				notice.setNoticeAvailable(rs.getInt(5));
				list.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; // 데이터베이스 오류
	}

	public Notice getNotice(int noticeID) {
		String SQL = "SELECT * FROM NOTICE WHERE noticeID = ?;";
		String dbURL = "jdbc:mysql://localhost:3308/CHAT";
		String dbID = "root";
		String dbPassword = "0000";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, noticeID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Notice notice = new Notice();
				notice.setNoticeID(rs.getInt(1));
				notice.setNoticeTitle(rs.getString(2));
				notice.setNoticeDate(rs.getString(3));
				notice.setNoticeContent(rs.getString(4));
				notice.setNoticeAvailable(rs.getInt(5));
				return notice;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; // 데이터베이스 오류
	}
	
	public int nextPage(int pageNumber) {
		String SQL = "SELECT * FROM NOTICE WHERE noticeID < ? ORDER BY noticeID DESC LIMIT 10";
		String dbURL = "jdbc:mysql://localhost:3308/CHAT";
		String dbID = "root";
		String dbPassword = "0000";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; // 데이터베이스 오류
	}
	
	public int adminLogin(int password) {
		String SQL = "SELECT password FROM ADMIN WHERE password = ?";
		String dbURL = "jdbc:mysql://localhost:3308/CHAT";
		String dbID = "root";
		String dbPassword = "0000";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if(rs.getInt(1) == password) {
					return 1;// 로그인 성공
				}
				else
					return 0; //비밀번호 불일치
			}
			return -1; //아이디 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // 데이터 베이스 오류
	}
}

