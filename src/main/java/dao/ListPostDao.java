package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Post;
import model.User;

public class ListPostDao {	
	
	private Connection conn=null;
	private PreparedStatement ps =null;
	private ResultSet rs=null;
	
	public List<Post> searchPost(String character)throws Exception{
		try {
			String query="select * from post where title like '%"+character+"%' order by time_post desc";
			conn =new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			List<Post> list=new ArrayList<Post>();
			while(rs.next()) {
				Post post=new Post(rs.getInt(1),rs.getString(9),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8));
				list.add(post);
			}
			
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;		
		
	}
	
	public Post loadLatest() throws Exception {
		try {
			String query ="select top(1) form post order by id desc";
			conn =new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				Post post=new Post(rs.getInt(1),rs.getString(9),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8));
				return post;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public Post loadPostWithID(int idpost) throws Exception {
		try {
			String query ="select*from post where id_post=?";
			conn =new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, idpost);
			rs=ps.executeQuery();
			while(rs.next()) {
				Post post=new Post(rs.getInt(1),rs.getString(9),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8));
				return post;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public List<Post> loadPostItem(int index) throws Exception{
		try {
			
			String query="select * from post order by time_post desc offset ? rows fetch next 5 rows only";
			conn =new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, index);
			rs=ps.executeQuery();
			List<Post> list=new ArrayList<Post>();
			while(rs.next()) {
				Post post=new Post(rs.getInt(1),rs.getString(9),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8));
				list.add(post);
			}
			
			return list;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public List<Post> loadPostUser(User user) throws Exception{
		try {
			int id =user.getIduser();
			List<Post> list=new ArrayList<>();
			String query="select * from post where id_user=?";
			conn =new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Post post=new Post(rs.getInt(1),rs.getString(9),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8));
				list.add(post);
			}
			return list;
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void addPost(Post post) {
		try {
		String name=post.getTitle();
		String src=post.getSrc();
		String summary=post.getSummary();
		String content=post.getContent();
		int status=post.getStatus();
		int iduser=post.getId_user();
		int idcategory=post.getId_category();
		String time=post.getTime();
		
		
		String query="exec [dbo].[sproc_addpost] ?,?,?,?,?,?,?,?";
		
		conn=new DBContext().getConnection();
		ps=conn.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2,src);
		ps.setString(3,summary);
		ps.setString(4,content);
		ps.setInt(5,status);
		ps.setInt(6,iduser);
		ps.setInt(7,idcategory);
		ps.setString(8,time);
		
		ps.executeUpdate();
		
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deletePost(Post post) {
		try {
			int id=post.getId_post();
			String query="exec sproc_deletepost ?";
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
