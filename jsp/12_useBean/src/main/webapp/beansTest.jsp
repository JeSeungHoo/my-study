<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>beansTest.jsp</title>
</head>
<body>
	<h1>Beans Test</h1>
	<%
		test.Member m = null;
		if(pageContext.findAttribute("m") == null){
			m = new test.Member();
			System.out.println(m.getName());
			m.setName("박재민");
			pageContext.setAttribute("m",m);
		}else{
			m = (test.Member)pageContext.findAttribute("m");
		}
	%>
	<%= pageContext.getAttribute("m") %>
	<jsp:useBean id="aaa" class="test.Member" scope="page" />
	<jsp:useBean id="bbb" class="test.Member" scope="request"/>
	<jsp:useBean id="ccc" class="test.Member" scope="session"/>
	<jsp:useBean id="ddd" class="test.Member" scope="application"/>
	
	<jsp:setProperty name="aaa" property="name" value="박주신"/>
	<%=aaa.getName() %>
	<br/>
	<%
		test.Member member
		= (test.Member)pageContext.getAttribute("aaa");
		out.println(member.getName()+"<br/>");
	%>
	<h3>
		<jsp:getProperty property="name" name="ddd"/>
	</h3>
</body>
</html>








