package entity;

import java.util.Date;

public class Board {
	
	private int boardID;
	private String boardTitle;
	private String userID;
	private String boardContent;
	private String boardDate;
	private int boardHit;
	private String boardFiles;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Board(int boardID, String boardTitle,  String userID,String boardContent, String boardDate, int boardHit, String boardFiles) {

		this.boardID = boardID;
		this.boardTitle = boardTitle;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
		this.boardFiles = boardFiles;
		this.userID = userID;
		this.boardHit = boardHit;
	}

	public int getBoardID() {
		return boardID;
	}



	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}



	public String getBoardTitle() {
		return boardTitle;
	}



	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}



	public String getUserID() {
		return userID;
	}



	public void setUserID(String userID) {
		this.userID = userID;
	}



	public String getBoardContent() {
		return boardContent;
	}



	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}



	public String getBoardDate() {
		return boardDate;
	}



	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}



	public int getBoardHit() {
		return boardHit;
	}



	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}



	public String getBoardFiles() {
		return boardFiles;
	}



	public void setBoardFiles(String boardFiles) {
		this.boardFiles = boardFiles;
	}



	@Override
	public String toString() {
		return "Board [boardID=" + boardID + ", boardTitle=" + boardTitle + ", userID=" + userID + ", boardContent="
				+ boardContent + ", boardDate=" + boardDate + ", boardHit=" + boardHit + ", boardFiles=" + boardFiles
				+ "]";
	}
	
}
