package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Comment;
import model.Post;

public class CommentDao {
	Connection conn=null;
	PreparedStatement ps =null;
	ResultSet rs=null;
	
	public void addComment(Comment comment) throws Exception {
		try {
			conn=new DBContext().getConnection();
			String query="exec [dbo].[sproc_addcmt] ?,?,?,?";
			ps=conn.prepareStatement(query);
			ps.setInt(1, comment.getIduser());
			ps.setInt(2, comment.getIdpost());
			ps.setString(3, comment.getContent());
			ps.setString(4,comment.getDate());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
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
			String query="select*from comment where id_post= ?";
			ps=conn.prepareStatement(query);
			ps.setInt(1,post.getId_post());
			rs=ps.executeQuery();
			List<Comment> list=new ArrayList<Comment>();
			while(rs.next()) {
				Comment cmt=new Comment(rs.getInt(1),rs.getInt(2),rs.getString(4),rs.getString(3),rs.getInt(5));
				list.add(cmt);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}try {
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return null;
		
		
	}
}
