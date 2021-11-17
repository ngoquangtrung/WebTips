package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	private final String serverName="localhost";
	private final String dbName="WebSiteGame";
	private final String portNumber="1433";
	private final String instance="";
	private final String userID="sa";
	private final String passWord="matkhau";
	public Connection getConnection()throws Exception{
		String url="jdbc:sqlserver://"+serverName+":"+portNumber+"\\"+instance+";databasename="+dbName;
		if(instance==null||instance.trim().isEmpty()) {
			url="jdbc:sqlserver://"+serverName+":"+portNumber+";databasename="+dbName;
		}
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection(url,userID,passWord);		
	}

}
