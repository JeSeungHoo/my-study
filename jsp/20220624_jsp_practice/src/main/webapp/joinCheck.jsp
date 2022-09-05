<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, util.*" %>
<!-- joinCheck.jsp -->
<%
	request.setCharacterEncoding("utf-8");
	/*
	vo.MemberVO joinMember	
		= (vo.MemberVO)pageContext.getAttribute("joinMember");
	if(joinMember == null){
		joinMember = new vo.MemberVO();
		pageContext.setAttribute("joinMember",joinMember);
	}
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String phone = request.getParameter("phone");
	String gender = request.getParameter("gender");
	String strAge = request.getParameter("age");
	int age = Integer.parseInt(strAge);
	joinMember.setId(id);
	joinMember.setPass(pass);
	joinMember.setName(name);
	joinMember.setAddr(addr);
	joinMember.setPhone(phone);
	joinMember.setGender(gender);
	joinMember.setAge(age);
	*/
%>
<jsp:useBean id="joinMember" class="vo.MemberVO" scope="page" />
<jsp:setProperty name="joinMember" property="*"/>
<%= joinMember %>

<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String msg = "";
	String nextPage = "";
	
	try{
		conn = JDBCUtil.getConnection();
		String sql = "SELECT id FROM test_member WHERE id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, joinMember.getId());
		rs = pstmt.executeQuery();
		if(rs.next()){
			// 아이디 값 존재
			msg = "이미 존재하는 아이디 입니다.";
			nextPage = "join";
		}else{
			// 동일한 아이디 존재하지 않음
			if(pstmt != null) pstmt.close();
			sql = "INSERT INTO test_member VALUES(null,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,joinMember.getId());
			pstmt.setString(2,joinMember.getPass());
			pstmt.setString(3,joinMember.getName());
			pstmt.setString(4,joinMember.getAddr());
			pstmt.setString(5,joinMember.getPhone());
			pstmt.setString(6,joinMember.getGender());
			pstmt.setInt(7,joinMember.getAge());
			
			if(pstmt.executeUpdate() > 0){
				msg = "회원가입 완료";
				nextPage = "login";
			}
		}
	}catch(Exception e){
		msg = "회원가입 실패";
		nextPage = "join";
	}finally{
		JDBCUtil.close(rs,pstmt,conn);
		out.print("<script>");
		out.print("alert('"+msg+"');");
		out.print("location.href='index.jsp?page="+nextPage+"';");
		out.print("</script>");
	}
	
%>












