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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	$("#savebutton").click(function(event) {

		var post_name = $("#post_name").val();

		if (post_name == "") {
			alert("제목을 입력해 주세요");
			event.preventDefault();
		}

	});
</script>

<style type="text/css">
.post_name_div {
	width: 700px
}
</style>


</head>
<body class="se2_inputarea" style="height: 0; -webkit-nbsp-mode: normal">

	<%@ include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h3>새글작성</h3>
				<hr />

				<form action="/boardNewSaveServlet" method="post" id="frm"
					enctype="multipart/form-data">

					<input class="btn btn-default" type="hidden" name="b0p"
						value="${boardVo.brd_id }" readonly="readonly" /> <input
						class="btn btn-default" type="hidden" name="post_pare"
						value="${post_pare }" readonly="readonly" />
					<div class="post_name_div">
						<div class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">제목</label>
								<div class="col-sm-10">
									<input class="form-control" id="post_name" type="text"
										name="post_name" />
								</div>
							</div>
						</div>
					</div>

					<br />

					<!-- SE2 스크립트 -->
					<%@ include file="/SE2/index.jsp"%>
				</form>
			</div>
		</div>
	</div>
</body>
</html>