package model;

import java.io.Serializable;

public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idcmt;
	private int iduser;
	private int idpost;
	private String content;
	private String date;
	private int status;
	private String nameuser;
	private Integer idrep;
	
	public Comment() {}
	public Comment(int idu,int idp,String content, String date,int status,String nameuser,Integer idrep,int idcmt) {
		this.iduser=idu;
		this.idpost=idp;
		this.content=content;
		this.date=date;
		this.status=status;
		this.nameuser=nameuser;
		this.idrep=idrep;
		this.idcmt=idcmt;
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
	public String getNameuser() {
		return nameuser;
	}
	public void setNameuser(String nameuser) {
		this.nameuser = nameuser;
	}
	
	public Integer getIdrep() {
		return idrep;
	}
	public void setIdrep(Integer idrep) {
		this.idrep = idrep;
	}
	public int getIdcmt() {
		return idcmt;
	}
	public void setIdcmt(int idcmt) {
		this.idcmt = idcmt;
	}
	
}
