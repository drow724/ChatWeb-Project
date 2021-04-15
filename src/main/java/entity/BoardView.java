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
	
	public BoardView(int id, String title, Date regDate, String files, String writerId, String hit, boolean pub, int cmtCount) {
		super(id, title, regDate, "", files, writerId, hit, pub);
		this.cmtCount = cmtCount;
	}

}
