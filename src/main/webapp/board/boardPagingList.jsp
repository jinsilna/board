<%@page import="kr.or.ddit.board.model.PostVo"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>boardPagingList.jsp</title>
<%-- basiclb --%>
<%@include file="/common/basiclb.jsp"%>
<!-- cursor pointer : 손가락 모양으로바뀜 -->
<style type="text/css">
	.userClick{
		cursor : pointer;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){

		console.log("document.ready");
		
		// tr에 대해 select (class="userClick")
		$(".userClick").on("click",function(){
			console.log("userClick");
			var post_Id =$(this).children()[1].innerText;
			$("#post_Id").val(post_Id);
			  $("#frm").submit();
		});
	});
</script>
</head>


<form  id = "frm" action="/postDetail" method="get">
	<input type = "hidden" id = "post_Id" name = "post_Id"/>
	<input type = "hidden" id = "userId" name = "${user.userId }"/>
	<input type="hidden" id="postTitle" name="postTitle" value = "${vo.post_Title}"/>
	<input type="hidden"  id="postText" name="postText" value="${vo.post_Cotenet} ">
	
</form>


<body>
	<%-- header --%>
	<%@include file="/common/header.jsp"%>
	 
	
	<div class="container-fluid">
		<div class="row">
			<%-- left --%>
			<%@include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">${bor_Name}</h2>
		<div class="table-responsive">
			<table class="table table-striped table-hover" >
				<tr>
					<th>No</th>
					<th>게시글 번호</th>
					<th>제목</th>
					<th>작성자 Id</th>	
					<th>작성일시</th>
				</tr>
			
			 	<c:forEach items="${pageList}" var = "vo" >
			 		 
				<tr class= "userClick">
					<td>${vo.rnum}</td>
					<td>${vo.post_Id}</td>
					<td>${vo.post_Title}</td>
					<td>${vo.userId}</td>
					<td>${vo.post_Date}</td>
				</tr>
				</c:forEach> 
			</table>
		</div>

			<form action="/boardNewServlet" method="get">
					<div class="form-group" >
						<div class="form-group" >
							<div class="col-sm-offset-2 col-sm-10"> 
								<input type = "hidden" id = "post_Id" name = "post_Id"/>
								<button type="submit" class="savebutton">새글 작성</button>
							</div>
						</div>
						<div class="col-sm-10"></div>
					</div>
				</form>

		<div class="text-center">
			<ul class="pagination">
				 	<li>
				     	 <a href="/boardPaging?page=1&pageSize=10" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      	</a>
		    		</li>
						<%-- <% int pageCnt = (Integer)request.getAttribute("pageCnt"); 
							for(int p = 1; p <= pageCnt; p++){
						%>
						<li><a href="/userPagingList?page=<%=p%>&pageSize=10"><%=p%></a></li>
						<%} %>
						<li>
						      <a href="/userPagingList?page=<%=pageCnt%>&pageSize=10" aria-label="Next"> --%>
				      
				      <c:forEach begin="1" end="${pageCnt}" var="p">
					      <li>
					      	<a href="/boardPaging?page=${p}&pageSize=10">${p}</a>
					      </li>
				      </c:forEach>
				     	  <li>
				     		 <a href="/boardPaging?page=${pageCnt}>&pageSize=10" aria-label="Next"> 
				      			<span aria-hidden="true">&raquo;</span>
				      		</a>
  				 		 </li>
						</ul>
					</div>
				</div>
			</div>
			</div>
		</div>
	</div>

</body>
</html>
