<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JNDI context -->
<%@ page import="javax.naming.*" %>
<!-- DBCP -->
<%@ page import="javax.sql.*" %>
<!-- JDBC -->
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jdbc/MySQLDBCP index.jsp</title>
</head>
<body>
	<!-- name = jdbc/MySQLDBCP -->
	<%
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup(
				"java:comp/env/jdbc/MySQLDBCP"
			);
			Connection conn = ds.getConnection();
			out.print("연결 완료 : " + conn);
		}catch(ClassNotFoundException e){
			out.print("Driver 클래스를 찾을 수 없음");
		}catch(NamingException e){
			out.print("jdbc/MySQLDBCP 찾을 수 없음");
		}catch(SQLException e){
			out.print("DB 연결 정보 오류");
		}
	%>
</body>
</html>













