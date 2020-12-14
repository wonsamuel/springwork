<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="HelloSpring" name="title"/>  
</jsp:include>

<style>
    /*중복아이디체크관련*/
    div#userId-container{position:relative; padding:0px;}
    div#userId-container span.guide{display:none;font-size: 12px;position:absolute; top:12px; right:10px;}
    div#userId-container span.ok{color:green;}
    div#userId-container span.error{color:red;}
</style>

<section id="container">
				<div id="enroll-container">
					<form name="memberEnrollFrm" action="${path}/member/memberEnrollEnd.do" method="post" onsubmit="return validate();" >
						<div id="userId-container">
							<input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="userId" id="userId_" required>
							<span class="guide ok">이 아이디는 사용이 가능합니다.</span>
							<span class="guide error">이 아이디는 사용할 수 없습니다.</span>
						</div>
						<input type="password" class="form-control" placeholder="비밀번호" name="password" id="password_" required>
						<input type="password" class="form-control" placeholder="비밀번호확인" id="password2" required>
						<input type="text" class="form-control" placeholder="이름" name="userName" id="userName" required>
						<input type="number" class="form-control" placeholder="나이" name="age" id="age">
						<input type="email" class="form-control" placeholder="이메일" name="email" id="email" required>
						<input type="tel" class="form-control" placeholder="전화번호 (예:01012345678)" name="phone" id="phone" maxlength="11" required>
						<input type="text" class="form-control" placeholder="주소" name="address" id="address">
						<select class="form-control" name="gender" required>
							<option value="" disabled selected>성별</option>
							<option value="M">남</option>
							<option value="F">여</option>
						</select>
						<div class="form-check-inline form-check">
							취미 : &nbsp; 
							<input type="checkbox" class="form-check-input" name="hobby" id="hobby0" value="운동"><label for="hobby0" class="form-check-label">운동</label>&nbsp;
							<input type="checkbox" class="form-check-input" name="hobby" id="hobby1" value="등산"><label for="hobby1" class="form-check-label">등산</label>&nbsp;
							<input type="checkbox" class="form-check-input" name="hobby" id="hobby2" value="독서"><label for="hobby2" class="form-check-label">독서</label>&nbsp;
							<input type="checkbox" class="form-check-input" name="hobby" id="hobby3" value="게임"><label for="hobby3" class="form-check-label">게임</label>&nbsp;
							<input type="checkbox" class="form-check-input" name="hobby" id="hobby4" value="여행"><label for="hobby4" class="form-check-label">여행</label>&nbsp;
						</div>
						<br />
						<input type="submit" class="btn btn-outline-success" value="가입" >&nbsp;
						<input type="reset" class="btn btn-outline-success" value="취소">
					</form>
				</div>
	
	<script>
		$(function(){
			$("#userId_").keyup(function(){
				const id = $(this).val();
				if(id.trim().length>4) {
					$.ajax({
						//url:"${path}/member/checkId",    --> ServletOutpuStream 방식
						//url:"${path}/member/checkIdJsonView",   --> JsonResolver & jsonView객체를 이용
						url:"${path}/member/checkIdResponse",     //ResponseBody 방식
						data:{userId:id},
						success:function(data){
							console.log(data);
							//if(data=='false'){    --> ServletOutpuStream 방식
							//if(!data.flag) {        //--> JsonResolver & jsonView객체를 이용
							if(!data) {            //-->  ResponseBody 방식
								$(".guide.ok").hide();
								$(".guide.error").show();
							}else{
								$(".guide.ok").show();
								$(".guide.error").hide();
							}
						}
					});
				} else {
					$(".guide").hide();
					return;
				}
			})
		})
	</script>
	
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>