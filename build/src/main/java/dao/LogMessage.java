package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;

public class LogMessage {
	Connection conn=null;
	PreparedStatement ps =null;
	ResultSet rs=null;
	
	
	public boolean clientLogMessage(int iduser, String message,String time) throws Exception{
		try {
			String query="insert into [dbo].[log](id_user,time_log,logmessage) values(?,?,?) ";
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, iduser);
			ps.setString(2, time);
			ps.setString(3, message);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
			// TODO: handle exception
		}
	}
}
