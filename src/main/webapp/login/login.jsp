<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login.jsp</title>
<%@include file="/common/basiclb.jsp"%>
<script type="text/javascript">

 
</script>
<%-- signin.css가져오기 // 위에 처럼 include로 가져올 수 없다. --%>
<link 

href="/css/signin.css" rel="stylesheet">
</head>
<body>
	<!-- 
	    http://localhost:8081/login/login.jsp
		로그인처리 
	 	login.jsp (사용자 아이디랑 비밀번호를 입력 )
		loginProcess.jsp 으로 요청 
	 -->
	 <%-- 브라우저 주소줄에 입력한 경우 : get
	 	  form 태그의 method 속성 : get/post
	  
	  	  GET - 값을 넘겨줄때 주소창에 아이디랑 비밀번호가 표시 
	  	  POST - 값을 넘겨줄때 주소창에 아이디랑 비밀번호가 표시안됌.
	  --%>
	  
	  <%-- remember-me (사용자 아이디 기억하기)
	  		1. remember-me input (checkbox) 파라미터를 
	  			login 요청시 전송
	  			(userId, pass --> userId ,pass,remember-me)
	  		2. /dditLogin(LoginServlet)
	  			remember-me 파라미터를 확인
	  		2-1) 아이디 기억하기 사용 
	  			response 객체에 remember-me cookie 생성
	  		2-2) 아이디 기억하기 사용하지 않기
	  			response 객체에 remember-me cookie 삭제 
	  		3. 쿠키 값에 따라 remember-me checkbox 설정하기 
	  			login.jsp
	  			
	   --%>
	   <div class="container">
           <form class="form-signin" action="/loginServlet" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">userId</label>
        <input type="text" name="userId" id = "userId"class="form-control" placeholder="userId" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password"  name="password" id = "password" class="form-control" placeholder="Password" required>
         <div class="checkbox">

        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
</body>
</html>














