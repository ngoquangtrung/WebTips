package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import context.DBContext;
import model.Post;
import model.User;

public class ListPostDao {	
	
	private Connection conn=null;
	private PreparedStatement ps =null;
	private ResultSet rs=null;
	private Date date=null;	
	
	public static String dateFormat(ResultSet rs,int index) {
		try {
			Date date = new Date(rs.getTimestamp(index).getTime());
			Format formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			String timeString=formatter.format(date);
			return timeString;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Post> searchPost(String character)throws Exception{
		try {
			String query="exec sproc_searchpost ?";
			conn =new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, character);	
			rs=ps.executeQuery();
			List<Post> list=new ArrayList<Post>();
			while(rs.next()) {
				String time=dateFormat(rs,8);				
				Post post=new Post(rs.getInt(1),rs.getString(9),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),time);
				list.add(post);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
		
	}
	
	public Post loadLatest() throws Exception {
		try {
			String query ="select top(1) * from post order by id_post desc" ;
			conn =new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				String time=dateFormat(rs,8);
				Post post=new Post(rs.getInt(1),rs.getString(9),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),time);
				return post;
			}
		} catch (Exception e) {
			e.printStackTrace();
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
				String time=dateFormat(rs,8);
				Post post=new Post(rs.getInt(1),rs.getString(9),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),time);
				return post;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Post> loadPostItem(int index,int range) throws Exception{
		try {
			
			String query="select * from post except select* from post where status_post=0 order by time_post desc offset ? rows fetch next ? rows only";
			conn =new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, index);
			ps.setInt(2, range);
			rs=ps.executeQuery();
			List<Post> list=new ArrayList<Post>();
			while(rs.next()) {
				String time=dateFormat(rs,8);
				Post post=new Post(rs.getInt(1),rs.getString(9),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),time);
				list.add(post);
			}
			
			return list;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Post> loadPostUser(User user) throws Exception{
		try {
			int id =user.getIduser();
			List<Post> list=new ArrayList<>();
			String query="select * from post where id_user=? except select* from post where status_post=0 order by time_post desc";
			conn =new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				String time=dateFormat(rs,8);
				
				Post post=new Post(rs.getInt(1),rs.getString(9),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),time);
				list.add(post);
				
			}
			return list;
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Post> loadCategory(int idcategory)throws Exception{
		try {
			String query="select * from post where id_category= ? except select* from post where status_post=0 order by time_post desc";
			conn =new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, idcategory);
			rs=ps.executeQuery();
			List<Post> list=new ArrayList<Post>();
			while(rs.next()) {
				String time=dateFormat(rs,8);
				Post post=new Post(rs.getInt(1),rs.getString(9),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),time);
				list.add(post);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
		
	}
	
	public void addPost(Post post) throws Exception{
		try {
		String title=post.getTitle();
		String src=post.getSrc();
		String summary=post.getSummary();
		String content=post.getContent();
		int status=post.getStatus();
		int iduser=post.getId_user();
		int idcategory=post.getId_category();
		String time=post.getTime();
		
		
		String query="exec [dbo].[sproc_addpost] ?,?,?,?,?,?,?,?";
		//String query="insert into post(title,src_img,summary,content_post,status_post,id_user,id_category,time_post) values(N?,?,?,N'?',?,?,?,?)" ;
				
		conn=new DBContext().getConnection();
		ps=conn.prepareStatement(query);
		ps.setString(1,title);
		ps.setString(2,src);
		ps.setString(3,summary);
		ps.setString(4,content);
		ps.setInt(5,status);
		ps.setInt(6,iduser);
		ps.setInt(7,idcategory);
		ps.setString(8,time);
		
		ps.executeUpdate();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	
	
	
	public void updatePost(Post post) throws Exception {
		try {
			int id_post=post.getId_post();
			String title=post.getTitle();
			String summary=post.getSummary();
			String src_image=post.getSrc();
			int status=post.getStatus();
			int category=post.getId_category();
			
		String query="exec sproc_updatePost ?,?,?,?,?,?";
		conn= new DBContext().getConnection();
		ps=conn.prepareStatement(query);
		ps.setInt(1, id_post);
		ps.setString(2, src_image);
		ps.setString(3,summary);
		ps.setInt(4, status);
		ps.setInt(5, category);
		ps.setString(6, title);
		ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Post> loadPostofStatus(User user, int status)  throws Exception{
		
		try {
			
			String query="select*from post where id_user=? and status_post=? order by id_post desc";
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, user.getIduser());
			ps.setInt(2, status);
			rs=ps.executeQuery();
			List<Post> list=new ArrayList<Post>();
			while(rs.next()) {
				
				date=rs.getDate(8);
				Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String timeString =formatter.format(date);
				
				Post post=new Post(rs.getInt(1),rs.getString(9),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),timeString);
				list.add(post);
			}
			return list;
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
		
		
		
		
		return null;
	}
	
	public void deletePost(int idpost) {
		try {
			//int id=post.getId_post();
			String query="exec sproc_deletepost ?";
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, idpost);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<Post> loadeRequestPost() throws Exception {
		try {
			String query="select*from post where status_post=2 order by time_post desc";
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			List<Post> list=new ArrayList<Post>();
			while(rs.next()) {
				
//				date=rs.getDate(8);
				date = new Date(rs.getTimestamp(8).getTime());
				Format formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
				String timeString=formatter.format(date);
				
				Post post=new Post(rs.getInt(1),rs.getString(9),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),timeString);
				list.add(post);
			}
			return list;
			
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
		return null;
	}

}
