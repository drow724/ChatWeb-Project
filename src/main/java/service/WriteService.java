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
import entity.User;

public class WriteService {
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
		String SQL = "SELECT boardID FROM BOARD ORDER BY boardID DESC";
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
	
	public int write(String boardTitle, String userID, String boardContent, String boardFiles) {
		
		String SQL = "INSERT INTO BOARD VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		String dbURL = "jdbc:mysql://localhost:3308/CHAT";
		String dbID = "root";
		String dbPassword = "0000";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, getNext());
			pstmt.setString(2, boardTitle);
			pstmt.setString(3, userID);
			pstmt.setString(4, boardContent);
			pstmt.setString(5, getDate());
			pstmt.setInt(6, 0);
			pstmt.setString(7, boardFiles);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	public ArrayList<Board> getList(int pageNumber){
		String SQL = "SELECT * FROM BOARD WHERE boardID < ? ORDER BY boardID DESC LIMIT 10;";
		
		String dbURL = "jdbc:mysql://localhost:3308/CHAT";
		String dbID = "root";
		String dbPassword = "0000";
		
		ArrayList<Board> list = new ArrayList<Board>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBoardID(rs.getInt(1));
				board.setBoardTitle(rs.getString(2));
				board.setUserID(rs.getString(3));
				board.setBoardContent(rs.getString(4));
				board.setBoardDate(rs.getString(5));
				board.setBoardHit(rs.getInt(6));
				board.setBoardFiles(rs.getString(7));
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; // 데이터베이스 오류
	}
	
	public int nextPage(int pageNumber) {
		String SQL = "SELECT * FROM BOARD WHERE boardID < ? ORDER BY boardID DESC LIMIT 10";
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
	
	public Board getBoard(int boardID) {
		String SQL = "SELECT * FROM BOARD WHERE boardID = ?;";
		String dbURL = "jdbc:mysql://localhost:3308/CHAT";
		String dbID = "root";
		String dbPassword = "0000";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, boardID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Board board = new Board();
				board.setBoardID(rs.getInt(1));
				board.setBoardTitle(rs.getString(2));
				board.setUserID(rs.getString(3));
				board.setBoardContent(rs.getString(4));
				board.setBoardDate(rs.getString(5));
				board.setBoardHit(rs.getInt(6));
				board.setBoardFiles(rs.getString(7));
				return board;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; // 데이터베이스 오류
	}
	public int CommentWrite(String CommentContent, String userID, int boardID) {
			
			String SQL = "INSERT INTO comment VALUES (?, ?, ?, ?, ?)";
			
			String dbURL = "jdbc:mysql://localhost:3308/CHAT";
			String dbID = "root";
			String dbPassword = "0000";
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				
				pstmt.setInt(1, getNext());
				pstmt.setString(2, CommentContent);
				pstmt.setString(3, getDate());
				pstmt.setString(4, userID);
				pstmt.setInt(5, boardID);
				
				return pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -1; // 데이터베이스 오류
		}
	
	public ArrayList<Comment> getCommentList(int boardId){
		String SQL = "SELECT * FROM COMMENT WHERE Board_ID = ? ORDER BY Board_ID DESC LIMIT 5;";
		
		String dbURL = "jdbc:mysql://localhost:3308/CHAT";
		String dbID = "root";
		String dbPassword = "0000";
		
		ArrayList<Comment> list = new ArrayList<Comment>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setCommentID(rs.getInt(1));
				comment.setCommentContent(rs.getString(2));
				comment.setCommentDate(rs.getString(3));
				comment.setUserID(rs.getString(4));
				comment.setBoard_ID(rs.getInt(5));
				list.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; // 데이터베이스 오류
	}
	
	public ArrayList<Notice> getNoticeList(int pageNumber){
		String SQL = "SELECT * FROM NOTICE WHERE noticeID < ? AND noticeAvailable = 1 ORDER BY noticeID DESC LIMIT 10;";
		
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
	
	public User getFind(String userEmail, String userName) {
		String SQL = "SELECT * FROM USER WHERE userEmail = ? and userName =?;";
		String dbURL = "jdbc:mysql://localhost:3308/CHAT";
		String dbID = "root";
		String dbPassword = "0000";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userEmail);
			pstmt.setString(2, userName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUserID(rs.getString(1));
				user.setUserPassword(rs.getString(2));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; // 데이터베이스 오류
	}
}

