package mysql.a_base;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableExample {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bigdata";
		String user = "bigdata";
		String pass = "12345";
		
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println(conn);
			
			// call checkYear('userTbl 이름');
			String sql = "call checkYear(?)";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "이승기");
			rs = cstmt.executeQuery();
			if(rs.next()) {
				String result = rs.getString(1);
				System.out.println(result);
			}
			rs.close();
			cstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}






