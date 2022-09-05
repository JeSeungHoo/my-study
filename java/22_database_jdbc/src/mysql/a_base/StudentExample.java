package mysql.a_base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentExample {

	public static void main(String[] args) {
		// 사용자에게 학생이름, 학과, 학년 정보를 입력받아
		// Statement 객체를 이용하여 student table에
		// 학생에 정보를 저장하는 코드를 작성
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bigdata";
		String user = "bigdata";
		String pass = "12345";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("이름을 입력해주세요>");
			String name = sc.next();
			System.out.println("학과를 입력해주세요>");
			String dept = sc.next();
			System.out.println("학년을 입력해주세요>");
			int grade = sc.nextInt();
			String sql = "INSERT INTO student(stuName,stuDept,stuGrade) "
						+" VALUES('"+name+"','"+dept+"',"+grade+")";
			System.out.println(sql);
			int result = stmt.executeUpdate(sql);
			System.out.println(result+"명의 학생정보가 추가되었습니다.");
			
			sql = "UPDATE student SET stuDept='컴퓨터공학' "
				+ "WHERE stuName = '최기근' ";
			result = stmt.executeUpdate(sql);
			System.out.println(result+"명의 정보가 수정되었습니다.");
			
			sql = "DELETE FROM student";
			result = stmt.executeUpdate(sql);
			System.out.println(result+"명의 정보가 삭제되었습니다.");
			
			sql = "SELECT count(*) FROM student";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				int count = rs.getInt(1);
				System.out.println("남은 학생 수는 : "+count);
			}
			sc.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {}
		}
	}

}




