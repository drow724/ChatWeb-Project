package entity;

public class List {
	private int id;
	private String title;
	private String writerID;
	private String content;
	private String date;
	private int hit;
	private String file;
	
	public List() {

	}
	
	public List(int id, String title, String writerID, String content, String date, int hit, String file) {
		this.id = id;
		this.title = title;
		this.writerID = writerID;
		this.content = content;
		this.date = date;
		this.hit = hit;
		this.file = file;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriterID() {
		return writerID;
	}

	public void setWriterID(String writerID) {
		this.writerID = writerID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "List [id=" + id + ", title=" + title + ", writerID=" + writerID + ", content=" + content + ", date="
				+ date + ", hit=" + hit + ", file=" + file + "]";
	}
	
	
}
