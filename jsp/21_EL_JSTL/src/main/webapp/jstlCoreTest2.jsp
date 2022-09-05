<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstlCoreTest2.jsp</title>
</head>
<body>
	<h1>jstlCoreTest2</h1>
	<h2>parameter name - ${param.name}</h2>
	<h1>제어문</h1>
	<core:set var="myCar" value="red" />
	<core:if test="${myCar eq 'red'}">
		내차는 빨간색 <br/>
	</core:if>
	
	<core:if test="${param.name eq '박주신'}">
		내이름은 박주신 ! <br/>
	</core:if>
	<core:set var="grade" value="95"/>
	
	<core:choose>
		<core:when test="${grade >= 90}">
			A학점
		</core:when>
		<core:when test="${grade >= 80}">
			B학점
		</core:when>
		<core:when test="${grade >= 70}">
			C학점
		</core:when>
		<core:otherwise>
			F학점
		</core:otherwise>
	</core:choose>
	
	<%
		int[] nums = {10,9,8,7,6,5,4,3,2,1};
		request.setAttribute("nums",nums);
	%>
	<% for(int i : nums) {%>
		<%=i%>
	<%}%>
	<br/>
	<core:forEach var="n" items="${nums}">
		${n} &nbsp;&nbsp;
	</core:forEach>
	<br/><br/>
	<!-- step="3" i+=3 -->
	<core:forEach var="i" begin="1" end="100" step="3">
		${i} &nbsp;
	</core:forEach>
	<br/>
	<core:set var="data" value="권능환,박주신,하옥형,이주명,박정대" />
	<core:forTokens var="name" items="${data}" delims=",">
		${name} &nbsp;
	</core:forTokens>
<%
	java.util.ArrayList<String> list
			= new java.util.ArrayList<>();
	list.add("리트리버");
	list.add("시베리안 허스키");
	list.add("주주");
	list.add("푸들");
	list.add("말라뮤트");
	list.add("샤모에드");
	request.setAttribute("dogList",list);
%>
<br/>
	<core:choose>
		<core:when test="${!empty dogList}">
			<core:forEach var="dog" items="${dogList}">
				${dog} &nbsp;
				<core:if test="${dog eq '주주'}">
					박주신 배신자... 
				</core:if>
			</core:forEach>
		</core:when>
		<core:otherwise>
			목록이 존재하지 않습니다.
		</core:otherwise>
	</core:choose>
</body>
</html>













