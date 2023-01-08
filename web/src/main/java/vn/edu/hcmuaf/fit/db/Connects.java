package vn.edu.hcmuaf.fit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connects {

	public static Connection getConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
