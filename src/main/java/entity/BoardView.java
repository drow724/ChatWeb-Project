package entity;

import java.util.Date;

public class BoardView extends Board {
	
	private int cmtCount;

	public int getCmtCount() {
		return cmtCount;
	}

	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}

	public BoardView() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardView(int boardID, String boardTitle, String userID, String boardDate, int boardHit, String boardFiles, int cmtCount) {
		super(boardID, boardTitle, userID, "", boardDate, boardHit, boardFiles);
		this.cmtCount = cmtCount;
	}

}
