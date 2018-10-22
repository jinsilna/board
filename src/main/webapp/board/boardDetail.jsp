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




				<h4>자유게시판 상세화면</h4>
				<hr>
				<!--  get으로 보내는이유는 게시판이기떄문에  -->
				<form id="frm">
					<div>
						<label> 제목 </label>
						<hr>
					</div>
					<div>
						<label> 글 내용 </label>
						<hr>
					</div>
					<div>
						<label> 첨부파일 </label>
						<hr>
					</div>
					<div>
						<label> 댓글 </label>
						<hr>
					</div>
					
				</form>
				<form action="#" method="get">
					<div class="form-group">
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="hidden" name="userId" value="">
								<button type="submit" class="btn btn-default">수정하기</button>
							</div>
						</div>
						<div class="col-sm-10"></div>
					</div>
				</form>
				<form action="#" method="get">
					<div class="form-group">
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="hidden" name="userId" value="">
								<button type="submit" class="btn btn-default">저장하기</button>
							</div>
						</div>
						<div class="col-sm-10"></div>
					</div>
				</form>

			</div>
		</div>
	</div>
</head>
</body>

</html>
