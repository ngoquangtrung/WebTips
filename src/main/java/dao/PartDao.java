package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Post;
import model.PostPart;

public class PartDao {
	Connection conn=null;
	PreparedStatement ps =null;
	ResultSet rs=null;
	
	
	public List<PostPart> loadPart(Post post) throws Exception{
		try {
			int id_post=post.getId_post();
		String query="select*from post_detail where id_post=? order by id_part asc";
		conn= new DBContext().getConnection();
		ps=conn.prepareStatement(query);
		ps.setInt(1, id_post);		
		rs=ps.executeQuery();
		List<PostPart> list=new ArrayList<>();
		while(rs.next()) {
			PostPart part=new PostPart(rs.getInt(2),rs.getInt(1),rs.getString(3),rs.getString(4),rs.getString(5));
			list.add(part);
		}
		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void addPart(Post post,PostPart part) throws Exception{
		try {
			int id_post=post.getId_post();
			String src=part.getSrc_image();
			String title=part.getTitle();
			String content=part.getContent();
			String query="insert into post_detail(id_post,src_image,title_part,content_part) values (?,?,?,?)";
			conn= new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			
			ps.setInt(1, id_post);
			ps.setString(2, src);
			ps.setString(3, title);
			ps.setString(4, content);
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
	
	
}
