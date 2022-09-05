<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="checkAdmin.jsp" %>
<%@ page import="java.util.*, util.*, vo.*, java.sql.*" %>    
<!-- 회원목록     -->
<!-- memberList.jsp -->
<%
	// JNDI(Java Naming and Directory Interface)
	// context에서 제공하는 데이터 및 객체를 
	// 발견(discover) 하고 참고(lookup) 하기 위한 자바 API
	javax.naming.Context init
		= new javax.naming.InitialContext();
	javax.sql.DataSource ds
		= (javax.sql.DataSource)init.lookup("java:comp/env/java/MySqlDB");
	java.sql.Connection conn = ds.getConnection();
	System.out.println(conn);
	
	ArrayList<MemberVO> memberList = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try{
		stmt = conn.createStatement();
		String sql = "SELECT * FROM test_member"
					+" ORDER BY num DESC";
		rs = stmt.executeQuery(sql);
		memberList = new ArrayList<>();
		while(rs.next()){
			MemberVO m = new MemberVO();
			m.setNum(rs.getInt(1));
			m.setId(rs.getString(2));
			m.setPass(rs.getString(3));
			m.setName(rs.getString(4));
			m.setAddr(rs.getString(5));
			m.setPhone(rs.getString(6));
			m.setGender(rs.getString(7));
			m.setAge(rs.getInt(8));
			memberList.add(m);
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		DBCPUtil.close(rs,stmt,conn);
	}
%>
<table border="1">
	<tr>
		<th colspan="7"><h1>회원목록</h1></th>
	</tr>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>주소</th>
		<th>전화번호</th>
		<th>성별</th>
		<th>나이</th>
	</tr>
	<%for(MemberVO m : memberList){ %>
		<tr onclick="location.href='index.jsp?page=memberInfo&num=<%=m.getNum()%>';">
			<td><%=m.getNum()%></td>
			<td><%=m.getId()%></td>
			<td><%=m.getName()%></td>
			<td><%=m.getAddr()%></td>
			<td><%=m.getPhone()%></td>
			<td><%=m.getGender()%></td>
			<td><%=m.getAge()%></td>
		</tr>
	<%}%>
</table>














