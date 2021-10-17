package model;

public class Post {

	private int id_post;
	private String title;
	private String src;
	private String summary;
	private String content;
	private int status;
	private int id_user;
	private int id_category;
	private String time;
	public Post() {}
	public Post(int idp,String title,String src,String summary,String content,int status,int idu,int idc,String time) {
		this.id_post=idp;
		this.title=title;
		this.src=src;
		this.summary=summary;
		this.content=content;
		this.status=status;
		this.id_user=idu;
		this.id_category=idc;
		this.time=time;
	}
	public int getId_post() {
		return id_post;
	}
	public void setId_post(int id_post) {
		this.id_post = id_post;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String name) {
		this.title = name;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
