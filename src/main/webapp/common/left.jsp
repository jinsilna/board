<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
			<li class="active">
				<a href="/main.jsp">Main 
				<span class="sr-only">(current)</span>
				</a>
			</li>
		<!-- @WebServlet("/userAllList") UserServlet에서 설정한 이름 값으로  -->
		<li class="active">
			<a href="/board/boardCreate.jsp">게시판생성 </a>
			<c:forEach items="${boarduse}" var="board">
		</li>
				<li class="active" >
				<a href="/boardPaging?page=1&pageSize=10&bor_Name=${board.bor_Name}&bor_Id=${board.bor_Id}">${board.bor_Name}</a>
				
		</li>
			</c:forEach>
		<!-- 사용자 리스트 클릭시 : jspuser 전체 정보를 조회하여 화면에 출력
			
			0. 요청을 처리할 서블릿 생성 : UserServlet
			1. jspuser 전체정보 조회  : userService.selectUserAll() 
			2. 사용자 정보를 화면에 출력할 jsp : userAllList.jsp
	
		 -->
	</ul>
</div>