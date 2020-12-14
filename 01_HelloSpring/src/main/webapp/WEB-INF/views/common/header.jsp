<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.title }</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div id="header-container">
			<h2>${param.title }</h2>
		</div>
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-brand" href="#">
					<img src="${path }/resources/images/logo-spring.png" alt="로고스프링" width="50px"/>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" 
					data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" 
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/board/boardList">게시판</a></li>
<%-- 						<li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}/demo/demo.do">Demo등록</a>
						</li> --%>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" 
							id="navbarDropdown" role="button" data-toggle="dropdown"
							aria-haspopup="true" aria-expand="false">DEMO</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="${path }/demo/demo.do">Demo등록</a>
								<a class="dropdown-item" href="${path }/demo/selectDemo.do">Demo목록</a>
							</div>
						</li>
						<li class="nav-item">
							<a href="${path }/memo/memo.do" class="nav-link">메모</a>
						</li>
					</ul>
					<c:if test="${loginMember==null }">
						<button class="btn btn-outline-success my-2 my-sm-0" type="button" data-toggle="modal" data-target="#loginModal">로그인</button>&nbsp;&nbsp;
						<button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="location.replace('${path}/member/insertMember.do')">회원가입</button>
					</c:if>
					<c:if test="${loginMember!=null }">
						<button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="accessChatting();">채팅하기</button>&nbsp;&nbsp;
						<span>
							<a href="#"><c:out value="${loginMember.userName }"/>님, 안녕하세요!</a>
						</span>&nbsp;
						<button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="location.replace('${path}/member/logout.do')">로그아웃</button>
					</c:if>					
				</div>
			</nav>
		</header>
		<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" 
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">로그인</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
	          <form action="${pageContext.request.contextPath}/member/memberLogin.do" method="post">
		      <div class="modal-body">
				    <input type="text" class="form-control" name="userId" placeholder="아이디" required>
				    <br />
				    <input type="password" class="form-control" name="password" placeholder="비밀번호" required>
		      </div>
		      <div class="modal-footer">
		        <button type="submit" class="btn btn-outline-success" >로그인</button>
		        <button type="button" class="btn btn-outline-success" data-dismiss="modal">취소</button>
		      </div>
			  </form>
		    </div>
		  </div>
		</div>
		
		
		<script>
			function accessChatting(){
				open("${path}/chatView.do","_blank","width=400,height=600");
			}
		</script>