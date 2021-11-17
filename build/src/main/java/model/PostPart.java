package model;

public class PostPart {
	
	private int id_part;
	private int id_post;
	private String src_image;
	private String title;
	private String content;
	
	public PostPart() {};
	public PostPart(int id_part,int id_post,String src_image,String title, String content) {
		this.id_part=id_part;
		this.id_post=id_post;
		this.src_image=src_image;
		this.title=title;
		this.content=content;
	}
	public int getId_part() {
		return id_part;
	}
	public void setId_part(int id_part) {
		this.id_part = id_part;
	}
	public int getId_post() {
		return id_post;
	}
	public void setId_post(int id_post) {
		this.id_post = id_post;
	}
	public String getSrc_image() {
		return src_image;
	}
	public void setSrc_image(String src_image) {
		this.src_image = src_image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
