<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.UserVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>beansResult.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String email = request.getParameter("email");
	
	UserVO vo = new UserVO(name, addr, email);
	session.setAttribute("vo",vo);
%>
<%= session.getAttribute("vo")%> <br/>

<jsp:useBean id="userVO" class="test.UserVO" scope="session" />
<jsp:setProperty name="userVO" property="*"/>
<%-- 
<jsp:setProperty property="name" name="userVO"/>
<jsp:setProperty property="addr" name="userVO"/>
<jsp:setProperty property="email" name="userVO"/>
 --%>
<%= session.getAttribute("userVO") %>
</body>
</html>









