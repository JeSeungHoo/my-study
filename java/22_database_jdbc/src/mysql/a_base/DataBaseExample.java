package mysql.a_base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseExample {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url ="jdbc:mysql://localhost:3306/bigdata";
			String username = "bigdata";
			String password = "12345";
			Class.forName(driver);
			System.out.println("Driver Class Load 완료");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Class를 찾을 수 없음");
		} catch (SQLException e) {
			System.out.println("DB 연결 정보가 잘못되었습니다.");
		} finally {
			try {
				if(conn != null)conn.close();
			} catch (SQLException e) {}
		}
	}
}






