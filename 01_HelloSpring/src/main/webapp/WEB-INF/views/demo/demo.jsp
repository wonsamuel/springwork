<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="HelloSpring" name="title"/>  
</jsp:include>

<section id="container">
	<div id="demo-container">
		<form id="devFrm" method="post">
			<div class="form-group row">
				<label for="devName" class="col-sm-2 col-form-label">이름</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="devName" name="devName"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="devAge" class="col-sm-2 col-form-label">나이</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="devAge" name="devAge"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="devEmail" class="col-sm-2 col-form-label">이메일</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="devEmail" name="devEmail"/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">성별</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="devGender"
						id="devGender0" value="M"/>
						<label class="form-check-label" for="devGender0">남</label>
						<input class="form-check-input" type="radio" name="devGender"
						id="devGender1" value="F"/>
						<label class="form-check-label" for="devGender1">여</label>
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">개발언어</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" name="devLang"
						id="devLang0" value="Java"/>
						<label class="form-check-label" for="devLang0">Java</label>
					</div>	
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" name="devLang"
						id="devLang1" value="C"/>
						<label class="form-check-label" for="devLang1">C</label>
					</div>	
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" name="devLang"
						id="devLang2" value="Javascript"/>
						<label class="form-check-label" for="devLang2">Javascript</label>
					</div>
				</div>
			</div>
			<div class="list-group">
				<button type="button" class="list-group-item list-group-item-action" onclick="demo('${path}/demo/basicParam.do');">기본파라미터 처리하기</button>
				<button type="button" class="list-group-item list-group-item-action" onclick="demo('${path}/demo/requestParam.do');">@RequestParam으로 처리하기</button>
				<button type="button" class="list-group-item list-group-item-action" onclick="demo('${path}/demo/requestMap.do');">Map으로 처리하기</button>
				<button type="button" class="list-group-item list-group-item-action" onclick="demo('${path}/demo/requestCommand.do');">Command(vo)으로 처리하기</button>
			</div>
		</form>
	</div>
	
	<script>
		function demo(path){
			$("#devFrm").attr("action", path);  /* action이 없어서 속성 넣고 경로 넣어줌 */
			$("#devFrm").submit(); 
		}
	</script>
	
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>