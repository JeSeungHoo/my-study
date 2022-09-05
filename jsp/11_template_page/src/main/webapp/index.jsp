<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String nextPage = request.getParameter("page");
	if(nextPage == null){
		nextPage = "default";
	}
	// default , intro, map
	nextPage = nextPage+".jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		margin:0 auto;
		text-align:center;
		border:1px solid black;
		width:900px;
	}
	
	table tr td:first-child{
		border-right:1px solid gray;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th colspan="2" height="150">
				<jsp:include page="header.jsp"/>
			</th>
		</tr>
		<tr>
			<td>
				<jsp:include page="aside.jsp" />
			</td>
			<td width="790">
				<jsp:include page="<%=nextPage%>" />
			</td>
		</tr>
		<tr>
			<th colspan="2" height="150">
				<jsp:include page="footer.jsp"/>
			</th>
		</tr>
	</table>
</body>
</html>






