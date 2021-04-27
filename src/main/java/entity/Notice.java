package entity;

import java.util.Date;

public class Notice {
	
	private int noticeID;
	private String noticeTitle;
	private String noticeDate;
	private String noticeContent;
	private int noticeAvailable;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	
	public Notice(int noticeID, String noticeTitle,  String noticeDate,String noticeContent, int noticeAvailable) {

		this.noticeID = noticeID;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.noticeContent = noticeContent;
		this.noticeAvailable = noticeAvailable;
	}

	public int getNoticeID() {
		return noticeID;
	}

	public void setNoticeID(int noticeID) {
		this.noticeID = noticeID;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public int getNoticeAvailable() {
		return noticeAvailable;
	}

	public void setNoticeAvailable(int noticeAvailable) {
		this.noticeAvailable = noticeAvailable;
	}

	
}
