package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Comment;
import model.Post;
import model.User;

public class CommentDao {
	Connection conn=null;
	PreparedStatement ps =null;
	ResultSet rs=null;
	
	public void addComment(Comment comment) throws Exception {
		try {
			conn=new DBContext().getConnection();
			String query="exec [dbo].[sproc_addcmt] ?,?,?,?,?";
			ps=conn.prepareStatement(query);
			ps.setInt(1, comment.getIduser());
			ps.setInt(2, comment.getIdpost());
			ps.setString(3, comment.getContent());
			ps.setString(4,comment.getDate());
			if(comment.getIdrep() != null) {
				ps.setInt(5, comment.getIdrep() );
			} else {
				ps.setObject(5, null);
			}
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
		conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public void deleteComment(Comment comment) throws Exception{
		conn=new DBContext().getConnection();
		String query="exec [dbo].[sproc_deletecmt] ?,?";
		
		ps=conn.prepareStatement(query);
		ps.setInt(1, comment.getIduser());
		ps.setInt(2, comment.getIdpost());
		ps.executeUpdate();
		
	}

	public List<Comment> listComment(Post post)throws Exception{
		try {
			conn= new DBContext().getConnection();
			String query="exec sproc_selectComment ?";
			ps=conn.prepareStatement(query);
			ps.setInt(1,post.getId_post());
			rs=ps.executeQuery();
			List<Comment> list=new ArrayList<Comment>();
			while(rs.next()) {
				Comment cmt = new Comment(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
				list.add(cmt);
			}
			return list;
		} catch (Exception e) {
			e.getStackTrace();
		}try {
			conn.close();
		} catch (Exception e) {
			e.getStackTrace();
		}		
		return null;
		
		
	}
	
	
	public List<Comment> listRepcmt(Post post) throws Exception{
		
		try {
			conn= new DBContext().getConnection();
			String query="exec sproc_selectRepcmt ?";
			ps=conn.prepareStatement(query);
			ps.setInt(1,post.getId_post());
			rs=ps.executeQuery();
			List<Comment> list=new ArrayList<Comment>();
			while(rs.next()) {
				Comment cmt = new Comment(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
				list.add(cmt);
			}
			return list;
		} catch (Exception e) {
			e.getStackTrace();
		}try {
			conn.close();
		} catch (Exception e) {
			e.getStackTrace();
		}		
		return null;	
	}
	
	public List<Comment> listCmtofUser(User user) throws Exception{
		try {
			String query="select*from commentinfo where id_user=?";
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, user.getIduser());
			List<Comment> list=new ArrayList<Comment>();
			rs=ps.executeQuery();
			while(rs.next()) {
				Comment cmt = new Comment(rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(user.getName()),rs.getInt(7),rs.getInt(1));
				list.add(cmt);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
	
	
}
