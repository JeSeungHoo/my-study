<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
 <!-- conn.jsp -->
 <%
 	Connection conn = null;
 	
 	try{
 		Class.forName("com.mysql.cj.jdbc.Driver");
 		out.println("Driver class 로드 완료");
 		conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/bigdata",
			"bigdata",
			"12345"
		);
 		out.println("connection 생성 완료");
 	}catch(java.lang.ClassNotFoundException e){
 		out.println("Driver class를 찾지 못함");
 	}catch(SQLException e){
 		out.println("db 연결 정보 오류 : "+e.toString());
 	}
 %>
 
 
 
 
 
 
 
 
 