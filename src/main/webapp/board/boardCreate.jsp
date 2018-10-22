<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%-- header --%>
	<%@include file="/common/header.jsp"%>
			<%-- left --%>
			<%@include file="/common/left.jsp"%>


<script type="text/javascript">
$(document).ready(function() {  
	$(".labelhd").hide();
			$(".boardClick").on("click",function() {
				
				var board = this.parentElement.firstElementChild;
				var bor_id = board.nextElementSibling.innerText;
				var bor_name = board.nextElementSibling.nextElementSibling.value;
				var bor_use = board.nextElementSibling.nextElementSibling.nextElementSibling.value;
				
				$("#bor_Id").val(bor_id);
				$("#bor_Name").val(bor_name);
				$("#bor_Use").val(bor_use);
				$("#frm").submit();
			
			});
			
		});
</script>
<!-- 변화가 있는board 내용 담아주기 /boardCreate servlet으로 보낸다.. -->

	<form id="frm" action="/boardCreate" method="post">
		<input type="hidden" id="bor_Id" name="bor_Id"/> 
		 <input type="hidden" id="bor_Use" name="bor_Use"/> 
		 <input type="hidden" id="bor_Name" name="bor_Name"/> 
		 <input type="hidden" name="userId" value="${user.userId}"/>
	</form>
	<div class="container-flui2d">
		<div class="row">


			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="blog-post">
					<h2 class="sub-header">게시판 생성 및 수정</h2>
					<ul>
						<li class="board">
						<label>추가</label> 
						<label class = "labelhd"></label>
						<input id ="addboardName" type="text" placeholder="ex)입력하세요.." /> 
							<select class="addPan">
								<option value="Y">사용</option>
								<option value="N">미사용</option>
						</select> 
						<button type="button" class="boardClick">등록</button>
						</li>
					</ul>
					<hr>

					<!--boardList를 사용한 이유는 전체 board정보가 나와야 미사용 사용여부를 선택할 수 있으니깐  -->
					<c:forEach items="${boardList}" var="board">
						<ul>
							<li class="board">
							<label> 수정 </label> 
							<label class = "labelhd">${board.bor_Id}</label>
							<input type="text" value="${board.bor_Name}"/> 
								<select>
									<option value="Y"
										<c:if test="${board.bor_Use=='Y'}">selected</c:if>>사용
									</option>
									<option value="N"
										<c:if test="${board.bor_Use=='N'}">selected</c:if>>미사용
									</option>
								</select>
								<button type="button" class="boardClick">수정</button>
								</li>
							</ul>
					</c:forEach>

					<hr>
				</div>
			</div>
		</div>
	</div>
</body>
</html>