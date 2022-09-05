<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		// 클라이언트 브라우저에 저장된 Cookie 항목
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie c : cookies){
				System.out.println("name : "+c.getName());
				System.out.println("value : "+c.getValue());
				System.out.println("domain : "+c.getDomain());
			}
		}
		/*
		// Cookie 생성
		Cookie cookie = new Cookie("target","PJS");
		// cookie 유지 시간
		cookie.setMaxAge(60*60*24*15);
		cookie.setPath("/");
		// cookie.setDomain("192.168.1.113");
		response.addCookie(cookie);
		*/
		
		// Cookie 삭제
		Cookie cookie = new Cookie("target","");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		response.sendRedirect("member/index.jsp");
	%>
	
</body>
</html>









