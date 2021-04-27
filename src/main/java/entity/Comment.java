package entity;

import java.util.Date;

public class Comment {
	
	private int commentID;
	private String commentContent;
	private String commentDate;
	private String userID;
	private int board_ID;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Comment(int commentID, String commentContent,  String commentDate,String userID, int board_ID) {

		this.commentID = commentID;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.userID = userID;
		this.board_ID = board_ID;
	}



	public int getCommentID() {
		return commentID;
	}



	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}



	public String getCommentContent() {
		return commentContent;
	}



	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}



	public String getCommentDate() {
		return commentDate;
	}



	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}



	public String getUserID() {
		return userID;
	}



	public void setUserID(String userID) {
		this.userID = userID;
	}



	public int getBoard_ID() {
		return board_ID;
	}



	public void setBoard_ID(int board_ID) {
		this.board_ID = board_ID;
	}

	
}
