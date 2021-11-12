package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.User;

public class UserDao {
	static Connection conn=null;
	static PreparedStatement ps =null;
	static ResultSet rs=null;
	
	public void addUser(User user) throws Exception{
		try {
			
		String query="exec dbo.sproc_adduser ?,?,?,?,?,?,?";	
		//String query="insert into [dbo].[user](name_user,email,pass,gender,birthday,time_up,permission,status_user) values(?,?,?,?,?,?,?,?)"; 
		conn=new DBContext().getConnection();
		ps=conn.prepareStatement(query);
		ps.setString(1,user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPass());
		ps.setInt(4, user.getGender());
		ps.setString(5,user.getBirthday());
		ps.setString(6,user.getTimeup());
		ps.setInt(7,user.getPermission());
		//ps.setInt(8,status);
		ps.executeUpdate();
		
		
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	public void deleteUser(int id,int status) {
		
		try {
			String query="exec sproc_activeUser ?,?";
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, status);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	
	public void uptoAdmin(int iduser) {
		try {
			String query="update [dbo].[user] set permission=1 where id_user=?";
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, iduser);
			ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	public User checkUser(String email,String pass) throws Exception{
		try {
			conn=new DBContext().getConnection();
			String query="select*from [dbo].[user] where email=? and pass=?";
			ps=conn.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2,pass);
			rs=ps.executeQuery();			
			while(rs.next()) {
				User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getString(10));
				return user;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return null;		
	}
	
	public User existUser(String email) throws Exception{
		try {
			conn=new DBContext().getConnection();
			String query="select*from [dbo].[user] where email=?";
			ps=conn.prepareStatement(query);
			ps.setString(1,email);
			rs=ps.executeQuery();		
			while(rs.next()) {
				User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getString(10));
				return user;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return null;
	}
	
	public void updateUser(User user) throws Exception{
		try {
			String query="exec sproc_updateUser ?,?,?,?,?,?,?,?";
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, user.getIduser());
			ps.setString(3, user.getEmail());
			ps.setString(2,user.getName() );
			ps.setString(4,user.getPass());
			ps.setInt(5,user.getGender());
			ps.setString(6, user.getBirthday());
			ps.setInt(7, user.getPermission());
			ps.setInt(8, user.getStatus());
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	public List<User> selectUserStatus(int status) throws Exception {
		try {
			String query="select* from [dbo].[user] where status_user=? ";
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, status);
			rs=ps.executeQuery();
			List<User> list= new ArrayList<>();
			while(rs.next()) {
				User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getString(10));
				list.add(user);
			}
			return list;
			
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	

}
