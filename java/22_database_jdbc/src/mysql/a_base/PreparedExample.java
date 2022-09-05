package mysql.a_base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedExample {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bigdata";
		String user = "bigdata";
		String pass = "12345";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		// alt + s + w
		try {
			Class.forName(driver);
			System.out.println("DRIVER 로드 완료");
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("DB 연결 완료");
			// 동적쿼리 - PreparedStatement
			// 쿼리가 먼저 등록되어 있어야함.
			sql = "INSERT INTO student(stuName,stuDept,stuGrade) "
				+ " VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "최기근");
			pstmt.setInt(3, 4);
			pstmt.setString(2, "Developers");
			
			int result = pstmt.executeUpdate();
			System.out.println(result+"명의 정보 추가");
			
			pstmt.close();
			
			sql = "SELECT * FROM student WHERE stuNo = ?";
			Scanner sc = new Scanner(System.in);
			System.out.println("검색할 학생의 번호를 입력하세요.");
			int no = sc.nextInt();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String stuName = rs.getString("stuName");
				String stuDept = rs.getString("stuDept");
				int stuGrade = rs.getInt("stuGrade");
				String stuClass = rs.getString("stuClass");
				char stuGender = rs.getString("stuGender").charAt(0);
				java.util.Date stuDate = rs.getTimestamp("stuDate");
				System.out.println(
					stuName+"-"+stuDept+"-"+stuGrade+"-"+stuClass
					+"-"+stuGender+"-"+stuDate
				);
			}else {
				System.out.println(no+"번 학생정보가 존재하지 않습니다.");
			}
			
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}
