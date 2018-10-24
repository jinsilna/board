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
<title>writenew.jsp</title>

<%-- basiclb --%>
<%@include file="/common/basiclb.jsp"%>
</head>

<script type="text/javascript" src="/js/jquery-3.3.1.min.
js"></script>


<script src="/SE2/js/HuskyEZCreator.js"></script>

<script type="text/javascript">
	var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

	$(document).ready(function() {
		// Editor Setting
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors, // 전역변수 명과 동일해야 함.
			elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
			sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
			fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
			}
		});
	});
</script>
<body>
	<%-- header --%>
	<%@include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">


			<%-- left --%>
			<%@include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			 <div class="freewritenew_wrap">
				<h4>새글등록</h4>
				<hr>
				<!--  get으로 보내는이유는 게시판이기떄문에  -->
				<form id="frm">
					<div>
						<ul class="title_text">
							<li><label id = "title"> 제목 </label></li>
							<li><input type="text" class ="title"></li>
						</ul>
					</div>
					<div>
						<label> 내용 </label>
						<textarea name="smarteditor" id="smarteditor" rows="8" cols="100"
						 class ="cotent" style="width: 766px; height: 412px;"></textarea>
					</div>
				</form>
				<form action="/boardNewSaveServlet" method="get">
					<div class="form-group" >
						<div class="form-group" >
							<div class="col-sm-offset-2 col-sm-10"> 
								<input type="hidden" name="userId" value="${user.userId}">
								<button type="submit" class="savebutton">저장하기</button>
							</div>
						</div>
						<div class="col-sm-10"></div>
					</div>
				</form>

				</div>
			</div>
		</div>
	</div>
</head>
</body>

</html>
