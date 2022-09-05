<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstlFmtTest.jsp</title>
</head>
<body>
	<f:requestEncoding value="UTF-8"/>
	<c:out value="${param.addr}"/> <br/>
	<c:out value="${param.encode}"/> <br/>
	<%= response.getLocale() %>
	<c:if test="${!empty param.encode}">
		<c:set var="encode" value="${param.encode}"/>
	</c:if>
	<f:setLocale value="${encode}"/>
	<br/>
	현재 locale : <%= response.getLocale() %>
	<br/>
	<h3>다국어 처리 지원 - bundle</h3>
	<f:bundle basename="bundle">
		<f:message key="name"/>
		<f:message key="name_en"/>
	</f:bundle>
	<br/>
	<hr/>
	<f:bundle basename="prop/bundle">
		<f:message var="name" key="name"/>
		<f:message var="addr" key="addr">
			<f:param value="${param.addr}"/>
			<f:param value="84"/>
		</f:message>
		<f:message var="phone" key="phone"/>
	</f:bundle>
	
	이름 : ${name}  <br/>
	주소 : ${addr}  <br/>
	전번 : ${phone} <br/>
	<hr/>
	<h2>날짜 형식 지정</h2>
	<jsp:useBean id="now" class="java.util.Date" />
	java.util.Date : <c:out value="${now}"/> <br/>
	<!-- type(default:date)
	 date(날짜) / time(시간) / both(둘다)
 	-->
	<f:formatDate value="${now}" type="date" /> <br/>
	<!--
	 style 
	 full / long / medium(default) / short
	-->
	<f:formatDate value="${now}" dateStyle="full" />
	<h3>시간</h3>
	<f:formatDate value="${now}" type="time" /> <br/>
	<f:formatDate value="${now}" type="time" timeStyle="full"/>
	<h3>both</h3>
	<f:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long"/>
	<h3>pattern</h3>
	<f:formatDate value="${now}" pattern="yyyy-MM-dd hh:mm:ss"/>
	<h3>parseDate - ${param.selectDate}</h3>
	<f:parseDate var="now" value="${param.selectDate}" pattern="yyyy-MM-dd" scope="page"/>
	parseDate : <c:out value="${now}"/>
	<hr/>
	<h2>Number Formatter</h2>
	<c:set var="price" value="10000000"/>
	price : ${price} <br/>
	<!-- number, currency -->
	<f:formatNumber var="numberType" 
					type="number" value="${price}"/>
	numberType : ${numberType} <br/>
	<!-- 통화형식 -->
	기호 : <f:formatNumber type="currency" value="${price}"/>
	<br/>
	<f:setLocale value="en_US"/>
	미국 달러 : <f:formatNumber type="currency" value="${price}"/>
	<br/>
	<h3>pattern</h3>
	<!-- ￦ ㄹ + 한자키 + 3 -->
	<f:formatNumber value="${price}" pattern="￦0,000.00"/>
</body>
</html>












