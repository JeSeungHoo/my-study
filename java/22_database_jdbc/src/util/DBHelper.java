package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://192.168.1.113:3306/bigdata";
	private static final String USER = "bigdata";
	private static final String PASS = "12345";
	
	private DBHelper() {}
	
	private static Connection conn;
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL,USER,PASS);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Driver 등록 실패 | DB 연결실패");
			}
		}
		return conn;
	}
	// 가변형 인자열
	public static void close(AutoCloseable... closer) {
		for(AutoCloseable close : closer) {
			try {
				if(close != null) {
					close.close();
				}
			} catch (Exception e) {}
		}
	}
	
	
}









