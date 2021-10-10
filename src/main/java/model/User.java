package model;

public class User {
	
	private int iduser;
	private String name;
	private String email;
	private String pass;
	private int gender;
	private String birthday;
	private String timeup;
	private int permission;
	private int status;
	
	
	public User() {}
	public User(int id,String name,String email,String pass,int gender,String bd,String time,int permission,int status) {
	this.iduser=id;
	this.name=name;
	this.email=email;
	this.pass=pass;
	this.gender=gender;
	this.birthday=bd;
	this.timeup=time;
	this.permission=permission;
	this.status=status;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTimeup() {
		return timeup;
	}
	public void setTimeup(String timeup) {
		this.timeup = timeup;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
