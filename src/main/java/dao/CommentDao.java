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
import model.Comment;
import model.Post;
import model.User;

public class CommentDao {
	Connection conn=null;
	PreparedStatement ps =null;
	ResultSet rs=null;
	
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
	
	public boolean addComment(Comment comment) throws Exception {
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
			e.printStackTrace();
			
			return false;
		}
		try {
		conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
		
	}
	
	public void deleteComment(Integer idcmt) throws Exception{
		conn=new DBContext().getConnection();
		String query="exec [dbo].[sproc_deletecmt] ?";
		
		ps=conn.prepareStatement(query);
		ps.setInt(1, idcmt);
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
				String time=dateFormat(rs,4);
				Comment cmt = new Comment(rs.getInt(1),rs.getInt(2),rs.getString(3),time,rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
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
				String timeString= dateFormat(rs,4);
				Comment cmt = new Comment(rs.getInt(1),rs.getInt(2),rs.getString(3),timeString,rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
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
			String query="exec sproc_commmentofuser ?";
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, user.getIduser());
			rs=ps.executeQuery();
			List<Comment> list=new ArrayList<Comment>();
			while(rs.next()) {
				
				String time= dateFormat(rs,4);
				Comment cmt = new Comment(rs.getInt(1),rs.getInt(2),rs.getInt(3),time,rs.getString(5),rs.getString(6));
				list.add(cmt);
			}
			return list;
		} catch (Exception e) {
			e.getStackTrace();
		}
		try {
			conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		return null;
	}
	
	
	public boolean checklikedcmt(User user, Comment cmt) throws Exception {
		try {
			String query="select*from likecmt where id_user=? and id_comment=?";
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			
			ps.setInt(1, user.getIduser());
			ps.setInt(2, cmt.getIdcmt());
			rs=ps.executeQuery();
			while(rs.next()) {				
				return true;
			}
			
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		try {
			conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		return false;
	}
	
	public void likecmt(int iduser,int idcmt,String time) throws Exception {
		try {
			String query="insert into likecmt values(?,?,?)";
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, iduser);
			ps.setInt(2, idcmt);
			ps.setString(3, time);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		try {
			conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	
	public void unlikecmt(int iduser,int idcmt) throws Exception {
		String query="delete likecmt where id_user=? and id_comment=?";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, iduser);
			ps.setInt(2, idcmt);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	public int countlike(int idcmt) throws Exception {
		try {
			String query="select COUNT(id_user) from likecmt where id_comment=?";
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, idcmt);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
						
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		try {
			conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		return 0;
	}
}
