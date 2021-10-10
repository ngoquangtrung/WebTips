package model;

public class Comment {
	private int iduser;
	private int idpost;
	private String content;
	private String date;
	private int status;
	
	public Comment() {}
	public Comment(int idu,int idp,String content, String date,int status) {
		this.iduser=idu;
		this.idpost=idp;
		this.content=content;
		this.date=date;
		this.status=status;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public int getIdpost() {
		return idpost;
	}
	public void setIdpost(int idpost) {
		this.idpost = idpost;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
