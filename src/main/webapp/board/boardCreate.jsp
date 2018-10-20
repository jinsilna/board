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
<title>boardCreate.jsp</title>

<script type="text/javascript">
	$(document).ready(
			function() {
				$(".addBoardPan").on(
						"click",
						function() {
							var boardManager = $("#addBoardParam").children(
									".addPan").eq(0).val();
							$("#pan_Name").val(boardManager);
							boardManager = $("#addBoardParam").children(
									".addPan").eq(1).val();
							$("#pan_Del").val(boardManager);
							$("#frm").submit();
							//console.log($("#frm").serialize());
						});
				$(".updateBoardPan").on("click", function() {
					//감싸고있는 상위요소.on("","클릭 대상 요소",펑션)
					var boardManager = $(this).parent()[0].children[1].value
					$("#pan_Name").val(boardManager);
					boardManager = $(this).parent()[0].children[2].value
					$("#pan_Del").val(boardManager);
					$("#frm").submit();
					//console.log($("#frm").serialize());
				});
			});
</script>
<%-- basiclb --%>
<%@include file="/common/basiclb.jsp"%>
</head>
<body>
	<form id="frm" action="/boardCreate" method="post">
		<input type="hidden" name="userId" value="${user.userId}"> <input
			id="pan_Name" type="hidden" name="pan_Name"> <input
			id="pan_Del" type="hidden" name="pan_Del">
	</form>
	<%-- header --%>
	<%@include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%-- left --%>
			<%@include file="/common/left.jsp"%>

			<div class="container-fluid">
				<div class="row">

					<!-- left -->
					<%@ include file="/common/left.jsp"%>

					<div
						class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
						<div class="blog-post">
							<h2 class="sub-header">게시판 생성 및 수정</h2>
							<hr>
							<ul>
								<li id="addBoardParam"><label>추가</label> <input
									class="addPan" type="text" name="addPan_Name"
									placeholder="ex)입력하세요.." /> <select class="addPan"
									name="addPan_Del">
										<option value="Y">사용</option>
										<option value="N">미사용</option>
								</select>
									<button type="button" class="addBoardPan">등록</button></li>
							</ul>
							<hr>
							<c:forEach items="${boarduse }" var="board">
								<ul>
									<li class="updateBoardParam"><label> 수정 </label> <input
										type="text" name="boardPanName" value="${board.bor_Name }" />
										<select name="boardUse">
											<option value="Y"
												<c:if test="${board.bor_Use=='Y'}">selected</c:if>>사용</option>
											<option value="N"
												<c:if test="${board.bor_Use=='N'}">selected</c:if>>미사용</option>
									</select>
										<button type="button" class="updateBoardPan">등록</button></li>
								</ul>
							</c:forEach>

							<hr>
						</div>
					</div>
				</div>
</html>
</body>
