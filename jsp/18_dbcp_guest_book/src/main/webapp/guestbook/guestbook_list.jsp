<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// locahost:8080/ => root 경로
	// /18_dbcp_guest_book -> contextPath
	String path = request.getContextPath();
%>
<!--  guestbook_list.jsp    -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 메세지 목록</title>
</head>
<body>
	<!-- 방명록 작성 전달을 위한 form tag -->
	<form action="<%=path%>/guestbook/guestbook_write.jsp" method="post">
		<table>
			<tr>
				<td colspan="3"><h1>방명록 작성</h1></td>
			</tr>
			<tr>
				<td colspan="2"></td>
				<td rowspan="4">
					<input style="margin-left:20px; width:100%; height:100px;" type="submit" value="메세지 남기기"/>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input name="guestName" type="text" style="width:100%;" />
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input name="password" type="password" style="width:100%;" />
				</td>
			</tr>
			<tr>
				<td>메세지</td>
				<td>
					<textarea name="message" cols="35" rows="3"></textarea>
				</td>
			</tr>
		</table>
	</form>
	<hr/>
<%@ page import="java.sql.*, util.DBCPUtil" %>
<%@ page import="java.util.*, vo.*" %>
<%
	int currentPage = 1; // 요청 들어온 현재 페이지 번호
	int pageCount = 5;	 // 한 페이지에 보여줄 게시물 수
	int startRow = 0;	 // 테이블에서 pageCount만큼 검색할 시작 인덱스
	int endRow = 0;	 	 // 테이블에서 검색할 게시물 수

	String paramPage = request.getParameter("page");
	if(paramPage != null){
		currentPage = Integer.parseInt(paramPage);
	}
	out.print("현재 요청 페이지 : " + currentPage);
	// 검색 할 방명록 게시물 시작 인덱스 번호
	startRow = (currentPage-1) * pageCount;
	// 검색할 방명록 게시물 개수
	endRow = pageCount;
	
	Connection conn = DBCPUtil.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<GuestBook> bookList = new ArrayList<>();
	
	// 게시물 검색
	String sql = "SELECT * FROM test_guestbook "
				 + " ORDER BY id DESC limit ?, ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, startRow);
	pstmt.setInt(2, endRow);
	rs = pstmt.executeQuery();
	while(rs.next()){
		GuestBook vo = new GuestBook(
			rs.getInt(1),
			rs.getString(2),
			rs.getString(3),
			rs.getString(4)
		);
		bookList.add(vo);
	}
	DBCPUtil.close(rs,pstmt);
	//=====================================
	// 페이징 블럭 처리
	sql = "SELECT count(id) FROM test_guestbook";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	
	// 전체 게시물 수
	int listCount = 0;	
	// 현재 페이지 블럭에 보여줄 시작 페이지 번호
	int startPage = 0;
	// 현재 페이지 블럭에 보여줄 마지막 페이지 번호
	int endPage = 0;
	// 전체 출력가능한 페이지 개수
	int maxPage = 0;
	// 한번에 보여줄 페이지 블럭 개수
	int displayPageNum = 5;
	
	if(rs.next()){
		listCount = rs.getInt(1);
	}
	maxPage = (listCount-1) / pageCount + 1;
	out.print("전체 페이지 블럭 수 : " + maxPage);
	// displayPageNum = 5
	// [1][2][3][4][5] -> [6][7][8][9][10] ...
	startPage = (currentPage - 1) / displayPageNum * displayPageNum + 1;
	endPage = startPage + (displayPageNum - 1);
	
	if(endPage > maxPage){
		endPage = maxPage;
	}
	DBCPUtil.close(rs,pstmt,conn);
%>
	<h1>방명록 리스트</h1>
	<%if(!bookList.isEmpty()){ %>
		<table border="1" cellspacing="0" cellpadding="10">
			<% for(GuestBook gb : bookList){ %>
				<tr>
					<td>
						메세지 번호 : <%=gb.getId() %> <br/>
						손님 이름 : <%=gb.getGuestName() %> <br/>
						메세지 : <%=gb.getMessage() %> <br/>
						<a href="<%=path%>/guestbook/guestbook_confirm.jsp?id=<%=gb.getId()%>">[삭제]</a>
					</td>
				</tr>
			<%}%>
		</table>
	<%}else{ %>
		<h2>등록된 메세지가 없습니다.</h2>
	<%} %>
	<hr/>
	<% if(startPage != 1){%>
		<a href="<%=path%>/guestbook/guestbook_list.jsp?page=1">[처음]</a>
		<a href="<%=path%>/guestbook/guestbook_list.jsp?page=<%=startPage-1%>">[이전]</a>
	<%} %>
	<%
		for(int i=startPage; i<=endPage; i++){
%>
		<a href="<%=path%>/guestbook/guestbook_list.jsp?page=<%=i%>">[<%=i%>]</a>
<%
		}
	%>
	<%if(endPage < maxPage){%>
		<a href="<%=path%>/guestbook/guestbook_list.jsp?page=<%=endPage+1%>">[다음]</a>
		<a href="<%=path%>/guestbook/guestbook_list.jsp?page=<%=maxPage%>">[마지막]</a>
	<%}%>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>













