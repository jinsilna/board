<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<title>boardDetail.jsp</title>
<style type="text/css">
.title {
	width: 405px;
	height: 30px;
}
</style>
<%-- basiclb --%>
<%@include file="/common/basiclb.jsp"%>
</head>

<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>

<body>
	<%-- header --%>
	<%@include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<%-- left --%>
			<%@include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<h4>수정 페이지</h4>
				<hr>
				<!--  get으로 보내는이유는 게시판이기떄문에  -->
				
				<form id="frm" action="/postUpdateSave"  method="get">
			 			<input type="hidden" name="postTitle" value="${postTitle}"/>
						<input type="hidden" name="postText" value="${postText}"/>
						<input type="hidden" name="postId" value="${postId}"/>
					
					<div>
						<label> 제목 </label> <br>
						<input class="title" type="text" value="${postTitle}" />
						<hr>
					</div>
					<div>
						<label> 글 내용 </label> <br>
						<textarea class ="cotent" cols="55" rows="4">${postText}</textarea>
						<hr>
					</div>
					<div>
						<label> 첨부파일 </label> 
						<br>
						<label>첨부파일 들어가는 자리</label>
							<button>수정</button>
							<button>삭제</button>
							<button>답글</button>
						<hr>
					</div>	
				<button type="submit">저장</button>
				</form>

			</div>
		</div>
	</div>
</head>
</body>

</html>
