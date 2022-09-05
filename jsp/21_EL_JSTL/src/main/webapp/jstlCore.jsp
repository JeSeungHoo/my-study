<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstlCore.jsp</title>
</head>
<body>
	<!-- 특정 영역 겍체에 속성값을 추가 -->
	<!-- scope -->
	<c:set var="varPage" value="pageContext 저장" scope="page" />
	EL : ${pageScope.varPage} <br/>
	<%
		String pageValue = "스크립트로 저장";
		pageContext.setAttribute("pageName",pageValue);
	%>
	EL : ${pageName} <br/>
	<!-- 속성 값 삭제 -->
	<!-- removeAttribute -->
	<c:remove var="pageName" scope="page" />
	EL remove : ${pageName} <br/>
	<hr/>
	out : <c:out value="${varPage}"/>
	<c:set var="test1" value="<script>alert('박주신 메롱');</script>"/>
	test1 : <c:out value="${test1}" escapeXml="true"/>
	<br/>
	test2 : <c:out value="${test2}" default="test2는 존재하지 않습니다." />
	<br/>
	test3 : <c:out value="${test3}">test3는 존재하지 않습니다.</c:out>
	<hr/>
	<jsp:useBean id="member" class="vo.MemberVO" scope="page"/>
	${member} <br/>
	<c:set target="${member}" property="id" value="id001"/>
	${member} <br/>
	<hr/>
	<!-- 지정된 경로에 contextPath를 자동으로 부여 -->
	<a href="/21_EL_JSTL/index.jsp">index</a> <br/>
	<c:url var="pageLink" value="/index.jsp" />
	${pageLink} : <a href='${pageLink}'>url index</a>
	<br/>
	<a href="<c:url value='/index.jsp'/>">url index</a>
	<c:url value="/test/test.jsp"/>
	<br/> <hr/>
	<!-- response.sendRedirect("jstlCoreTest2.jsp"); -->
	<%-- <c:redirect url="jstlCoreTest2.jsp"/> --%>
	<!-- include와 동일 -->
	<div>
		<c:import url="jstlCoreTest2.jsp">
			<c:param name="name" value="최기근"/>
		</c:import>
	</div>
	<br/><br/><br/><br/><hr/>
	<div>
		<%-- <jsp:include page="https://www.naver.com" /> --%>
		<c:import url="https://www.naver.com"/>
	</div>
</body>
</html>











