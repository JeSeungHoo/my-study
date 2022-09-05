<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- guestbook/guestbook_confirm.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 메세지 삭제 확인</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
	%>
	<form action="guestbook_delete.jsp" method="POST">
		<input type="hidden" name="id" value="<%=id%>" />
		메세지를 삭제하시려면 비밀번호를 입력하세요 <br/>
		암호 : <input type="password" name="password"/> <br/>
		<input type="submit" value="메세지 삭제하기"/>
	</form>
</body>
</html>











