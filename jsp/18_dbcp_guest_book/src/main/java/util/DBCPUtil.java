package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBCPUtil {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			DataSource ds
			= (DataSource)new InitialContext().lookup(
				"java:comp/env/jdbc/MySQLDBCP"
			);
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println("DBCP 이름 정보를 찾을 수 없음");
		} catch (SQLException e) {
			System.out.println("Connection 생성 연결 정보를 찾을 수 없음");
		}
		return conn;
	}
	// JDBC 자원 해제
	public static void close(AutoCloseable... closer) {
		for(int i=0; i<closer.length; i++) {
			if(closer[i] != null) {
				try {
					closer[i].close();
				} catch (Exception e) {}
			}
		}
	}
}




