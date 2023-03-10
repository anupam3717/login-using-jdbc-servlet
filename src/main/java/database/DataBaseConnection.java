package database;
import java.sql.*;

import loginBean.LoginBean;
public class DataBaseConnection {
	private String dbUrl = "jdbc:mysql://localhost:3306/login";
	private String dbUname = "root";
	private String dbPassword = "Angular";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	private Connection con;
	
	public  Connection createConnection() throws Exception{
		
		Class.forName(dbDriver);
		 con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		return con;
		
		
	}
	
	public boolean validate(LoginBean loginBean)throws Exception
	{
		boolean status = false;
		String sql = "select * from User where userid = ? and passward =?";
		PreparedStatement ps;
		ps = con.prepareStatement(sql);
		ps.setString(1, loginBean.getUsername());
		ps.setString(2, loginBean.getPassword());
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		return status;
	}
	
}
